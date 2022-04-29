package com.kawori.app.avatar.command;

import java.util.List;

import com.kawori.command.Command;
import com.kawori.command.CommandHandler;
import com.kawori.message.EmbedPattern;
import com.kawori.message.MessageController;
import com.kawori.security.Permissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@Controller
public class Avatar extends Command {

	public Avatar() {
		CommandHandler.commands.put("avatar", this);
	}

	@Autowired
	private MessageController messageController;
	@Autowired
	private EmbedPattern embedPattern;

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

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {

	}

	@Override
	public String help() {
		return "msg_avatar_help";
	}

	@Override
	public String helpShort() {
		return "msg_avatar_helps>hort";
	}

	@Override
	public Permissions getPermissions() {

		return Permissions.CMD_UTIL;
	}

}
