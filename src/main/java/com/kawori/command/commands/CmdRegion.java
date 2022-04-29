package com.kawori.command.commands;


import com.kawori.command.Command;
import com.kawori.command.CommandHandler;
import com.kawori.message.MessageController;
import com.kawori.security.Permissions;
import com.kawori.service.LanguageService;

import org.springframework.stereotype.Controller;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;


@Controller
public class CmdRegion extends Command {

	public CmdRegion() {
		CommandHandler.commands.put("region", this);
	}

	private MessageController messageController;
	private LanguageService languageService;

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		if (args.length == 0) {
			notLanguageSet(event);
		} else {
			languageSet(event, args[0]);
		}

	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {

	}

	@Override
	public String help() {
		return "msg_region_help";
	}

	@Override
	public String helpShort() {
		return "msg_region_helpshort";
	}

	@Override
	public Permissions getPermissions() {
		return Permissions.CMD_UTIL;
	}

	private void notLanguageSet(MessageReceivedEvent event) {
		messageController.sendMessage(event.getGuild(), event.getChannel(), event.getAuthor(), "msg_region_fail");
	}

	private void languageSet(MessageReceivedEvent event, String region) {
		languageService.setRegion(event.getAuthor(), region);
		messageController.sendMessage(event.getGuild(), event.getChannel(), event.getAuthor(), "msg_region_sucess");
	}

}
