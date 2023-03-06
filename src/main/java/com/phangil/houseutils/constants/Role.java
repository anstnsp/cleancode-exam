package com.phangil.houseutils.constants;

public enum Role {
	GUEST("GUEST"),
	USER("USER"),
	ADMIN("ADMIN");

	String value;
	Role(String value) { this.value = value; }
	public String value() { return value; }
}
