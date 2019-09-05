package com.ops.app.ws.exception;

//import com.ops.app.ws.ui.model.response.ErrorMessages;

public class UserServiceException extends RuntimeException {

	private static final long serialVersionUID = 4161127328529592332L;
	
	public UserServiceException(String message)
	{
		super(message);
	}

	

}
