package com.project.EcommerceWebsite.Common;

public class Error {
	
	private String message;
	private String target;
	public Error() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Error(String message, String target) {
		super();
		this.message = message;
		this.target = target;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	

}
