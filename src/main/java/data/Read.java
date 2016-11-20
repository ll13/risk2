package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Read{
	   
	   public String[] read(String path){
		   ArrayList <String> content=new ArrayList<String>();
		   String []result;
		   try{
			   File f=new File(path);
			   FileInputStream fos=new FileInputStream(f);
		        InputStreamReader osw=new InputStreamReader(fos, "UTF-8");
		        BufferedReader  bw=new BufferedReader(osw);
			   String line=null;
			   while((line=bw.readLine())!=null){
				   line=line.split("\t")[0];
				   content.add(line);
			   }
			   
			   bw.close();
			   osw.close(); 
			   fos.close();
		   }catch(IOException ioe){
			   ioe.printStackTrace();
		   }
		   result=null;
		   if(!content.isEmpty()){
			   result=new String[content.size()];
			   for(int i=0;i<content.size();i++)
				   result[i]=content.get(i);
		   }
		   return result;
		   
	   }
	   
	   public String[][] split(String []content){
		   String [][] result=null;
		   if(content.length>0){
			   result=new String[content.length][];
		   for(int i=0;i<content.length;i++){
			   result[i]=content[i].split(";");
		   }}
		   return result;
	   }
	   public String[][] readData(String path){
		   String[][]result=null;
		   result=split(read(path));	   
		   return result;
	   }
	 
	}

