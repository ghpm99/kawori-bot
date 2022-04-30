package com.kawori.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class ChannelDiscord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long idGuild;
	private String name;
	private String tipo;
	private boolean sendMessage;


}
