package com.kawori.repository;

import java.util.List;
import java.util.Optional;

import com.kawori.model.Tag;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<Tag, String> {

	public List<Tag> findByIdGuildAndBotRole(String idGuild, boolean isBotRole);

	public List<Tag> findByIdGuild(String idGuild);

	public List<Tag> findByIdGuildAndName(String idGuild, String name);

	public Optional<Tag> findByIdRole(String idRole);

	public Optional<Tag> findByIdGuildAndIdRole(String idGuild, String idRole);

}
