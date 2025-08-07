package com.kwgo.quiz.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;

/**
 * 
 * Class to store the exception details
 *
 */
public class ExceptionInfo {

	private Timestamp timestamp;

	private String path;

	private String error;

	private String status;

	private String message;

	private Exception exception;

	private String trace;

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public String getTrace() {
		if (exception != null) {
			StringWriter errors = new StringWriter();
			exception.printStackTrace(new PrintWriter(errors));
			return errors.toString();
		}
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}
}
