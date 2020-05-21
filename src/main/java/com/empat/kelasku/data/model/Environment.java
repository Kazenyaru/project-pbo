package com.empat.kelasku.data.model;

public enum Environment {
	PROD("http://jastis.herokuapp.com/api/v1/"),
	DEV("http://localhost:3001/api/v1/");

	private String url;

	Environment(String envUrl) {
		this.url = envUrl;
	}

	public String getUrl() {
		return url;
	}
}
