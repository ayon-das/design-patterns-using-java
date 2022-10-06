package com.javainfinity.factory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ObjectFactory implements IObjectFactory {
	public Object get(String type, String prop) throws FileNotFoundException, IOException {
		type = type.toLowerCase();
		switch (type) {
		case "repository": {
			return new RepositoryFactory(prop);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + type);
		}
	}
}
