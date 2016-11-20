package data;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;



public class Write {
 
private void write(String file_path,String []content){
	  try{
		  FileOutputStream fos=new FileOutputStream(file_path);
	        OutputStreamWriter osw=new OutputStreamWriter(fos, "UTF-8");
	        BufferedWriter  bw=new BufferedWriter(osw);
		  if(content.length>0){
			  for(int i=0;i<content.length;i++){
				  
				  bw.write(content[i]+"\t\n");
				  
			  }
		  }
		  bw.close();
		  osw.close(); 
		  fos.close();
		 
	  }catch(IOException ioe){
		  System.out.println(ioe);
	  }
	  
  }

  private String[] merge(String [][] data){	  
	  String[]result=new String [data.length];
	  if(data.length>0){
		  for(int i=0;i<data.length;i++){
			  String line="";
			  for(int j=0;j<data[i].length;j++){
				  line=line+data[i][j];
				  line=line+";";
			  }
			  result[i]=line;
		  }
	  }
	  return result;
  }
  public void writeData(String path,String[][] set){
	  write(path,merge(set));
	
  }
 
}