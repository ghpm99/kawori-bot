package com.kawori.controller;

import com.kawori.model.Operator;

import org.springframework.stereotype.Controller;

import net.dv8tion.jda.api.entities.User;

@Controller
public class OperatorController {

	public Operator updateOperator(User user) {
		return new Operator();
	}

	private Operator findOperator(String id) {

		return new Operator();
	}

	public void onUserUpdateName(String id, String newName) {

	}

	public void onUserUpdateDiscriminator(String id, String discriminator) {

	}
}
