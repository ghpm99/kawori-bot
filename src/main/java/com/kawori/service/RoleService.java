package com.kawori.service;

import java.util.List;

import com.kawori.model.RoleDiscord;
import com.kawori.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	private RoleRepository tagRepository;

	@Autowired
	public RoleService(RoleRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	public RoleDiscord save(RoleDiscord role) {

		return tagRepository.save(role);
	}

	public List<RoleDiscord> findByIdGuildAndBotRole(long idGuild, boolean botRole) {
		return tagRepository.findByIdGuildAndBotRole(idGuild, botRole);
	}

	public List<RoleDiscord> findByIdGuild(long idGuild) {
		return tagRepository.findByIdGuild(idGuild);
	}

	public List<RoleDiscord> findByIdGuildAndName(long idGuild, String name) {
		return tagRepository.findByIdGuildAndName(idGuild, name);
	}

	public RoleDiscord findByIdRole(long idRole) {
		return tagRepository.findByIdRole(idRole).orElseGet(() -> {
			RoleDiscord tag = new RoleDiscord();
			tag.setIdRole(idRole);
			return tag;
		});
	}

	public void delete(RoleDiscord tag) {
		this.tagRepository.delete(tag);
	}

	public List<RoleDiscord> findAll() {
		return tagRepository.findAll();
	}

	public Page<RoleDiscord> findAll(Pageable pgbl) {
		return tagRepository.findAll(pgbl);
	}

	public RoleDiscord findByIdGuildAndIdRole(long idGuild, long idRole) {
		return tagRepository.findByIdGuildAndIdRole(idGuild, idRole).orElseGet(() -> {
			RoleDiscord tag = new RoleDiscord();
			tag.setIdGuild(idGuild);
			tag.setIdRole(idRole);
			return tag;
		});
	}

}
