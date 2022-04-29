package com.kawori.service;

import com.kawori.controller.ExperienceController;
import com.kawori.model.Guilda;
import com.kawori.model.Operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

	@Autowired
	private StatusService statusService;
	@Autowired
	private GuildaService guildaService;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private ExperienceController expController;

	public void privateMessageEvent(String idUser) {
	}

	public void guildMessageEvent(String idUser, String idGuild) {
		expController.messageEvent(idUser, idGuild);
	}

	public void guildReactionEvent(String idUser, String idGuild) {

	}

	public void cmdReceivedEvent(String idUser, String idGuild) {
		statusService.increaseCmdReceived();
		increaseCmdCountGuild(idGuild);
		increaseCmdCountUser(idUser);
	}

	private void increaseCmdCountGuild(String idGuild) {
		Guilda guilda = guildaService.findById(idGuild);
		guildaService.save(guilda);
	}

	private void increaseCmdCountUser(String idUser) {
		Operator user = operatorService.findById(idUser);
		operatorService.save(user);
	}
}
