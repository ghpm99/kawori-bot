package com.kawori.app.info.command;


import com.kawori.command.Command;
import com.kawori.command.CommandHandler;
import com.kawori.message.EmbedPattern;
import com.kawori.message.MessageController;
import com.kawori.model.Gear;
import com.kawori.model.Membro;
import com.kawori.model.Personagem;
import com.kawori.security.Permissions;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class CmdInfo.
 */

public class Info extends Command {

	public Info(){
		CommandHandler.commands.put("info", this);
	}

	/** The message controller. */

	private MessageController messageController = new MessageController();

	/** The embed pattern. */

	private EmbedPattern embedPattern = new EmbedPattern();

	/**
	 * Action.
	 *
	 * @param args the args
	 * @param event the event
	 */
	@Override
	public void action(String[] args, MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		Membro membro = new Membro();
		Personagem personagem = new Personagem();
		Gear gear = new Gear();
		String familyName = "null";
		String personagemName = "null";
		String gearName = "null";

		if (membro != null) {
			familyName = membro.getFamilyName();
		}

		if (personagem != null) {
			personagemName = personagem.getName();
		}

		if (gear != null) {
			gearName = String.valueOf(gear.getScore());
		}

		messageController.sendEmbed(event.getChannel(), embedPattern.createEmbedInfoUser(event.getAuthor(),
				event.getChannel(), event.getGuild(), familyName, personagemName, gearName));
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
		return "msg_info_help";
	}



	/**
	 * Help short.
	 *
	 * @return the string
	 */
	@Override
	public String helpShort() {
		// TODO Auto-generated method stub
		return "msg_info_helpshort";
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
