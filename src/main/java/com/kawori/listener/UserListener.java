package com.kawori.listener;


import com.kawori.controller.OperatorController;

import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.events.user.update.UserUpdateDiscriminatorEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateNameEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


@Component
public class UserListener extends ListenerAdapter {

	private OperatorController operatorController = new OperatorController();

	@Override
	public void onUserUpdateName(UserUpdateNameEvent event) {
		super.onUserUpdateName(event);
		operatorController.onUserUpdateName(event.getUser().getId(), event.getNewName());
	}

	@Override
	public void onUserUpdateDiscriminator(UserUpdateDiscriminatorEvent event) {
		super.onUserUpdateDiscriminator(event);
		operatorController.onUserUpdateDiscriminator(event.getUser().getId(), event.getNewDiscriminator());
	}

}
