package com.javainfinity.factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.javainfinity.annotations.Singleton;

public class RepositoryFactory implements IRepositoryFactory{
	Properties prop;
	public RepositoryFactory(String source) throws FileNotFoundException, IOException {
		prop = new Properties();
		prop.load(new FileReader(source));
	}

	/*Considered only for prototype classes. For singleton classes we can put a check here*/
	public Object get(String key) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String clazName = (String) prop.get(key);
		Class<?> claz = Class.forName(clazName);
		
		/*For singleton classes*/
		Singleton singleton = claz.getAnnotation(Singleton.class);
		if(singleton != null) {
			String getter = singleton.getter();
			return claz.getMethod(getter).invoke(claz);
		}
		
		return claz.getConstructor().newInstance();
	}
}
