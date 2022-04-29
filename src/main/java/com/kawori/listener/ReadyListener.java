package com.kawori.listener;

import com.kawori.controller.BotController;
import com.kawori.service.StatusService;
import com.kawori.util.Util;

import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class ReadyListener extends ListenerAdapter {

	private StatusService statusService = new StatusService();
	private BotController botController = new BotController();

	@Override
	public void onReady(ReadyEvent e) {
		e.getJDA().getGuilds().forEach((guild) -> {
			botController.onGuildJoin(guild);
		});
		statusService.setStatusBot("Online");
		e.getJDA().getPresence().setActivity(Activity.playing(Util.PREFIX + "help"));
	}

}
