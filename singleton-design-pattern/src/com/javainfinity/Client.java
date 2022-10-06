package com.javainfinity;

public class Client {
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println("Are both instances same ? "+(instance1 == instance2));
	}
}
