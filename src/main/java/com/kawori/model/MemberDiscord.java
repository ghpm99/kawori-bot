package com.kawori.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MemberDiscord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long idDiscord;
	private long idGuildDiscord;
	private long idUserDiscord;
	private String nick;
	private boolean banned;

}
