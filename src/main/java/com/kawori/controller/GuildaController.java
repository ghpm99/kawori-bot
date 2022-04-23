package com.kawori.controller;

import java.awt.Color;
import java.util.List;

import com.kawori.message.MessageController;
import com.kawori.model.AdventureFame;
import com.kawori.model.ColorBD;
import com.kawori.model.Guilda;
import com.kawori.model.Membro;
import com.kawori.model.Tag;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.events.role.update.RoleUpdatePermissionsEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class GuildaController.
 */

public class GuildaController {

	/** The tag service. */

	/** The message controller. */

	private MessageController messageController;

	/**
	 * On guild member join.
	 *
	 * @param guild the guild
	 * @param member the member
	 */
	public void onGuildMemberJoin(Guild guild, Member member) {

		Membro membro = findMember(member.getId(), guild.getId());

		membro.setVisitor(true);

		membro.setNick(member.getNickname());

		membro.setFamilyName(member.getUser().getName());

		//sendMessageOnJoin(guild, member);

	}

	/**
	 * On guild member leave.
	 *
	 * @param guild the guild
	 * @param user the user
	 */
	public void onGuildMemberLeave(Guild guild, User user) {

		Membro membro = findMember(user.getId(), guild.getId());

		membro.setVisitor(false);
		membro.setHero(false);
		membro.setNovice(false);

	}

	/**
	 * Find member.
	 *
	 * @param id the id
	 * @param idGuild the id guild
	 * @return the membro
	 */
	public Membro findMember(String id, String idGuild) {

		return null;
	}

	/**
	 * On role create.
	 *
	 * @param event the event
	 */
	public void onRoleCreate(RoleCreateEvent event) {

	}

	/**
	 * On role update permissions.
	 *
	 * @param event the event
	 */
	public void onRoleUpdatePermissions(RoleUpdatePermissionsEvent event) {


	}

	/**
	 * On role update name.
	 *
	 * @param id the id
	 * @param newName the new name
	 */
	public void onRoleUpdateName(String id, String newName) {

	}

	/**
	 * On role delete.
	 *
	 * @param event the event
	 */
	public void onRoleDelete(RoleDeleteEvent event) {

	}

	/**
	 * On guild update name.
	 *
	 * @param id the id
	 * @param newName the new name
	 */
	public void onGuildUpdateName(String id, String newName) {

	}

	/**
	 * On guild update owner.
	 *
	 * @param id the id
	 * @param idNewOwner the id new owner
	 */
	public void onGuildUpdateOwner(String id, String idNewOwner) {

	}

	/**
	 * Sets the permission.
	 *
	 * @param tag the tag
	 * @param roleDiscord the role discord
	 */
	private void setPermission(Tag tag, Role roleDiscord) {
		tag.setAdministrator(roleDiscord.hasPermission(Permission.ADMINISTRATOR));
		tag.setManageChannels(roleDiscord.hasPermission(Permission.MANAGE_CHANNEL));
		tag.setManagePermissions(roleDiscord.hasPermission(Permission.MANAGE_PERMISSIONS));
		tag.setManageRoles(roleDiscord.hasPermission(Permission.MANAGE_ROLES));
		tag.setManageServer(roleDiscord.hasPermission(Permission.MANAGE_SERVER));
		tag.setMessageManage(roleDiscord.hasPermission(Permission.MESSAGE_MANAGE));
		tag.setMessageMentionEveryone(roleDiscord.hasPermission(Permission.MESSAGE_MENTION_EVERYONE));
		tag.setMessageRead(roleDiscord.hasPermission(Permission.MESSAGE_READ));
		tag.setMessageWrite(roleDiscord.hasPermission(Permission.MESSAGE_WRITE));
		tag.setNicknameChange(roleDiscord.hasPermission(Permission.NICKNAME_CHANGE));
		tag.setNicknameManage(roleDiscord.hasPermission(Permission.NICKNAME_MANAGE));
	}

	/**
	 * Creates the new tag.
	 *
	 * @param guild the guild
	 * @param role the role
	 * @return the tag
	 */
	private Tag createNewTag(Guild guild, Role role) {
		Tag tag = new Tag();
		tag.setIdGuild(guild.getId());
		tag.setIdRole(role.getId());
		tag.setName(role.getName());
		tag.setPosition(role.getPosition());
		tag.setColor(role.getColor());

		setPermission(tag, role);

		Color color = role.getColor();

		if (color == null)
			color = Color.WHITE;

		tag.setBotRole(isTag(role.getName(), color));

		tag.setActive(true);

		tag.setCmdAdm(guild.getRoles().indexOf(role) == 0);
		tag.setCmdNodeWar(guild.getRoles().indexOf(role) <= 1);
		tag.setCmdRank(guild.getRoles().indexOf(role) <= 2);
		tag.setCmdBuild(guild.getRoles().indexOf(role) <= 3);
		tag.setCmdFun(guild.getRoles().indexOf(role) <= 4);
		tag.setCmdUtil(true);

		return tag;
	}

	/**
	 * Update guild tag.
	 *
	 * @param guild the guild
	 */
	public void updateGuildTag(Guild guild) {

	}

	/**
	 * Checks if is tag.
	 *
	 * @param name the name
	 * @param color the color
	 * @return true, if is tag
	 */
	public boolean isTag(String name, Color color) {

		return false;
	}

	/**
	 * Verify is tag.
	 *
	 * @param roleName the role name
	 * @param type the type
	 * @return true, if successful
	 */
	private boolean verifyIsTag(String roleName, String type) {

		return false;
	}

	/**
	 * Send message on join.
	 *
	 * @param guild the guild
	 * @param member the member
	 */
	private void sendMessageOnJoin(Guild guild, Member member) {


	}

	/**
	 * On guild member update nickname.
	 *
	 * @param member the member
	 * @param newNick the new nick
	 */
	public void onGuildMemberUpdateNickname(Member member, String newNick) {

	}

	/**
	 * Update guild channel.
	 *
	 * @param guild the guild
	 */
	public void updateGuildChannel(Guild guild) {
		guild.getTextChannels().forEach((canal) -> {
			onTextChannelUpdateName(canal);
		});
	}

	/**
	 * On text channel create.
	 *
	 * @param event the event
	 */
	public void onTextChannelCreate(TextChannel event) {


	}

	/**
	 * On text channel update name.
	 *
	 * @param event the event
	 */
	public void onTextChannelUpdateName(TextChannel event) {

	}

	/**
	 * On guild member role add.
	 *
	 * @param guild the guild
	 * @param roles the roles
	 * @param member the member
	 */
	public void onGuildMemberRoleAdd(Guild guild, List<Role> roles, Member member) {

	}

	/**
	 * On guild member role remove.
	 *
	 * @param guild the guild
	 * @param roles the roles
	 * @param member the member
	 */
	public void onGuildMemberRoleRemove(Guild guild, List<Role> roles, Member member) {


	}

}
