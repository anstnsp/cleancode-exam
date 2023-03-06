package com.phangil.houseutils.controller;

import javax.validation.constraints.NotBlank;

import com.phangil.houseutils.constants.Enum;
import com.phangil.houseutils.constants.Role;

public class JoinRequest {
	@NotBlank
	private String name;
	@Enum(enumClass = Role.class, ignoreCase = true)
	private String role;

	public void setRole(String role) {
		this.role = role;
	}
}
