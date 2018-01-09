package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class temp {
public static void main(String[] args) {
	Gson gson = new GsonBuilder()
			   .setDateFormat("MM/dd/yy").create();
	JsonReader reader;
	try {
		reader = new JsonReader(new FileReader("/Users/coviam/eclipse-workspace/EmployeeManagement/src/model/employee.json"));
		Type myDataType = new TypeToken<Collection<Employee>>(){}.getType();
		
		Employee data= ((ArrayList<Employee>)gson.fromJson(reader, myDataType)).get(0);
		

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
