package com.kawori.service;

import com.kawori.model.MessageDiscord;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public MessageDiscord createNewMessage(long idDiscord, long idUserDiscord, long idGuildDiscord){
        MessageDiscord messageDiscord = new MessageDiscord();
		messageDiscord.setIdDiscord(idDiscord);
		messageDiscord.setIdUserDiscord(idUserDiscord);
		messageDiscord.setIdGuildDiscord(idGuildDiscord);
		messageDiscord.setCommand("");
		messageDiscord.generatedUUID();
		messageDiscord.setStatus(MessageDiscord.Status.PENDING);
        messageDiscord.createAtNow();
        return messageDiscord;
    }

    public MessageDiscord finishMessage(MessageDiscord messageDiscord) {
        messageDiscord.setStatus(MessageDiscord.Status.FINISHED);
        messageDiscord.finishAtNow();
        return messageDiscord;
    }

}
