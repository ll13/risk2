package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import data.Read;
import data.Write;
import vo.RiskItem;
import vo.RiskType;
import vo.Sum;

public class RiskItemDao {
	ArrayList<RiskItem> riskItemlist = new ArrayList<RiskItem>();
	Read read = new Read();
	Write write = new Write();

	public String[][] listToSet() {
		String riskItemset[][] = null;
		if (riskItemlist == null || riskItemlist.size() == 0) {
			return riskItemset;
		}
		riskItemset = new String[riskItemlist.size()][11];
		for (int i = 0; i < riskItemlist.size(); i++) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			riskItemset[i][0] = df.format(riskItemlist.get(i).getDate());
			riskItemset[i][1] = riskItemlist.get(i).getName();
			riskItemset[i][2] = riskItemlist.get(i).getType();
			riskItemset[i][3] = riskItemlist.get(i).getPossible();
			riskItemset[i][4] = riskItemlist.get(i).getInfluence();
			riskItemset[i][5] = riskItemlist.get(i).getCommit();
			riskItemset[i][6] = riskItemlist.get(i).getFollow();
			riskItemset[i][7] = riskItemlist.get(i).getIsNew();
			riskItemset[i][8] = riskItemlist.get(i).getStatus();
			riskItemset[i][9] = riskItemlist.get(i).getSolution();
			riskItemset[i][10] = riskItemlist.get(i).getRa();

		}
		return riskItemset;

	}

	public void setToList(String[][] riskItemset) {
		riskItemlist = new ArrayList<RiskItem>();
		if (riskItemset.length > 0) {
			for (int i = 0; i < riskItemset.length; i++) {
				RiskItem riskItem = new RiskItem();
				Calendar c = Calendar.getInstance();
				String time[] = riskItemset[i][0].split("/");
				c.set(Integer.parseInt(time[0]), Integer.parseInt(time[1]) - 1, Integer.parseInt(time[2]));
				Date date = c.getTime();
				riskItem.setDate(date);
				riskItem.setName(riskItemset[i][1]);
				riskItem.setType(riskItemset[i][2]);
				riskItem.setPossible(riskItemset[i][3]);
				riskItem.setInfluence(riskItemset[i][4]);
				riskItem.setCommit(riskItemset[i][5]);
				riskItem.setFollow(riskItemset[i][6]);
				riskItem.setIsNew(riskItemset[i][7]);
				riskItem.setStatus(riskItemset[i][8]);
				riskItem.setSolution(riskItemset[i][9]);
				riskItem.setRa(riskItemset[i][10]);
				riskItemlist.add(riskItem);
			}
		}
	}

	public void read() {
		String[][] set = read.readData("riskItem.txt");
		this.setToList(set);
	}

	public void write() {
		String[][] set = this.listToSet();
		write.writeData("riskItem.txt", set);
	}

	public void add(RiskItem riskItem) {
		this.read();
		riskItem=this.rightStatus(riskItem);
		riskItemlist.add(riskItem);
		this.write();
	}

	public ArrayList<RiskItem> find(ArrayList<RiskItem> result, String name) {
		this.read();
		for (int i = 0; i < riskItemlist.size(); i++) {
			RiskItem compare = riskItemlist.get(i);
			if (compare.getName().equals(name)) {
				result.add(compare);
			}
		}
		return result;
	}

	public void update(RiskItem riskItem) {
		this.read();
		ArrayList<RiskItem> old = new ArrayList<RiskItem>();
		old = this.find(old, riskItem.getName());
		riskItemlist = this.delete(riskItemlist, riskItem.getName());
		for (int i = 0; i < old.size(); i++) {
			RiskItem riskItemChange = old.get(i);
			riskItemChange.setIsNew("不是");
			riskItem=this.rightStatus(riskItem);
			riskItemlist.add(riskItemChange);
		}
		riskItemlist.add(riskItem);
		this.write();

	}

	public ArrayList<RiskItem> delete(ArrayList<RiskItem> list, String name) {
		this.read();
		for (int i = 0; i < riskItemlist.size(); i++) {
			RiskItem compare = riskItemlist.get(i);
			if (compare.getName().equals(name)) {
				list.remove(i);
			}
		}
		return list;
	}

	public ArrayList<RiskItem> list() {
		this.read();
		ArrayList<RiskItem> result = new ArrayList<RiskItem>();
		for (int i = 0; i < riskItemlist.size(); i++) {
			if (riskItemlist.get(i).getIsNew().equals("是")) {
				result.add(riskItemlist.get(i));
			}
		}
		return result;
	}
	public ArrayList<RiskItem> beginEnd(ArrayList<RiskItem> result,String beginS,String endS) {
		this.read();		
		Calendar begin = Calendar.getInstance();
		Calendar end = Calendar.getInstance();
		Calendar compare = Calendar.getInstance();
		String begintime[] =beginS.split("/") ;
		String endtime[] = endS.split("/");
		begin.set(Integer.parseInt(begintime[0]), Integer.parseInt(begintime[1]) - 1, Integer.parseInt(begintime[2]));
		end.set(Integer.parseInt(endtime[0]), Integer.parseInt(endtime[1]) - 1, Integer.parseInt(endtime[2]));
		long beginMi=begin.getTimeInMillis();
		long endMi=end.getTimeInMillis();
		for(int i=0;i<riskItemlist.size();i++){
			compare.setTime(riskItemlist.get(i).getDate());
			long compareMi=compare.getTimeInMillis();
			long bc=0,ec=0;
			bc=((compareMi-beginMi)/(1000*60*60*24));
			ec=((compareMi-endMi)/(1000*60*60*24));
			if(bc>=0){
				if(ec<=0){
					result.add(riskItemlist.get(i));
				}
			}
		}
		
		return result;
	}
	public  ArrayList<Sum> listGat(ArrayList<Sum> sumlist){
		this.read();
		sumlist=this.sort(riskItemlist);
		return sumlist;
	}
	public  ArrayList<Sum> listProblem(ArrayList<Sum> sumlist){
		this.read();
		ArrayList<RiskItem> temp=new ArrayList<RiskItem>();
		temp=this.isProblem(riskItemlist);
		sumlist=this.sort(temp);
		return sumlist;
	}
	public  ArrayList<Sum> listGat(ArrayList<Sum> sumlist,String begin,String end){
		this.read();
		ArrayList<RiskItem> temp=new ArrayList<RiskItem>();
		temp=this.beginEnd(temp, begin, end);
		sumlist=this.sort(temp);
		return sumlist;
	}
	public  ArrayList<Sum> listProblem(ArrayList<Sum> sumlist,String begin,String end){
		this.read();
		ArrayList<RiskItem> temp=new ArrayList<RiskItem>();
		temp=this.beginEnd(temp, begin, end);
		temp=this.isProblem(temp);
		sumlist=this.sort(temp);
		return sumlist;
	}
	public ArrayList<Sum> sort(ArrayList<RiskItem> input){
		ArrayList<Sum> output=new ArrayList<Sum>();
		while(input.size()>0){
			RiskItem compare= null;
			Sum sum=new Sum();
			int i=0;
			compare=input.get(i);
			sum.setName(compare.getName());
			sum.setNumber(sum.getNumber()+1);
			input.remove(i);
			while(input.size()>i){
					if(input.get(i).getName().equals(compare.getName())){
						sum.setNumber(sum.getNumber()+1);
						input.remove(i);
					}else{
						i++;
					}
			}
			output.add(sum);
		}
		return output;
	}
	public ArrayList<RiskItem> findGetMax(ArrayList<RiskItem> list,String begin ,String end){
		ArrayList <RiskItem> temp=new ArrayList <RiskItem>();
		temp=this.beginEnd(temp, begin, end);
		ArrayList<Sum> sumlist=this.sort(temp);
		temp=this.beginEnd(temp, begin, end);
		int max=0;
		String maxName="";
		for(int i=0;i<sumlist.size();i++){
			if(sumlist.get(i).getNumber()>max){
				max=sumlist.get(i).getNumber();
				maxName=sumlist.get(i).getName();
			}
		}
		for(int i=0;i<temp.size();i++){
			if(temp.get(i).getName().equals(maxName)){
				list.add(temp.get(i));
			}
		}
		return list;
	}
	public ArrayList<RiskItem> isProblem(ArrayList<RiskItem> input){
		ArrayList<RiskItem> output=new ArrayList<RiskItem>();
		for(int i=0;i<input.size();i++){
			if(input.get(i).getStatus().equals("问题")){
				output.add(input.get(i));
			}
		}
		return output;
	}
	public ArrayList<RiskItem> findProblemMax(ArrayList<RiskItem> list,String begin ,String end){
		ArrayList <RiskItem> temp=new ArrayList <RiskItem>();
		temp=this.beginEnd(temp, begin, end);
		temp=this.isProblem(temp);
		ArrayList<Sum> sumlist=this.sort(temp);
		temp=this.beginEnd(temp, begin, end);
		temp=this.isProblem(temp);
		int max=0;
		String maxName="";
		for(int i=0;i<sumlist.size();i++){
			if(sumlist.get(i).getNumber()>max){
				max=sumlist.get(i).getNumber();
				maxName=sumlist.get(i).getName();
			}
		}
		for(int i=0;i<temp.size();i++){
			if(temp.get(i).getName().equals(maxName)){
				list.add(temp.get(i));
			}
		}
		return list;
	}
	public ArrayList<RiskItem> listPlan(String planName) {
		this.read();
		ArrayList<RiskItem> result = new ArrayList<RiskItem>();
		for (int i = 0; i < riskItemlist.size(); i++) {
			if (riskItemlist.get(i).getIsNew().equals("是")) {
				if(riskItemlist.get(i).getRa().equals(planName)){
				    result.add(riskItemlist.get(i));}
			}
		}
		return result;
	}
	public void updatera(String riskName,String planName){
		this.read();
		for (int i = 0; i <riskItemlist .size(); i++) {
			if(riskItemlist.get(i).getName().equals(riskName)){
				riskItemlist.get(i).setRa(planName);
			}
		}
		this.write();

	}
    public RiskItem rightStatus(RiskItem riskItem){
    	RiskTypeDao risktypeDao=new RiskTypeDao();
		RiskType riskType=risktypeDao.find(riskItem.getType());
		
		if(riskType.getPossible().equals("")||riskType.getInfluence().equals("")){
			return riskItem;
		}
		if(riskType.getPossible().equals(riskItem.getPossible())){
			riskItem.setStatus("问题");
			return riskItem;
		}
		if(riskType.getInfluence().equals(riskItem.getInfluence())){
			riskItem.setStatus("问题");
			return riskItem;
		}
		if(riskType.getPossible().equals("低")){
			riskItem.setStatus("问题");
			return riskItem;
		}
		if(riskType.getInfluence().equals("低")){
			riskItem.setStatus("问题");
			return riskItem;
		}
		if(riskItem.getPossible().equals("高")){
			riskItem.setStatus("问题");
			return riskItem;
		}
		if(riskItem.getInfluence().equals("高")){
			riskItem.setStatus("问题");
			return riskItem;
		}
		return riskItem;
    }
}
