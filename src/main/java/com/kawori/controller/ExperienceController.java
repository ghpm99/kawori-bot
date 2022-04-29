package com.kawori.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ExperienceController {

	public void messageEvent(String idUser, String idGuild) {
		increaseExpGuild(idGuild);
		increaseExpUser(idUser);
	}

	private void increaseExpGuild(String idGuild) {

	}

	private void increaseExpUser(String idUser) {

	}
}
