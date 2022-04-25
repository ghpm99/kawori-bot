package com.kawori.controller;

import java.util.List;

import com.kawori.model.Membro;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

// TODO: Auto-generated Javadoc
/**
 * The Class MembroController.
 */

public class MembroController {

	/** The membro service. */



	/** The operator controller. */

	OperatorController operatorController;

	/** The tag service. */



	/**
	 * Update all members.
	 *
	 * @param guild the guild
	 */
	public void updateAllMembers(Guild guild) {

		guild.loadMembers((member) -> {

			updateMember(member);
		});

	}

	/**
	 * Update member.
	 *
	 * @param member the member
	 */
	private void updateMember(Member member) {

	}

	/**
	 * Update edit gear.
	 *
	 * @param member the member
	 * @param membro the membro
	 */
	private void updateEditGear(Member member, Membro membro) {
		membro.setGear(checkRoleGear(member.getRoles()));
	}

	/**
	 * Check role gear.
	 *
	 * @param roles the roles
	 * @return true, if successful
	 */
	private boolean checkRoleGear(List<Role> roles) {

		return true;
	}

	/**
	 * Update can gear member.
	 *
	 * @param member the member
	 */
	public void updateCanGearMember(Member member) {

	}


}
