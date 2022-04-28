package com.kawori.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class Membro.
 */
@Data
@Entity
public class Membro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String idDiscord;
	private String idGuild;
	private String idUser;
	private String nick;
	private String familyName;
	private boolean banned;
	private boolean gear;
	private Date gearUpdate;
	private boolean hero;
	private boolean visitor;
	private boolean novice;

}
