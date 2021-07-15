package com.inatel.hermes.bean;

public class AuthenticationBean {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AuthenticationBean(String message) {
		this.message = message;
	}

	public AuthenticationBean() {
	}

}