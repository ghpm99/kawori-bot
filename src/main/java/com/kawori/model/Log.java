package com.kawori.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Log{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date hour;
	private String event;
	private String guild;
	private String userDiscord;
	private String status;
}
