package com.kawori.service;

import java.util.List;

import com.kawori.model.Canal;
import com.kawori.repository.CanalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.dv8tion.jda.api.entities.TextChannel;


@Service
public class CanalService {

	@Autowired
	private CanalRepository canalRepository;

	public Canal save(Canal canal) {

		return canalRepository.save(canal);
	}

	public Canal findById(String id) {
		return canalRepository.findById(id).orElseGet(() -> {
			Canal canal = new Canal();
			canal.setId(id);
			return canal;
		});
	}

	public Canal createNew(TextChannel channel) {
		Canal canal = new Canal();

		canal.setId(channel.getId());
		canal.setName(channel.getName());
		canal.setIdGuild(channel.getGuild().getIdLong());
		canal.setSendMessage(true);
		canal.setTipo(channel.getType().name());

		return save(canal);
	}

	public Canal UpdateCanal(TextChannel channel) {
		Canal canal = findById(channel.getId());

		canal.setName(channel.getName());

		return save(canal);
	}

	public List<Canal> findAll(){
		return canalRepository.findAll();
	}

	public Page<Canal> findAll(Pageable pageable){
		return canalRepository.findAll(pageable);
	}

}
