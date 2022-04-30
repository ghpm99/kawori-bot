package com.kawori.apps.achievements.command;

import com.kawori.command.Command;
import com.kawori.command.CommandHandler;
import com.kawori.security.Permissions;

import org.springframework.stereotype.Controller;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@Controller
public class Achievements extends Command {

	public Achievements() {
		CommandHandler.commands.put("achievements", this);
	}

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		System.out.println(event.getAuthor().getName());
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {

	}

	@Override
	public String help() {
		return "msg_achievements_help";
	}

	@Override
	public String helpShort() {
		return "msg_achievements_helpshort";
	}

	@Override
	public Permissions getPermissions() {
		return Permissions.CMD_UTIL;
	}

}
