package com.kawori.service;

import java.util.List;

import com.kawori.model.GuildDiscord;
import com.kawori.repository.GuildaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GuildaService {

	private GuildaRepository guildaRepository;

	@Autowired
	public GuildaService(GuildaRepository guildaRepository) {
		this.guildaRepository = guildaRepository;
	}

	public GuildDiscord save(GuildDiscord guild) {

		return guildaRepository.save(guild);
	}

	public GuildDiscord findById(Long id) {
		return guildaRepository.findById(id).orElseGet(() -> {
			GuildDiscord guild = new GuildDiscord();
			guild.setId(id);
			return guild;
		});
	}

	public List<GuildDiscord> findAll() {
		return guildaRepository.findAll();
	}

	public long count() {
		return guildaRepository.count();
	}

	public Page<GuildDiscord> findAll(Pageable pageable){
		return guildaRepository.findAll(pageable);
	}

}
