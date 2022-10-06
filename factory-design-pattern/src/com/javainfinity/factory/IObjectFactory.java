package com.javainfinity.factory;

import java.lang.reflect.InvocationTargetException;

public interface IObjectFactory {
	public Object get(String key) throws ClassNotFoundException, 
				InstantiationException, IllegalAccessException, IllegalArgumentException, 
				InvocationTargetException, NoSuchMethodException, SecurityException;
}
