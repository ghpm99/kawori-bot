package com.kawori.controller;


import com.kawori.util.Util;

import org.springframework.stereotype.Controller;

import net.dv8tion.jda.api.entities.Guild;

@Controller
public class BotController {

	public void onGuildJoin(Guild guild) {

		reportGuild(guild.getName() + " adicionou o bot", guild);
	}

	public void onGuildLeave(Guild guild) {
		reportGuild(guild.getName() + " expulsou o bot", guild);
	}

	private void reportGuild(String report, Guild guild) {
		guild.getJDA().getGuildById(Util.idGuildAdm).getTextChannelById(Util.idLogChannel).sendMessage(report).queue();
	}

}
