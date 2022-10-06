package com.javainfinity.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.javainfinity.factory.IObjectFactory;
import com.javainfinity.factory.IRepositoryFactory;
import com.javainfinity.factory.ObjectFactory;
import com.javainfinity.provider.EmployeeRepository;

public class Client {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, 
	IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, 
	SecurityException, FileNotFoundException, IOException {
		
		IObjectFactory factory = new ObjectFactory();
		IRepositoryFactory repoFactory = (IRepositoryFactory) factory.get("repository", "config.properties");
		
		EmployeeRepository empRepo = (EmployeeRepository) repoFactory.get("emp-repo");
		empRepo.addEmployee(1, "John");
		empRepo.addEmployee(2, "Kevin");
		
		String empName = empRepo.findEmployee(2);
		
		System.out.println("Employee found : "+empName);
	}
}
