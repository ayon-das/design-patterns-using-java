package com.javainfinity;

public class URLClient {
	public static void main(String[] args) {
		URIBuilder.Builder urlBuilder = new URIBuilder.Builder();
		URIBuilder url = urlBuilder.setProtocol("https")
		   .setHostname("javainfinity.com")
		   .setPath("springboot")
		   .setPathParameter("1")
		   .setPathParameter("30")
		   .setQueryParameter("topic=autoconfiguration")
		   .setQueryParameter("subtopic=parentjar")
		   .build();
		
		System.out.println(url);
	}
}
