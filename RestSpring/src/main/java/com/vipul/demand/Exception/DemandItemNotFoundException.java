package com.vipul.demand.Exception;

public class DemandItemNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Demand Item does not exist.";
	}
}
