package dao;

import java.util.ArrayList;

import data.Read;
import data.Write;
import vo.User;

public class UserDao {
	ArrayList<User> userlist=new ArrayList<User>();
	Read read=new Read();
	Write write=new Write();
	
	public String[][] listToSet(){
		String userset[][]=null;
		if(userlist==null||userlist.size()==0){
			return userset;
		}
		userset= new String[userlist.size()][3];
		for(int i=0;i<userlist.size();i++){
			userset[i][0]=userlist.get(i).getName();
			userset[i][1]=userlist.get(i).getPassword();
			userset[i][2]=userlist.get(i).getOccupation();
			
		}
		return userset;
		
	}
	public void setToList(String [][] userset){
		userlist=new  ArrayList<User>();
		if(userset.length>0){
		for(int i=0;i<userset.length;i++){
		  User user=new User();
		  user.setName(userset[i][0]);
		  user.setPassword(userset[i][1]);
		  user.setOccupation(userset[i][2]);
		  userlist.add(user);
		}
	   }
	}
	
	   public void read(){
		   String[][] set= read.readData("data/user.txt");
		   this.setToList(set);
	   }
	   public void write(){
		   String [][]set=this.listToSet();
		   write.writeData("data/user.txt", set);
	   }
       
	   public void add(User user){
		   this.read();
		   User find=this.find(user.getName());
		   if(find==null){
		   userlist.add(user);
		  
		   }
		  
		   this.write();
	   }
	   public void delete(String  name){
		   this.read();
		   for(int i=0;i<userlist.size();i++){
			   User compare=userlist.get(i);
			   if(compare.getName().equals(name)){
				   userlist.remove(i);
			   }
		   }
		   this.write();
	   }
	   public User find(String name){
		   this.read();
		   User result=new User();
		   for(int i=0;i<userlist.size();i++){
			   User compare=userlist.get(i);
			   if(compare.getName().equals(name)){
				   result=compare;
				   return result;
			   }
		   }
		   return result;
	   }
	   
	  public boolean check(User user){
		  boolean flag=false;
		  this.read();
		  for(int i=0;i<userlist.size();i++){
			  User compare=userlist.get(i);
			  if(compare.getName().equals(user.getName())){
				  if(compare.getPassword().equals(user.getPassword())){
					  if(compare.getOccupation().equals(user.getOccupation())){
						  flag=true;
					  }
				  }
			  }
		  }
		  return flag;
	  }
	   
	 public static void main(String [] args){
		 UserDao dao=new UserDao();
		 User user=new User();
		 user.setName("lili");
		 user.setPassword("lili"); 
		 user.setOccupation("系统管理员");
		 dao.add(user);
		 }
	   
}
