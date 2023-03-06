package com.phangil.houseutils.constants;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public enum AccountSessionExpSec {
	TEN_MINITES("600"),
	THIRTY_MINITES("1800"),
	ONE_HOURS("3600"),
	THREE_HOURS("10800");

	private final String sessionExpSec;

	@JsonValue
	public String getSessionExpSec() {
		return sessionExpSec;
	}

	@JsonCreator()
	public static AccountSessionExpSec from(String value) {
		System.out.println("여기는 enum의 from: " + value);
		return Arrays.stream(values())
			.filter(e -> e.getSessionExpSec().equals(value))
			.findFirst()
			.orElse(null);
		// .orElseThrow(() -> new IamApiException(IamApiErrorCode.BAD_REQUEST, "iam.user.invalidRoleType"));
		// .orElseThrow(() -> new IamApiException(IamApiErrorCode.INVALID_INPUT_FORMAT, "iam.role.invalidName"));
	}
}
