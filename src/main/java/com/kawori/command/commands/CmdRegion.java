package com.kawori.command.commands;


import com.kawori.command.Command;
import com.kawori.command.CommandHandler;
import com.kawori.message.MessageController;
import com.kawori.security.Permissions;
import com.kawori.service.LanguageService;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class CmdRegion.
 */

public class CmdRegion extends Command {

	public CmdRegion() {
		CommandHandler.commands.put("region", this);
	}

	/** The message controller. */

	private MessageController messageController;

	/** The language service. */

	private LanguageService languageService;

	/**
	 * Action.
	 *
	 * @param args the args
	 * @param event the event
	 */
	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		if (args.length == 0) {
			notLanguageSet(event);
		} else {
			languageSet(event, args[0]);
		}

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
		return "msg_region_help";
	}

	/**
	 * Help short.
	 *
	 * @return the string
	 */
	@Override
	public String helpShort() {
		// TODO Auto-generated method stub
		return "msg_region_helpshort";
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

	/**
	 * Not language set.
	 *
	 * @param event the event
	 */
	private void notLanguageSet(MessageReceivedEvent event) {
		messageController.sendMessage(event.getGuild(), event.getChannel(), event.getAuthor(), "msg_region_fail");
	}

	/**
	 * Language set.
	 *
	 * @param event the event
	 * @param region the region
	 */
	private void languageSet(MessageReceivedEvent event, String region) {
		languageService.setRegion(event.getAuthor(), region);
		messageController.sendMessage(event.getGuild(), event.getChannel(), event.getAuthor(), "msg_region_sucess");
	}

}
