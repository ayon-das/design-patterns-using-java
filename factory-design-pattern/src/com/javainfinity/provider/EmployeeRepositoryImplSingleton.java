package com.javainfinity.provider;

import java.util.HashMap;
import java.util.Map;

import com.javainfinity.annotations.Singleton;

@Singleton(getter = "getInstance")
public class EmployeeRepositoryImplSingleton implements EmployeeRepository {
	private Map<Integer, String> entries = new HashMap<>();

	private static EmployeeRepositoryImplSingleton INSTANCE;

	private EmployeeRepositoryImplSingleton() {}

	/*Not considered as multithreading environment*/
	public static EmployeeRepositoryImplSingleton getInstance() {
		if (INSTANCE == null)
			INSTANCE = new EmployeeRepositoryImplSingleton();
		return INSTANCE;
	}

	@Override
	public void addEmployee(int id, String name) {
		entries.put(id, name);
	}

	@Override
	public String findEmployee(int id) {
		return entries.get(id);
	}
}
