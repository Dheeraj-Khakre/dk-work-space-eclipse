package com.dk.springboot.helper;

public class ResponseStructure<T> {
	
private	int statuseCode;
	private T data;
	private String message;
	public int getStatuseCode() {
		return statuseCode;
	}
	public void setStatuseCode(int statuseCode) {
		this.statuseCode = statuseCode;
	}
	public T getData() {
		return data;	
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
