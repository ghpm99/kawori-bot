package com.kawori.service;

import java.util.List;

import com.kawori.model.Guilda;
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

	public Guilda save(Guilda guild) {

		return guildaRepository.save(guild);
	}

	public Guilda findById(String id) {
		return guildaRepository.findById(id).orElseGet(() -> {
			Guilda guild = new Guilda();
			guild.setId(id);
			return guild;
		});
	}

	public List<Guilda> findAll() {
		return guildaRepository.findAll();
	}

	public long count() {
		return guildaRepository.count();
	}

	public Page<Guilda> findAll(Pageable pageable){
		return guildaRepository.findAll(pageable);
	}

}
