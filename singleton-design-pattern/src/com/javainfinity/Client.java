package com.javainfinity;

public class Client {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		instance1.data=instance1.data+30;
		Singleton instance2 = Singleton.getInstance();
		instance2.data=instance1.data+50;
		System.out.println("Are both instances same ? "+(instance1 == instance2));
		System.out.println("Instance data is 100 ? "+instance1.data);
	}
}
