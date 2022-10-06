package com.javainfinity.factory;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IObjectFactory {
	public Object get(String type, String prop) throws FileNotFoundException, IOException;
}
