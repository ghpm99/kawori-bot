package com.kawori.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class Operator.
 */
@Data
@Entity
public class Operator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private long idDiscord;

	/** The name. */
	private String name;

	/** The discriminator. */
	private String discriminator;

	/** The banned. */
	private boolean banned;

	/** The email. */
	private String email;

	/** The password. */
	private String password;

	/** The level. */
	private int level;

	/** The exp. */
	private int exp;

	/** The exp required. */
	private int expRequired;

	/** The msg count. */
	private int msgCount;

	/** The cmd count. */
	private int cmdCount;

	/** The region. */
	private String region;

	/** The web authorized. */
	private boolean webAuthorized;

	/** The role. */
	private String role;
}
