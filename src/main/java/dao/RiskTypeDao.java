package dao;

import java.util.ArrayList;

import data.Read;
import data.Write;
import vo.RiskType;

public class RiskTypeDao {
	ArrayList<RiskType> risktypelist=new ArrayList<RiskType>();
	Read read=new Read();
	Write write=new Write();
	
	public String[][] listToSet(){
		String risktypeset[][]=null;
		if(risktypelist==null||risktypelist.size()==0){
			return risktypeset;
		}
		risktypeset= new String[risktypelist.size()][3];
		for(int i=0;i<risktypelist.size();i++){
			risktypeset[i][0]=risktypelist.get(i).getType();
			risktypeset[i][1]=risktypelist.get(i).getPossible();
			risktypeset[i][2]=risktypelist.get(i).getInfluence();
			
		}
		return risktypeset;
		
	}
	public void setToList(String [][] risktypeset){
		risktypelist=new  ArrayList<RiskType>();
		if(risktypeset.length>0){
		for(int i=0;i<risktypeset.length;i++){
		  RiskType risktype=new RiskType();
		  risktype.setType(risktypeset[i][0]);
		  risktype.setPossible(risktypeset[i][1]);
		  risktype.setInfluence(risktypeset[i][2]);
		  risktypelist.add(risktype);
		}
	   }
	}
	
	   public void read(){
		   String[][] set= read.readData("riskType.txt");	   
		  this.setToList(set);
	   }
	   public void write(){
		   String [][]set=this.listToSet();
		   write.writeData("riskType.txt", set);
	   }
       
	   public void add(RiskType risktype){
		   this.read();
		   RiskType find=this.find(risktype.getType());
		   if(find==null){
		   risktypelist.add(risktype);	  
		   }
		   
		   this.write();
	   }
	   public boolean delete(String  type){
		   this.read();
		   boolean result=false; 
		   for(int i=0;i<risktypelist.size();i++){
			   RiskType compare=risktypelist.get(i);
			   if(compare.getType().equals(type)){
				   RiskType risktype=risktypelist.remove(i);
				   if(risktype!=null){
					   result=true;
				   }
			   }
		   }
		   this.write();
		   return result;
	   }
	   public RiskType find(String type){
		   this.read();
		   RiskType result=null;
		   for(int i=0;i<risktypelist.size();i++){
			   RiskType compare=risktypelist.get(i);
			   if(compare.getType().equals(type)){
				   result=compare;
				   return result;
			   }
		   }
		   return result;
	   }
	   
	 
	   
	 public ArrayList<RiskType> list(){
		 this.read();
		 return risktypelist;
	 }
	   
}
