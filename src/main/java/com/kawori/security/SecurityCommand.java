package com.kawori.security;

import com.kawori.util.Util;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityCommand.
 */
public class SecurityCommand {


	/**
	 * Authenticate command.
	 *
	 * @param event      the event
	 * @param permission the permission
	 * @return true, if successful
	 */
	public boolean authenticateCommand(MessageReceivedEvent event, Permissions permission) {

		if (event.getAuthor().getId().equals(Util.idUserAdm)) {
			return true;
		}
		boolean retorno = false;
		boolean canSpeak = verifyCanSpeak(event.getTextChannel());
		boolean canUse = verifyRoles(event.getMember(), permission);
		boolean userBanned = verifyIsUserBanned(event.getAuthor());
		boolean guildBanned = verifyIsGuildBanned(event.getGuild());
		if (verifyIsOwner(event.getMember()) && !permission.equals(Permissions.CMD_DEV)) {
			canUse = true;
			canSpeak = true;
		}
		retorno = canSpeak && canUse && !userBanned && !guildBanned;
		return retorno;

	}

	/**
	 * Verify can speak.
	 *
	 * @param channel the channel
	 * @return true, if successful
	 */
	private boolean verifyCanSpeak(TextChannel channel) {
		return true;
	}

	/**
	 * Verify roles.
	 *
	 * @param author     the author
	 * @param permission the permission
	 * @return true, if successful
	 */
	private boolean verifyRoles(Member author, Permissions permission) {
		boolean atual = false;
		for (Role role : author.getRoles()) {
			atual = atual | verifyRole(role, permission);
		}

		return atual;
	}

	/**
	 * Verify role.
	 *
	 * @param role       the role
	 * @param permission the permission
	 * @return true, if successful
	 */
	private boolean verifyRole(Role role, Permissions permission) {
		return true;

	}

	/**
	 * Verify is user banned.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	private boolean verifyIsUserBanned(User user) {
		return false;
	}

	/**
	 * Verify is guild banned.
	 *
	 * @param guild the guild
	 * @return true, if successful
	 */
	private boolean verifyIsGuildBanned(Guild guild) {
		return false;
	}

	/**
	 * Verify is owner.
	 *
	 * @param author the author
	 * @return true, if successful
	 */
	private boolean verifyIsOwner(Member author) {
		return author.isOwner();
	}

}
