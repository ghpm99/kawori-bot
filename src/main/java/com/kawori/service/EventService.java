package com.kawori.service;

import com.kawori.controller.ExperienceController;
import com.kawori.model.GuildDiscord;
import com.kawori.model.UserDiscord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

	@Autowired
	private StatusService statusService;
	@Autowired
	private GuildService guildaService;
	@Autowired
	private UserService operatorService;
	@Autowired
	private ExperienceController expController;

	public void privateMessageEvent(String idUser) {
	}

	public void guildMessageEvent(String idUser, String idGuild) {
		expController.messageEvent(idUser, idGuild);
	}

	public void guildReactionEvent(String idUser, String idGuild) {

	}

	public void cmdReceivedEvent(long idUser, Long idGuild) {
		statusService.increaseCmdReceived();
		increaseCmdCountGuild(idGuild);
		increaseCmdCountUser(idUser);
	}

	private void increaseCmdCountGuild(Long idGuild) {
		GuildDiscord guilda = guildaService.findById(idGuild);
		guildaService.save(guilda);
	}

	private void increaseCmdCountUser(long idUser) {
		UserDiscord user = operatorService.findByIdDiscord(idUser);
		operatorService.save(user);
	}
}
