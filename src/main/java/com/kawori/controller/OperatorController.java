package com.kawori.controller;

import com.kawori.model.Operator;

import org.springframework.stereotype.Controller;

import net.dv8tion.jda.api.entities.User;

// TODO: Auto-generated Javadoc
/**
 * The Class OperatorController.
 */
@Controller
public class OperatorController {

	/**
	 * Update operator.
	 *
	 * @param user the user
	 * @return the operator
	 */
	public Operator updateOperator(User user) {
		return new Operator();
	}

	/**
	 * Find operator.
	 *
	 * @param id the id
	 * @return the operator
	 */
	private Operator findOperator(String id) {

		return new Operator();
	}

	/**
	 * On user update name.
	 *
	 * @param id      the id
	 * @param newName the new name
	 */
	public void onUserUpdateName(String id, String newName) {

	}

	/**
	 * On user update discriminator.
	 *
	 * @param id            the id
	 * @param discriminator the discriminator
	 */
	public void onUserUpdateDiscriminator(String id, String discriminator) {

	}

}
