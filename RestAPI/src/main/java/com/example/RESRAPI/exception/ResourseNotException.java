package com.example.RESRAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ResourseName;
	private String feeldName;
	private Object FeeldValue;
	
	
	public ResourseNotException(String resourseName, String feeldName, Object feeldValue) {
		super(String.format("%s not found with %s :' %s'", resourseName,feeldName,feeldValue));
		this.ResourseName = resourseName;
		this.feeldName = feeldName;
		this.FeeldValue = feeldValue;
	}


	/**
	 * @return the resourseName
	 */
	public String getResourseName() {
		return ResourseName;
	}




	/**
	 * @return the feeldName
	 */
	public String getFeeldName() {
		return feeldName;
	}




	/**
	 * @return the feeldValue
	 */
	public Object getFeeldValue() {
		return FeeldValue;
	}




	
}
