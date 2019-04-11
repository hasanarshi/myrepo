package org.hasan.controllers;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice // this class will be acting like exception handler class
public class GlobalExceptionHandler 
{
	@ExceptionHandler(value=NoHandlerFoundException.class)
	@ResponseBody // return string as a response
	// this method will respond to NoHandlerFoundException exception
	public String showDefaultErrorHandlerMessage()
	{
		return "<i style='color: red;'>Unkown url"
			+ "<a href='./'>click here for further actions</a></i>";
	}

	@ExceptionHandler(value={SQLException.class})
	@ResponseBody // return string as a response
	// this method will respond to SQLException, which may arise from
	// any controller
	public String showErrorMessage(Exception e)
	{
		return "<h3>"+e.getMessage()+"</h3>"
				+ "<a href=./>click here to goto home page</a>";
	}	
}