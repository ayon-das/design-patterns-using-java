package com.javainfinity.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.javainfinity.factory.IObjectFactory;
import com.javainfinity.factory.ObjectFactory;
import com.javainfinity.provider.EmployeeRepository;

public class Client {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, 
	IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, 
	SecurityException, FileNotFoundException, IOException {
		
		IObjectFactory factory = new ObjectFactory("config.properties");
		
		/*Check config.properties file. Change to emp-repo instead of emp-repo-singleton when using prototype instance*/
		EmployeeRepository empRepo = (EmployeeRepository) factory.get("emp-repo-singleton");
		empRepo.addEmployee(1, "John");
		empRepo.addEmployee(2, "Kevin");
		
		/*Testing singleton - Change the below line to empRepo.findEmployee(2) when using prototype instance*/
		EmployeeRepository empRepoResponse = (EmployeeRepository) factory.get("emp-repo-singleton");
		String empName = empRepoResponse.findEmployee(2);
		
		System.out.println("Employee found : "+empName);
	}
}
