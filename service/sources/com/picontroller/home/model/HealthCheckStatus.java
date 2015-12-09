package com.picontroller.home.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Health check status representation.
 * @author dcharles
 *
 */
public class HealthCheckStatus implements Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = -1834332818091710620L;
	
	/**
	 * Status enum
	 * @author dcharles
	 *
	 */
	enum Status {
		OK ("OK"),
		KO ("KO");
		
		private final String stringValue;
		Status(String value){
			this.stringValue=value;
		}
		
		public String getStringValue(){
			return stringValue;
		}
	}
	
	/**Date of the request.*/
	private Date requestDate;
	/** Actual status*/
	private Status status;
	
	/**
	 * Constructor;
	 */
	public HealthCheckStatus() {
		requestDate = new Date();
		status = Status.OK;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}
