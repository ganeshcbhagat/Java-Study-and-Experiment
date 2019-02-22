package com.atmosphere.gotcha.spring.exception;

import java.util.Arrays;
import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private Integer status;
	private String error;
	private String path;
	private StackTraceElement stackTraceElement[];

	public ErrorDetails() {
		super();
	}
	
	public ErrorDetails(Date timestamp, Integer status, String error, String path, StackTraceElement stackTraceElement[]) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.path = path;
		this.stackTraceElement = stackTraceElement;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public StackTraceElement[] getStackTraceElement() {
		return stackTraceElement;
	}

	public void setStackTraceElement(StackTraceElement[] stackTraceElement) {
		this.stackTraceElement = stackTraceElement;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorDetails [timestamp=");
		builder.append(timestamp);
		builder.append(", status=");
		builder.append(status);
		builder.append(", error=");
		builder.append(error);
		builder.append(", path=");
		builder.append(path);
		builder.append(", stackTraceElement=");
		builder.append(Arrays.deepToString(stackTraceElement));
		builder.append("]");
		return builder.toString();
	}
	
}
