package com.kawori.app.pick.command;

import java.util.Random;

import com.kawori.command.Command;
import com.kawori.command.CommandHandler;
import com.kawori.message.MessageController;
import com.kawori.security.Permissions;
import com.kawori.util.Util;

import org.springframework.stereotype.Controller;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@Controller
public class Pick extends Command {

	public Pick() {
		CommandHandler.commands.put("pick", this);
	}

	private MessageController messageController;

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

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {

	}

	@Override
	public String help() {
		return "msg_pick_help";
	}

	@Override
	public String helpShort() {
		return "msg_pick_helpshort";
	}

	@Override
	public Permissions getPermissions() {
		return Permissions.CMD_FUN;
	}

}
