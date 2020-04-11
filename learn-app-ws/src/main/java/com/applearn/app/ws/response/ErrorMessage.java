package com.applearn.app.ws.response;

import java.util.Date;

public class ErrorMessage {
	private Date timeStamp;
	private String message;

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public ErrorMessage(Date timeStamp, String message) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
	}

	

	public void setMessage(String message) {
		this.message = message;
	}
}
