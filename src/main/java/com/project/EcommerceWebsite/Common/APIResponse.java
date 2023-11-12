package com.project.EcommerceWebsite.Common;

import org.springframework.http.HttpStatus;

public class APIResponse {
	
	private HttpStatus status;
	private Object data;
	private Object error;
	
	public APIResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	
	
	

}
