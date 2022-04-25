/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kawori.app.avatar.command;

import java.util.List;

import com.kawori.command.Command;
import com.kawori.message.EmbedPattern;
import com.kawori.message.MessageController;
import com.kawori.security.Permissions;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class CmdAvatar.
 *
 * @author ghpm9
 */

public class Avatar extends Command {

	/** The message controller. */

	private MessageController messageController;

	/** The embed pattern. */

	private EmbedPattern embedPattern;

	/**
	 * Action.
	 *
	 * @param args the args
	 * @param event the event
	 */
	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		List<Member> mention = event.getMessage().getMentionedMembers();
		User user;
		if (mention.isEmpty()) {
			user = event.getAuthor();

		} else {
			user = mention.get(0).getUser();
		}

		messageController.sendEmbed(event.getChannel(), embedPattern.createEmbedImage(user, event.getChannel(),
				event.getGuild(), user.getAvatarUrl() + "?size=1024", "msg_avatar_sucess"), null);
	}

	/**
	 * Executed.
	 *
	 * @param success the success
	 * @param event the event
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
		return "msg_avatar_help";
	}


	/**
	 * Help short.
	 *
	 * @return the string
	 */
	@Override
	public String helpShort() {
		// TODO Auto-generated method stub
		return "msg_avatar_helpshort";
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
