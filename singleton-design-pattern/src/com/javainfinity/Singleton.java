package com.javainfinity;

public class Singleton {
	/*Eager initialization*/
	/*private static volatile Singleton INSTANCE = new Singleton();*/
	
	private static volatile Singleton INSTANCE;
	int data=20;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		/*A thread checking if the instance is null - then enter*/
		if(INSTANCE == null) {
			/*Thread waiting for other thread to release the lock if acquired*/
			synchronized (Singleton.class) {
				/*If other thread acquired the lock, then check if the object is initialized or still null
				 * If null then current thread initialize the object*/
				if(INSTANCE == null) {
					INSTANCE = new Singleton(); /*Lazy initialization*/
				}
			}
		}
		return INSTANCE;
	}
}