package com.kawori.listener;

import com.kawori.controller.BotController;
import com.kawori.service.StatusService;
import com.kawori.util.Util;

import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving ready events.
 * The class that is interested in processing a ready
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addReadyListener<code> method. When
 * the ready event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ReadyEvent
 */

public class ReadyListener extends ListenerAdapter {

	/** The status service. */

	private StatusService statusService = new StatusService();

	/** The bot controller. */

	private BotController botController = new BotController();

	/** The log. */


	/**
	 * On ready.
	 *
	 * @param e the e
	 */
	@Override
	public void onReady(ReadyEvent e) {

		e.getJDA().getGuilds().forEach((guild) -> {
			botController.onGuildJoin(guild);
		});

		statusService.setStatusBot("Online");

		e.getJDA().getPresence().setActivity(Activity.playing(Util.PREFIX + "help"));

	}



}
