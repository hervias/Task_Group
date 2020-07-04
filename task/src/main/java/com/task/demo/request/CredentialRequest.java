package com.task.demo.request;

public class CredentialRequest {

	private Integer key;
	private String shared_secret;
	
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public String getShared_secret() {
		return shared_secret;
	}
	public void setShared_secret(String shared_secret) {
		this.shared_secret = shared_secret;
	}
	
}
