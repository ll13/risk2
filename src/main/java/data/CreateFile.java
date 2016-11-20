package data;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	String file_path,file_name;
public void makeDir(String path,String name){
	File dir=new File(path+name);
	dir.mkdir();
}
public void makeTxt(String path,String name) {
	File f=new File(path+name+".txt");
	try{
	f.createNewFile();
	}catch(IOException ioe){
		System.out.println("cannot create file"+ioe);
	}
	
}
public void deleteFlie(String path,String name){
	File f=new File(path+name+".txt");
	f.delete();
}

public void init(){
	this.makeDir("", "data");
	this.makeTxt("data"+File.separator, "user");
	this.makeTxt("data"+File.separator, "riskType");
	this.makeTxt("data"+File.separator, "riskItem");
	
}
public static void main(String [] args){
	CreateFile c=new CreateFile();
	c.init();
}	

}


