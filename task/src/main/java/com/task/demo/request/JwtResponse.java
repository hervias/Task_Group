package com.task.demo.request;

import java.io.Serializable;
public class JwtResponse implements Serializable {
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	public String getToken() {
		System.out.println("************ "+this.jwttoken);
		return this.jwttoken;
	}
}







