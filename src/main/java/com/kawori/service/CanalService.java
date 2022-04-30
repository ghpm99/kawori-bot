package com.kawori.service;

import java.util.List;

import com.kawori.model.ChannelDiscord;
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

	public ChannelDiscord save(ChannelDiscord canal) {

		return canalRepository.save(canal);
	}

	public ChannelDiscord findById(long id) {
		return canalRepository.findById(id).orElseGet(() -> {
			ChannelDiscord canal = new ChannelDiscord();
			canal.setId(id);
			return canal;
		});
	}

	public ChannelDiscord createNew(TextChannel channel) {
		ChannelDiscord canal = new ChannelDiscord();

		canal.setId(channel.getIdLong());
		canal.setName(channel.getName());
		canal.setIdGuild(channel.getGuild().getIdLong());
		canal.setSendMessage(true);
		canal.setTipo(channel.getType().name());

		return save(canal);
	}

	public ChannelDiscord UpdateCanal(TextChannel channel) {
		ChannelDiscord canal = findById(channel.getIdLong());

		canal.setName(channel.getName());

		return save(canal);
	}

	public List<ChannelDiscord> findAll(){
		return canalRepository.findAll();
	}

	public Page<ChannelDiscord> findAll(Pageable pageable){
		return canalRepository.findAll(pageable);
	}

}
