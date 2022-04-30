package com.kawori.service;

import java.util.List;

import com.kawori.model.MessageDiscord;
import com.kawori.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MessageDiscord save(MessageDiscord message) {
        return messageRepository.save(message);
    }

    public MessageDiscord findById(Long id) {
        return messageRepository.findById(id).orElseGet(() -> {
            MessageDiscord message = new MessageDiscord();
            message.setId(id);
            return message;
        });
    }

    public List<MessageDiscord> findAll() {
        return messageRepository.findAll();
    }

    public MessageDiscord createNewMessage(long idDiscord, long idUserDiscord, long idGuildDiscord){
        MessageDiscord messageDiscord = new MessageDiscord();
		messageDiscord.setIdDiscord(idDiscord);
		messageDiscord.setIdUserDiscord(idUserDiscord);
		messageDiscord.setIdGuildDiscord(idGuildDiscord);
		messageDiscord.setCommand("");
		messageDiscord.generatedUUID();
		messageDiscord.setStatus(MessageDiscord.Status.PENDING);
        messageDiscord.createAtNow();
        return save(messageDiscord);
    }

    public void finishMessage(MessageDiscord messageDiscord) {
        messageDiscord.setStatus(MessageDiscord.Status.FINISHED);
        messageDiscord.finishAtNow();
        save(messageDiscord);
    }

}
