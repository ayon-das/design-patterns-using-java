package com.javainfinity.provider;

import java.util.HashMap;
import java.util.Map;

public class EmployeeRepositoryImpl implements EmployeeRepository{
	private Map<Integer,String> entries = new HashMap<>();
	
	@Override
	public void addEmployee(int id, String name) {
		entries.put(id, name);
	}
	
	@Override
	public String findEmployee(int id) {
		return entries.get(id);
	}
}
