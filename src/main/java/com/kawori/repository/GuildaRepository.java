package com.kawori.repository;

import java.util.List;
import java.util.Optional;

import com.kawori.model.GuildDiscord;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GuildaRepository extends JpaRepository<GuildDiscord, String> {

	public Optional<GuildDiscord> findById(Long id);

	public List<GuildDiscord> findByName(String name);

	public List<GuildDiscord> findByIdOwner(String id);



}
