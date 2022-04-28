package com.kawori.service;

import java.util.List;

import com.kawori.model.Guilda;
import com.kawori.repository.GuildaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class GuildaService.
 */
@Service
public class GuildaService {

	/** The guilda repository. */
	private GuildaRepository guildaRepository;

	/**
	 * Instantiates a new guilda service.
	 *
	 * @param guildaRepository the guilda repository
	 */
	@Autowired
	public GuildaService(GuildaRepository guildaRepository) {
		// TODO Auto-generated constructor stub
		this.guildaRepository = guildaRepository;
	}

	/**
	 * Save.
	 *
	 * @param guild the guild
	 * @return the guilda
	 */
	public Guilda save(Guilda guild) {

		return guildaRepository.save(guild);
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the guilda
	 */
	public Guilda findById(String id) {
		return guildaRepository.findById(id).orElseGet(() -> {
			Guilda guild = new Guilda();
			guild.setId(id);
			return guild;
		});
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Guilda> findAll() {
		return guildaRepository.findAll();
	}

	/**
	 * Count.
	 *
	 * @return the long
	 */
	public long count() {
		return guildaRepository.count();
	}

	/**
	 * Find all.
	 *
	 * @param pageable the pageable
	 * @return the page
	 */
	public Page<Guilda> findAll(Pageable pageable){
		return guildaRepository.findAll(pageable);
	}

}
