package com.kawori.repository;

import java.util.List;
import java.util.Optional;

import com.kawori.model.RoleDiscord;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<RoleDiscord, Long> {

	public List<RoleDiscord> findByIdGuildAndBotRole(long idGuild, boolean isBotRole);

	public List<RoleDiscord> findByIdGuild(long idGuild);

	public List<RoleDiscord> findByIdGuildAndName(long idGuild, String name);

	public Optional<RoleDiscord> findByIdRole(long idRole);

	public Optional<RoleDiscord> findByIdGuildAndIdRole(long idGuild, long idRole);

}
