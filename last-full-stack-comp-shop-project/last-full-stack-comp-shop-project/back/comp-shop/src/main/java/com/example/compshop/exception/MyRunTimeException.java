package com.example.compshop.exception;

import org.springframework.validation.BindingResult;

public class MyRunTimeException extends RuntimeException{
	 
	private static final long serialVersionUID =1L;
	private BindingResult result;
	
	public BindingResult getResult() {
		return result;
	}

	public void setResult(BindingResult result) {
		this.result = result;
	}

	public MyRunTimeException(BindingResult result) {
		super();
		this.result = result;
	}

	
}
