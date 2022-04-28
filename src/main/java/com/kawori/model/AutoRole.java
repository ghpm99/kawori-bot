package com.kawori.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.jetbrains.annotations.NotNull;

import lombok.Data;


@Data
@Entity
public class AutoRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@NotNull
	private String guild;

	@NotNull
	private String channel;

	@NotNull
	private String text;

	@NotNull
	private String role;

	@NotNull
	private boolean canceled;

}
