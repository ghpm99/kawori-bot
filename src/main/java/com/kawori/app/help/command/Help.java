package com.kawori.app.help.command;

import com.kawori.command.Command;
import com.kawori.command.CommandHandler;
import com.kawori.message.EmbedPattern;
import com.kawori.message.MessageController;
import com.kawori.security.Permissions;

import org.springframework.stereotype.Controller;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;


@Controller
public class Help extends Command {

	public Help() {
		CommandHandler.commands.put("help", this);
	}

	private MessageController messageController;
	private EmbedPattern embedPattern;

	public void action(String[] args, MessageReceivedEvent event) {
		if (args.length == 0 || args[0].toLowerCase().equals("all")) {
			showAll(event.getGuild(), event.getChannel(), event.getAuthor());
		} else {
			showHelp(event.getGuild(), event.getChannel(), event.getAuthor(),
					CommandHandler.commands.get(args[0].toLowerCase()), args[0]);
		}

	}

	public void executed(boolean success, MessageReceivedEvent event) {

	}

	public String help() {
		return "msg_help_help";
	}

	@Override
	public String helpShort() {
		return "msg_help_helpshort";
	}

	private void showAll(Guild guild, MessageChannel channel, User user) {
		EmbedBuilder embed = embedPattern.createEmbedHelpAll(user, channel, guild, CommandHandler.commands);
		messageController.sendEmbed(channel, embed);
	}

	private void showHelp(Guild guild, MessageChannel channel, User user, Command command, String commandKey) {
		if (command == null)
			return;
		EmbedBuilder embed = embedPattern.createEmbedHelp(user, channel, guild, command, commandKey);
		messageController.sendEmbed(channel, embed);
	}

	@Override
	public Permissions getPermissions() {
		return Permissions.CMD_UTIL;
	}

}
