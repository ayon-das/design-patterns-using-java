package com.javainfinity.provider;

public interface EmployeeRepository {
	public void addEmployee(int id, String name);
	public String findEmployee(int id);
}
