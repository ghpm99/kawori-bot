package com.kawori.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    private String command;
    private String uuid;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    private Date createAt;
    private Date finishAt;

    public void generatedUUID(){
        this.uuid = java.util.UUID.randomUUID().toString();
    }

    public void createAtNow(){
        this.createAt = new Date();
    }

    public void finishAtNow(){
        this.finishAt = new Date();
    }

    public enum Status {
        PENDING(0, "Pendente"),
        PROCESSING(1, "Processando"),
        FINISHED(2, "Finalizado"),
        ERROR(3, "Erro");

        private int code;
        private String description;

        private Status(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }
}
