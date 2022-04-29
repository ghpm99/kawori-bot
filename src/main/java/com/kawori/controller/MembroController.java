package com.kawori.controller;

import org.springframework.stereotype.Controller;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

@Controller
public class MembroController {

	OperatorController operatorController;

	public void updateAllMembers(Guild guild) {

		guild.loadMembers((member) -> {

			updateMember(member);
		});
	}

	private void updateMember(Member member) {

	}

	public void updateCanGearMember(Member member) {

	}

}
