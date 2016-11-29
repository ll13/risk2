package data;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Read{
	private String getFile(String fileName) {  
		   
	    StringBuilder result = new StringBuilder("");  
	   
	    
	    ClassLoader classLoader = getClass().getClassLoader();  
	    File file = new File(classLoader.getResource(fileName).getFile());  
	    System.out.println(classLoader.getResource(fileName).getFile());
	    try  {  
	    	Scanner scanner = new Scanner(file);
	        while (scanner.hasNextLine()) {  
	            String line = scanner.nextLine();  
	            result.append(line).append("\n");  
	        }  
	   
	        scanner.close();  
	   
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	   
	    return result.toString();  
	   
	  }  
	   
	   public String[][] split(String string){
		   String []content=string.split("\n");
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
		  String string= this.getFile(path);
		 result= this.split(string);
		   return result;
	   }
	 
	}

