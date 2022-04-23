package com.kawori.controller;


import com.kawori.util.Util;

import net.dv8tion.jda.api.entities.Guild;

// TODO: Auto-generated Javadoc
/**
 * The Class BotController.
 */

public class BotController {




	/**
	 * On guild join.
	 *
	 * @param guild the guild
	 */
	public void onGuildJoin(Guild guild) {

		reportGuild(guild.getName() + " adicionou o bot", guild);
	}

	/**
	 * On guild leave.
	 *
	 * @param guild the guild
	 */
	public void onGuildLeave(Guild guild) {
		reportGuild(guild.getName() + " expulsou o bot", guild);
	}

	/**
	 * Report guild.
	 *
	 * @param report the report
	 * @param guild the guild
	 */
	private void reportGuild(String report, Guild guild) {
		guild.getJDA().getGuildById(Util.idGuildAdm).getTextChannelById(Util.idLogChannel).sendMessage(report).queue();
	}

}
