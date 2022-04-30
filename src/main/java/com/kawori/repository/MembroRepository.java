package com.kawori.repository;

import java.util.List;
import java.util.Optional;

import com.kawori.model.MemberDiscord;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MembroRepository extends JpaRepository<MemberDiscord, Long>{

	public List<MemberDiscord> findByIdUserDiscord(long idUserDiscord);

	public Optional<MemberDiscord> findByIdUserDiscordAndIdGuildDiscord(long idUserDiscord, long idGuildDiscord);

}
