package com.kawori.repository;

import java.util.List;
import java.util.Optional;

import com.kawori.model.GuildDiscord;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GuildRepository extends JpaRepository<GuildDiscord, Long> {

	public Optional<GuildDiscord> findById(long id);

	public List<GuildDiscord> findByName(String name);

	public List<GuildDiscord> findByIdOwner(String id);

	public Optional<GuildDiscord> findByIdDiscord(long id);

}
