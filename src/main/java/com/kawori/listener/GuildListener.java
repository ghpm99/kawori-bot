package com.kawori.listener;

import com.kawori.controller.GuildaController;

import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.text.update.TextChannelUpdateNameEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateNameEvent;
import net.dv8tion.jda.api.events.guild.update.GuildUpdateOwnerEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.events.role.update.RoleUpdateNameEvent;
import net.dv8tion.jda.api.events.role.update.RoleUpdatePermissionsEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


@Component
public class GuildListener extends ListenerAdapter {


	private GuildaController guildaController = new GuildaController();

	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		guildaController.onGuildMemberJoin(event.getGuild(), event.getMember());
	}

	@Override
	public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
		super.onGuildMemberRemove(event);
		guildaController.onGuildMemberLeave(event.getGuild(), event.getUser());
	}

	@Override
	public void onRoleCreate(RoleCreateEvent event) {
		guildaController.onRoleCreate(event);
	}

	@Override
	public void onRoleUpdatePermissions(RoleUpdatePermissionsEvent event) {
		guildaController.onRoleUpdatePermissions(event);
	}

	@Override
	public void onRoleUpdateName(RoleUpdateNameEvent event) {
		super.onRoleUpdateName(event);
		guildaController.onRoleUpdateName(event.getRole().getId(), event.getNewName());
	}

	@Override
	public void onRoleDelete(RoleDeleteEvent event) {
		guildaController.onRoleDelete(event);
	}

	@Override
	public void onGuildUpdateName(GuildUpdateNameEvent event) {
		super.onGuildUpdateName(event);
		guildaController.onGuildUpdateName(event.getGuild().getId(), event.getNewName());

	}

	@Override
	public void onGuildUpdateOwner(GuildUpdateOwnerEvent event) {
		super.onGuildUpdateOwner(event);
		guildaController.onGuildUpdateOwner(event.getGuild().getId(), event.getNewOwnerId());
	}

	@Override
	public void onGuildMemberUpdateNickname(GuildMemberUpdateNicknameEvent event) {
		super.onGuildMemberUpdateNickname(event);
		guildaController.onGuildMemberUpdateNickname(event.getMember(), event.getNewNickname());
	}

	@Override
	public void onTextChannelCreate(TextChannelCreateEvent event) {
		super.onTextChannelCreate(event);
		guildaController.onTextChannelCreate(event.getChannel());
	}

	@Override
	public void onTextChannelUpdateName(TextChannelUpdateNameEvent event) {
		super.onTextChannelUpdateName(event);
		guildaController.onTextChannelUpdateName(event.getChannel());

	}

	@Override
	public void onGuildMemberRoleAdd(GuildMemberRoleAddEvent event) {
		super.onGuildMemberRoleAdd(event);
		guildaController.onGuildMemberRoleAdd(event.getGuild(), event.getRoles(), event.getMember());
	}

	@Override
	public void onGuildMemberRoleRemove(GuildMemberRoleRemoveEvent event) {
		super.onGuildMemberRoleRemove(event);
		guildaController.onGuildMemberRoleRemove(event.getGuild(), event.getRoles(), event.getMember());
	}

}
