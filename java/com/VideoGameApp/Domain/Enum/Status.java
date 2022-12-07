package com.VideoGameApp.Domain.Enum;

public enum Status {// future update to work on
	ACTIVE("A"),
	INACTIVE("I"),
	OFFLINE("O");
	
	String value;
	
	Status (String value) {
		
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}