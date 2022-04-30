package com.kawori.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class GuildDiscord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long idDiscord;
	private long idOwner;
	private String name;
	private boolean active;
	private boolean block;
	private String defaultTextChannel;
	private String defaultWelcomeMessage;
	private int cmdCount;
	private int level;
	private int exp;
	private int expRequired;
	private Date lastMessage;

	public void updateLastMessage() {
		this.lastMessage = new Date();
	}
}
