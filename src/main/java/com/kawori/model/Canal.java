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
	private long idGuild;
	private String name;
	private String tipo;
	private boolean sendMessage;


}
