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

}
