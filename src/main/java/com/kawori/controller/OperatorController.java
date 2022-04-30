package com.kawori.controller;

import com.kawori.model.UserDiscord;

import org.springframework.stereotype.Controller;

import net.dv8tion.jda.api.entities.User;

@Controller
public class OperatorController {

	public UserDiscord updateOperator(User user) {
		return new UserDiscord();
	}

	private UserDiscord findOperator(String id) {

		return new UserDiscord();
	}

	public void onUserUpdateName(String id, String newName) {

	}

	public void onUserUpdateDiscriminator(String id, String discriminator) {

	}
}
