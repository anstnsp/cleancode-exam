package com.phangil.houseutils.controller;

import com.phangil.houseutils.constants.AccountSessionExpSec;
import com.phangil.houseutils.constants.EnumValid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Goods {

	@EnumValid(message = "gogogogogogo")
	private AccountSessionExpSec accountSessionExpSec;
}
