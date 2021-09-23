package com.dbs.web.response;

public class ResponsePage {

	private int status;
	private String message;
	private Object object;
	
	public ResponsePage() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponsePage(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public ResponsePage(int status, String message, Object object) {
		super();
		this.status = status;
		this.message = message;
		this.object=object;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "ResponsePage [status=" + status + ", message=" + message + ", object=" + object + "]";
	}
	
}
