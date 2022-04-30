package com.kawori.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserDiscord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long idDiscord;
	private String name;
	private String discriminator;
	private boolean banned;
	private String email;
	private String password;
	private int level;
	private int exp;
	private int expRequired;
	private int msgCount;
	private int cmdCount;
	private String region;
	private boolean webAuthorized;
	private String role;
}
