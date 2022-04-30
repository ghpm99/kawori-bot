package com.kawori.repository;

import java.util.Optional;

import com.kawori.model.UserDiscord;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserDiscord, Long> {

	public Optional<UserDiscord> findById(long id);

	public Optional<UserDiscord> findByIdDiscord(long discordId);

}
