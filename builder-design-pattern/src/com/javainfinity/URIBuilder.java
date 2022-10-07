package com.javainfinity;

import java.util.ArrayList;
import java.util.List;

public class URIBuilder {
	private String protocol;
	private String hostname;
	private String port;
	private String path;
	private List<String> pathParameter;
	private List<String> queryParameter;
	
	public URIBuilder(Builder builder) {
		this.protocol = builder.protocol;
		this.hostname = builder.hostname;
		this.port = builder.port;
		this.path = builder.path;
		this.pathParameter = builder.pathParameter;
		this.queryParameter = builder.queryParameter;
	}

	public static class Builder{
		private String protocol;
		private String hostname;
		private String port;
		private String path;
		private List<String> pathParameter = new ArrayList<>();
		private List<String> queryParameter= new ArrayList<>();
		
		public URIBuilder build() {
			return new URIBuilder(this);
		}

		public Builder setProtocol(String protocol) {
			this.protocol = protocol;
			return this;
		}

		public Builder setHostname(String hostname) {
			this.hostname = hostname;
			return this;
		}

		public Builder setPort(String port) {
			this.port = port;
			return this;
		}

		public Builder setPath(String path) {
			this.path = path;
			return this;
		}

		public Builder setPathParameter(String pathParameter) {
			this.pathParameter.add(pathParameter);
			return this;
		}

		public Builder setQueryParameter(String queryParameter) {
			this.queryParameter.add(queryParameter);
			return this;
		}
	}

	@Override
	public String toString() {
		StringBuilder url = new StringBuilder(protocol+"://"+hostname);
		if(port!=null)
			url.append(":"+port);
		url.append("/"+path);
		if(pathParameter.size() > 0) {
			for(String pathParam: pathParameter) {
				url.append("/"+pathParam);
			}
		}
		if(queryParameter.size() > 0) {
			url.append("/?"+queryParameter.get(0));
			queryParameter.remove(0);
			for(String queryParam: queryParameter) {
				url.append("&&"+queryParam);
			}
		}
		return url.toString();
	}
}
