package com.kawori.service;

import java.util.List;

import com.kawori.model.Membro;
import com.kawori.repository.MembroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

@Service
public class MembroService {

	private MembroRepository membroRepository;

	@Autowired
	public MembroService(MembroRepository membroRepository) {
		this.membroRepository = membroRepository;
	}

	public Membro save(Membro membro) {

		return membroRepository.save(membro);
	}

	public List<Membro> findById(String id) {
		return membroRepository.findByIdUser(id);
	}

	public Membro findByIdAndIdGuild(String id, String idGuild) {
		return membroRepository.findByIdUserAndIdGuild(id, idGuild).orElseGet(() -> {
			Membro membro = new Membro();
			membro.setIdUser(id);
			membro.setIdGuild(idGuild);
			return membro;
		});
	}

	public Membro loadMembro(Guild guild, Member user) {
		Membro membro = findByIdAndIdGuild(user.getId(), guild.getId());



		return membro;
	}

	public List<Membro> findAll() {
		return membroRepository.findAll();
	}

	public Page<Membro> findAll(Pageable pageable) {
		return membroRepository.findAll(pageable);
	}

}
