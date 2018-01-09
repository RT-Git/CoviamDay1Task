package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class temp {
	
	public static void readStream() {
	    try {
	    	FileInputStream geek = new FileInputStream("/Users/coviam/eclipse-workspace/EmployeeManagement/src/model/employee.json");
	    	 
	        JsonReader reader = new JsonReader(new InputStreamReader(geek));
	        Gson gson = new GsonBuilder()
	 			   .setDateFormat("MM/dd/yy").create();

	        // Read file in stream mode
	        reader.beginArray();
	        while (reader.hasNext()) {
	            // Read data into object model
	            Employee person = gson.fromJson(reader, Employee.class);
	            System.out.println(person.firstName);
	       break;
	        }
	        reader.close();
	    } catch (UnsupportedEncodingException ex) {
	       
	    } catch (IOException ex) {
	       
	    }
	}
public static void main(String[] args) {
JsonFileHandler j=new JsonFileHandler();
for(int i=0;i<10;i++)
{
j.read();	
}
Employee e=new Employee();
e.setFirstName("viral");
e.setLastName("shah");
j.write(e);
}
}
