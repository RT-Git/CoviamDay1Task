package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

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
	 FileWriter f1;
	 //JsonWriter writer;
	JsonFileHandler()
	{try {
		 f1=new FileWriter("/Users/coviam/eclipse-workspace/EmployeeManagement/src/model/employee1.json",true);
		 f1.write("[]");
		 f1.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		   try {
		    	FileInputStream geek = new FileInputStream("/Users/coviam/eclipse-workspace/EmployeeManagement/src/model/employee.json");
		//     	FileOutputStream geek1= new FileOutputStream("/Users/coviam/eclipse-workspace/EmployeeManagement/src/model/employee.json");
		//		    	writer= new JsonWriter(new OutputStreamWriter(geek1));
		         reader = new JsonReader(new InputStreamReader(geek));
		        Gson gson = new GsonBuilder()
		 			   .setDateFormat("MM/dd/yy").create();
//writer.beginArray();
		        // Read file in stream mode
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
			 f1=new FileWriter("/Users/coviam/eclipse-workspace/EmployeeManagement/src/model/employee1.json",true);

			JsonObject j1=new JsonObject();
			j1.addProperty("firstName",data.getFirstName());
			j1.addProperty("lastName", data.getLastName());
			//j1.addProperty("dateOfBirth", data.getDateOfBirth().toString());
			//j1.addProperty("experience", data.getExperience());
			System.out.println(j1.toString());
			RandomAccessFile file=new RandomAccessFile("/Users/coviam/eclipse-workspace/EmployeeManagement/src/model/employee1.json", "rw");
			long l=file.length();
			file.setLength(l-1);
			file.close();
			f1.write("\b");
			f1.write(j1.toString()+",]");
			f1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			    
	}

}
