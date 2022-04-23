/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawori.command.commands;

import java.util.Random;

import com.kawori.command.Command;
import com.kawori.message.MessageController;
import com.kawori.security.Permissions;
import com.kawori.util.Util;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class CmdPick.
 *
 * @author ghpm9
 */
public class CmdPick extends Command {

	/** The message controller. */
	private MessageController messageController;

	/**
	 * Action.
	 *
	 * @param args  the args
	 * @param event the event
	 */
	@Override
	public void action(String[] args, MessageReceivedEvent event) {

		String msg = event.getMessage().getContentDisplay().replaceFirst(Util.PREFIX + "pick ", "");

		String[] msgSplit = msg.split(",");

		if (msgSplit.length < 2) {
			messageController.sendMessage(event.getGuild(), event.getChannel(), event.getAuthor(), "msg_pick_error");
			return;
		}

		Random rng = new Random();

		String result = msgSplit[rng.nextInt(msgSplit.length)];

		messageController.sendMessageSingle(event.getGuild(), event.getChannel(), event.getAuthor(), result);

	}

	/**
	 * Executed.
	 *
	 * @param success the success
	 * @param event   the event
	 */
	@Override
	public void executed(boolean success, MessageReceivedEvent event) {

	}

	/**
	 * Help.
	 *
	 * @return the string
	 */
	@Override
	public String help() {
		return "msg_pick_help";
	}

	/**
	 * Help short.
	 *
	 * @return the string
	 */
	@Override
	public String helpShort() {
		// TODO Auto-generated method stub
		return "msg_pick_helpshort";
	}

	/**
	 * Gets the permissions.
	 *
	 * @return the permissions
	 */
	@Override
	public Permissions getPermissions() {
		// TODO Auto-generated method stub
		return Permissions.CMD_FUN;
	}

}
