package com.kawori.security;

import com.kawori.util.Util;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;


public class SecurityCommand {

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

	private boolean verifyCanSpeak(TextChannel channel) {
		return true;
	}

	private boolean verifyRoles(Member author, Permissions permission) {
		boolean atual = false;
		for (Role role : author.getRoles()) {
			atual = atual | verifyRole(role, permission);
		}

		return atual;
	}

	private boolean verifyRole(Role role, Permissions permission) {
		return true;
	}

	private boolean verifyIsUserBanned(User user) {
		return false;
	}

	private boolean verifyIsGuildBanned(Guild guild) {
		return false;
	}

	private boolean verifyIsOwner(Member author) {
		return author.isOwner();
	}

}
