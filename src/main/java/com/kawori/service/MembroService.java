package com.kawori.service;

import java.util.List;

import com.kawori.model.MemberDiscord;
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

	public MemberDiscord save(MemberDiscord membro) {

		return membroRepository.save(membro);
	}

	public List<MemberDiscord> findById(long idUser) {
		return membroRepository.findByIdUserDiscord(idUser);
	}

	public MemberDiscord findByIdUserAndIdGuild(long idUser, long idGuild) {
		return membroRepository.findByIdUserDiscordAndIdGuildDiscord(idUser, idGuild).orElseGet(() -> {
			MemberDiscord membro = new MemberDiscord();
			membro.setIdUserDiscord(idUser);
			membro.setIdGuildDiscord(idGuild);
			return membro;
		});
	}

	public MemberDiscord loadMembro(Guild guild, Member user) {

		MemberDiscord membro = findByIdUserAndIdGuild(user.getIdLong(), guild.getIdLong());
		return membro;
	}

	public List<MemberDiscord> findAll() {
		return membroRepository.findAll();
	}

	public Page<MemberDiscord> findAll(Pageable pageable) {
		return membroRepository.findAll(pageable);
	}

}
