package com.vipul.demand.Exception;

public class DemandNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Demand does not exist.";
	}
}