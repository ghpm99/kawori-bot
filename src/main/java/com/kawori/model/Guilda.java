package com.kawori.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Guilda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String name;
	private boolean active;
	private String region;
	private boolean block;
	private boolean site;
	private String idOwner;
	private String defaultTextChannel;
	private String defaultWelcomeMessage;
	private int cmdCount;
	private int level;
	private int exp;
	private int expRequired;

}
