package com.kawori.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MessageDiscord {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private long idDiscord;
    private long idUserDiscord;
    private long idGuildDiscord;
    private boolean command;
    private String uuid;
    private int status;

    public void generatedUUID(){
        this.uuid = java.util.UUID.randomUUID().toString();
    }
}
