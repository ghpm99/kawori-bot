package com.kawori.repository;

import com.kawori.model.ChannelDiscord;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CanalRepository extends JpaRepository<ChannelDiscord, Long> {

}
