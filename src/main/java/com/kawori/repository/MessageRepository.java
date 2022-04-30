package com.kawori.repository;

import com.kawori.model.MessageDiscord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageDiscord, Long>{

}
