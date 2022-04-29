package com.kawori.listener;


import com.kawori.controller.BotController;

import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class BotListener extends ListenerAdapter {

	private BotController botController = new BotController();

	@Override
	public void onGuildJoin(GuildJoinEvent event) {
		botController.onGuildJoin(event.getGuild());
	}

	@Override
	public void onGuildLeave(GuildLeaveEvent event) {
		botController.onGuildLeave(event.getGuild());
	}

}
