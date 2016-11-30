package dao;

import java.util.ArrayList;
import data.Read;
import data.Write;
import vo.Plan;


public class PlanDao {
	ArrayList<Plan> planlist=new ArrayList<Plan>();
	Read read=new Read();
	Write write=new Write();
	
	public String[][] listToSet(){
		String planset[][]=null;
		if(planlist==null||planlist.size()==0){
			return planset;
		}
		planset= new String[planlist.size()][1];
		for(int i=0;i<planlist.size();i++){
			planset[i][0]=planlist.get(i).getName();
			
		}
		return planset;
		
	}
	public void setToList(String [][] planset){
		planlist=new  ArrayList<Plan>();
		if(planset.length>0){
		for(int i=0;i<planset.length;i++){
		  Plan plan=new Plan();
		  plan.setName(planset[i][0]);
		  
		}
	   }
	}
	
	   public void read(){
		   String[][] set= read.readData("plan.txt");	   
		  this.setToList(set);
	   }
	   public void write(){
		   String [][]set=this.listToSet();
		   write.writeData("plan.txt", set);
	   }
       
	   public void add(Plan plan){
		   this.read();
		   planlist.add(plan);	  
		  
		   this.write();
	   }
	   public ArrayList<Plan> list(){
			 this.read();
			 return planlist;
		 }
}
