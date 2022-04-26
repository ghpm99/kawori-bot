package com.kawori.app.achievements.command;


import com.kawori.command.Command;
import com.kawori.command.CommandHandler;
import com.kawori.security.Permissions;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class CmdAchievements.
 */
public class Achievements extends Command{

	public Achievements() {
		CommandHandler.commands.put("achievements", this);
	}

	/**
	 * Action.
	 *
	 * @param args the args
	 * @param event the event
	 */
	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event.getAuthor().getName());
	}

	/**
	 * Executed.
	 *
	 * @param success the success
	 * @param event the event
	 */
	@Override
	public void executed(boolean success, MessageReceivedEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * Help.
	 *
	 * @return the string
	 */
	@Override
	public String help() {
		// TODO Auto-generated method stub
		return "msg_achievements_help";
	}

	/**
	 * Help short.
	 *
	 * @return the string
	 */
	@Override
	public String helpShort() {
		// TODO Auto-generated method stub
		return "msg_achievements_helpshort";
	}

	/**
	 * Gets the permissions.
	 *
	 * @return the permissions
	 */
	@Override
	public Permissions getPermissions() {
		// TODO Auto-generated method stub
		return Permissions.CMD_UTIL;
	}

}
