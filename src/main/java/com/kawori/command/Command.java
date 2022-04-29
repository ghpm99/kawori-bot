package com.kawori.command;

import com.kawori.security.Permissions;
import com.kawori.security.SecurityCommand;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract class Command {

	private SecurityCommand securityCommand = new SecurityCommand();

	protected boolean called(String[] args, MessageReceivedEvent event) {
		return securityCommand.authenticateCommand(event, getPermissions());
	}

	public abstract void action(String[] args, MessageReceivedEvent event);

	public abstract void executed(boolean success, MessageReceivedEvent event);

	public abstract String help();

	public abstract String helpShort();

	public abstract Permissions getPermissions();

}
