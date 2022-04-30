package com.kawori.service;

import java.util.List;

import com.kawori.model.GuildDiscord;
import com.kawori.repository.GuildRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GuildService {

	private GuildRepository guildRepository;

	@Autowired
	public GuildService(GuildRepository guildRepository) {
		this.guildRepository = guildRepository;
	}

	public GuildDiscord save(GuildDiscord guild) {

		return guildRepository.save(guild);
	}

	public GuildDiscord findById(long id) {
		return guildRepository.findById(id).orElseGet(() -> {
			GuildDiscord guild = new GuildDiscord();
			guild.setId(id);
			return guild;
		});
	}

	public List<GuildDiscord> findAll() {
		return guildRepository.findAll();
	}

	public long count() {
		return guildRepository.count();
	}

	public Page<GuildDiscord> findAll(Pageable pageable){
		return guildRepository.findAll(pageable);
	}

	public GuildDiscord findbyIdDiscord(long id){
		return guildRepository.findByIdDiscord(id).orElseGet(() -> {
			GuildDiscord guild = new GuildDiscord();
			guild.setId(id);
			return guild;
		});
	}

	public void registerGuild(long idDiscord, String name, long idOwner) {
		GuildDiscord guild = findbyIdDiscord(idDiscord);
		guild.setName(name);
		guild.setIdOwner(idOwner);
		guild.updateLastMessage();
		save(guild);
	}

}
