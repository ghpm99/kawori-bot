package com.kawori.app.info.command;


import com.kawori.command.Command;
import com.kawori.command.CommandHandler;
import com.kawori.message.EmbedPattern;
import com.kawori.message.MessageController;
import com.kawori.model.Membro;
import com.kawori.security.Permissions;

import org.springframework.stereotype.Controller;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;


@Controller
public class Info extends Command {

	public Info(){
		CommandHandler.commands.put("info", this);
	}

	private MessageController messageController = new MessageController();
	private EmbedPattern embedPattern = new EmbedPattern();

	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		Membro membro = new Membro();
		String familyName = "null";
		String personagemName = "null";
		String gearName = "null";

		if (membro != null) {
			familyName = membro.getFamilyName();
		}

		messageController.sendEmbed(event.getChannel(), embedPattern.createEmbedInfoUser(event.getAuthor(),
				event.getChannel(), event.getGuild(), familyName, personagemName, gearName));
	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {

	}

	@Override
	public String help() {
		return "msg_info_help";
	}

	@Override
	public String helpShort() {
		return "msg_info_helpshort";
	}

	@Override
	public Permissions getPermissions() {
		return Permissions.CMD_UTIL;
	}

}
