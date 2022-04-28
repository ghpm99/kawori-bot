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

// TODO: Auto-generated Javadoc
/**
 * The Class MembroService.
 */
@Service
public class MembroService {

	/** The membro repository. */
	private MembroRepository membroRepository;

	/**
	 * Instantiates a new membro service.
	 *
	 * @param membroRepository the membro repository
	 */
	@Autowired
	public MembroService(MembroRepository membroRepository) {
		// TODO Auto-generated constructor stub
		this.membroRepository = membroRepository;
	}

	/**
	 * Save.
	 *
	 * @param membro the membro
	 * @return the membro
	 */
	public Membro save(Membro membro) {

		return membroRepository.save(membro);
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the list
	 */
	public List<Membro> findById(String id) {
		return membroRepository.findByIdUser(id);
	}

	/**
	 * Find by id and id guild.
	 *
	 * @param id the id
	 * @param idGuild the id guild
	 * @return the membro
	 */
	public Membro findByIdAndIdGuild(String id, String idGuild) {
		return membroRepository.findByIdUserAndIdGuild(id, idGuild).orElseGet(() -> {
			Membro membro = new Membro();
			membro.setIdUser(id);
			membro.setIdGuild(idGuild);
			return membro;
		});
	}

	/**
	 * Load membro.
	 *
	 * @param guild the guild
	 * @param user the user
	 * @return the membro
	 */
	public Membro loadMembro(Guild guild, Member user) {
		Membro membro = findByIdAndIdGuild(user.getId(), guild.getId());



		return membro;
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Membro> findAll() {
		return membroRepository.findAll();
	}

	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	public Page<Membro> findAll(Pageable pageable) {
		return membroRepository.findAll(pageable);
	}

}
