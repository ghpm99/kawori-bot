package com.kawori.repository;

import java.util.List;
import java.util.Optional;

import com.kawori.model.Tag;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Interface TagRepository.
 */
public interface TagRepository extends JpaRepository<Tag, String> {

	/**
	 * Find by id guild and bot role.
	 *
	 * @param idGuild the id guild
	 * @param isBotRole the is bot role
	 * @return the list
	 */
	public List<Tag> findByIdGuildAndBotRole(String idGuild, boolean isBotRole);

	/**
	 * Find by id guild.
	 *
	 * @param idGuild the id guild
	 * @return the list
	 */
	public List<Tag> findByIdGuild(String idGuild);

	/**
	 * Find by id guild and name.
	 *
	 * @param idGuild the id guild
	 * @param name the name
	 * @return the list
	 */
	public List<Tag> findByIdGuildAndName(String idGuild, String name);

	/**
	 * Find by id role.
	 *
	 * @param idRole the id role
	 * @return the optional
	 */
	public Optional<Tag> findByIdRole(String idRole);

	/**
	 * Find by id guild and id role.
	 *
	 * @param idGuild the id guild
	 * @param idRole the id role
	 * @return the optional
	 */
	public Optional<Tag> findByIdGuildAndIdRole(String idGuild, String idRole);

}
