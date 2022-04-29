package com.kawori.controller;

import java.awt.Color;
import java.util.List;

import com.kawori.model.Membro;

import org.springframework.stereotype.Controller;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.events.role.update.RoleUpdatePermissionsEvent;

@Controller
public class GuildaController {

	public void onGuildMemberJoin(Guild guild, Member member) {

		Membro membro = findMember(member.getId(), guild.getId());

		membro.setVisitor(true);

		membro.setNick(member.getNickname());

		membro.setFamilyName(member.getUser().getName());

		// sendMessageOnJoin(guild, member);

	}

	public void onGuildMemberLeave(Guild guild, User user) {

		Membro membro = findMember(user.getId(), guild.getId());

		membro.setVisitor(false);
		membro.setHero(false);
		membro.setNovice(false);

	}

	public Membro findMember(String id, String idGuild) {

		return null;
	}

	public void onRoleCreate(RoleCreateEvent event) {

	}

	public void onRoleUpdatePermissions(RoleUpdatePermissionsEvent event) {

	}

	public void onRoleUpdateName(String id, String newName) {

	}

	public void onRoleDelete(RoleDeleteEvent event) {

	}

	public void onGuildUpdateName(String id, String newName) {

	}

	public void onGuildUpdateOwner(String id, String idNewOwner) {

	}

	public void updateGuildTag(Guild guild) {

	}

	public boolean isTag(String name, Color color) {

		return false;
	}

	public void onGuildMemberUpdateNickname(Member member, String newNick) {

	}

	public void updateGuildChannel(Guild guild) {
		guild.getTextChannels().forEach((canal) -> {
			onTextChannelUpdateName(canal);
		});
	}

	public void onTextChannelCreate(TextChannel event) {

	}

	public void onTextChannelUpdateName(TextChannel event) {

	}

	public void onGuildMemberRoleAdd(Guild guild, List<Role> roles, Member member) {

	}

	public void onGuildMemberRoleRemove(Guild guild, List<Role> roles, Member member) {

	}

}
