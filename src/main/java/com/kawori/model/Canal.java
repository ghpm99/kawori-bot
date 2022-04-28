package com.kawori.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Canal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	/** The id guild. */
	private long idGuild;

	/** The name. */
	private String name;

	/** The tipo. */
	private String tipo;

	/** The send message. */
	private boolean sendMessage;


}
