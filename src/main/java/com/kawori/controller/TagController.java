package com.kawori.controller;

import java.util.HashMap;
import java.util.List;

import com.kawori.model.AdventureFame;
import com.kawori.model.ColorBD;
import com.kawori.model.Gear;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

// TODO: Auto-generated Javadoc
/**
 * The Class TagController.
 */

public class TagController {


	/**
	 * Update tag.
	 *
	 * @param gear the gear
	 * @param guild the guild
	 * @param author the author
	 */
	public void updateTag(Gear gear, Guild guild, User author) {


		// removeTagUnusable(messageReceived.getGuild());

	}

	/**
	 * Check player fame.
	 *
	 * @param value the value
	 * @param type the type
	 * @return the adventure fame
	 */
	private AdventureFame checkPlayerFame(int value, String type) {

		return new AdventureFame();
	}

	/**
	 * Check player roles.
	 *
	 * @param guild the guild
	 * @param user the user
	 * @return the hash map
	 */
	private HashMap<String, Role> checkPlayerRoles(Guild guild, User user) {
		List<Role> roles = guild.getMember(user).getRoles();
		HashMap<String, Role> rolesGear = new HashMap<String, Role>();
		for (Role role : roles) {

		}

		return rolesGear;
	}

	/**
	 * Apply tag.
	 *
	 * @param guild the guild
	 * @param userId the user id
	 * @param newTag the new tag
	 * @param color the color
	 */
	private void applyTag(Guild guild, long userId, AdventureFame newTag, ColorBD color) {
		List<Role> roles = guild.getRolesByName(newTag.getName(), true);
		for (Role role : roles) {
			if (role.getColor().equals(color.getColor())) {
				guild.addRoleToMember(userId, role).queue();
				return;
			}

		}

		guild.createRole().setName(newTag.getName()).setColor(color.getColor()).queue((result) -> {
			guild.addRoleToMember(userId, result).queue();
		});

	}

	/**
	 * Verify current tag.
	 *
	 * @param guild the guild
	 * @param userId the user id
	 * @param role the role
	 * @param newFame the new fame
	 * @param color the color
	 */
	private void verifyCurrentTag(Guild guild, long userId, Role role, AdventureFame newFame, ColorBD color) {
		if (!role.getName().equals(newFame.getName())) {
			guild.removeRoleFromMember(userId, role).queue();
			// System.out.println("Removeu a tag " + role.getName());
			applyTag(guild, userId, newFame, color);
		}
	}

	/**
	 * Removes the tag unusable.
	 *
	 * @param guild the guild
	 */
	@Deprecated
	private void removeTagUnusable(Guild guild) {
		List<Role> roles = guild.getRoles();
		for (Role role : roles) {
			if (guild.getMembersWithRoles(role).size() == 0) {
				role.delete().queue();
			}
		}
	}

}
