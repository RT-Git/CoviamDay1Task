package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class JsonFileHandler implements MyFileHandler{
	 JsonReader reader ;
	 FileWriter fileWriter;
	 String path;
	JsonFileHandler()
	{
		path="/Users/coviam/eclipse-workspace/EmployeeManagement/src/model/employee.json";
		
	
		   try {
		    	FileInputStream geek = new FileInputStream(path);
		         reader = new JsonReader(new InputStreamReader(geek));
		        Gson gson = new GsonBuilder()
		 			   .setDateFormat("MM/dd/yy").create();
		        reader.beginArray();
		      
		   } catch (UnsupportedEncodingException ex) {
		       
		    } catch (IOException ex) {
		       
		    }

	}
	@Override
	public Employee read() {
		// TODO Auto-generated method stub
		Gson gson = new GsonBuilder()
	 			   .setDateFormat("MM/dd/yy").create();

		  try {
			while (reader.hasNext()) {
			        // Read data into object model
			        Employee employee = gson.fromJson(reader, Employee.class);
			        return employee;
			   
			    }
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
	   
		return null;
	}

	@Override
	public void write(Employee data) {
		// TODO Auto-generated method stub
		try {
			fileWriter=new FileWriter(path,true);

			JsonObject jsonObj=new JsonObject();
			jsonObj.addProperty("firstName",data.getFirstName());
			jsonObj.addProperty("lastName", data.getLastName());
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
             String strDate = dateFormat.format(data.getDateOfBirth());
			jsonObj.addProperty("dateOfBirth", strDate);
			jsonObj.addProperty("experience", ((int)(data.getExperience())));
			RandomAccessFile file=new RandomAccessFile(path, "rw");
			long l=file.length();
			file.setLength(l-1);
			file.close();
			fileWriter.write(","+jsonObj.toString()+"]");
			fileWriter.close();
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			    
	}

}