package com.kawori.controller;


// TODO: Auto-generated Javadoc
/**
 * The Class ExperienceController.
 */

public class ExperienceController {



	/**
	 * Message event.
	 *
	 * @param idUser the id user
	 * @param idGuild the id guild
	 */
	public void messageEvent(String idUser, String idGuild) {
		increaseExpGuild(idGuild);
		increaseExpUser(idUser);
	}

	/**
	 * Increase exp guild.
	 *
	 * @param idGuild the id guild
	 */
	private void increaseExpGuild(String idGuild) {

	}

	/**
	 * Increase exp user.
	 *
	 * @param idUser the id user
	 */
	private void increaseExpUser(String idUser) {

	}

}
