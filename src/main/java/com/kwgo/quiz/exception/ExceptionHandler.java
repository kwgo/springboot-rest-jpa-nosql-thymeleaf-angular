package com.kwgo.quiz.exception;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.kwgo.quiz.logger.Log;

/**
 * 
 * This is exception handler for application level
 * <p>
 * The quiz demo implemented NoHandlerFoundException and ExceptionHandler
 * <p>
 * Add exception example: ExceptionHandler(value = NullPointerException.class)
 * 
 */
@ControllerAdvice
public class ExceptionHandler {
	private static final Logger log = Log.getLogger();

	/**
	 * Handle page not found (404) exception
	 * 
	 * @param request HTTP request
	 * @param e       Exception
	 * @return String Error page
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(value = NoHandlerFoundException.class)
	public String noHandlerFoundException(HttpServletRequest request, Exception e) {
		ExceptionInfo exceptionInfo = new ExceptionInfo();
		exceptionInfo.setTimestamp(new Timestamp(System.currentTimeMillis()));
		exceptionInfo.setError("Page Not Found");
		exceptionInfo.setMessage("Page not found, please check the URL");
		exceptionInfo.setStatus("404");
		exceptionInfo.setException(e);
		exceptionInfo.setPath(request.getRequestURL().toString());
		request.setAttribute("exceptionInfo", exceptionInfo);
		return "error";
	}

	/**
	 * Handle all of exception
	 * 
	 * @param request HTTP request
	 * @param e       Exception
	 * @return String Error page
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public String exceptionHandler(HttpServletRequest request, Exception e) {
		log.error("Quiz global exception handler message begin ---", e);
		log.error("Quiz global exception handler message end ---");

		ExceptionInfo exceptionInfo = new ExceptionInfo();
		exceptionInfo.setTimestamp(new Timestamp(System.currentTimeMillis()));
		exceptionInfo.setError("Server Error");
		exceptionInfo.setMessage(e.getLocalizedMessage());
		exceptionInfo.setStatus("500");
		exceptionInfo.setException(e);
		exceptionInfo.setPath(request.getRequestURL().toString());
		request.setAttribute("exceptionInfo", exceptionInfo);
		return "error";
	}
}