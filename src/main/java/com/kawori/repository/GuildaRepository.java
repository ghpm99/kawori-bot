package com.kawori.repository;

import java.util.List;
import java.util.Optional;

import com.kawori.model.Guilda;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Interface GuildaRepository.
 */
public interface GuildaRepository extends JpaRepository<Guilda, String> {

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Guilda> findById(String id);

	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the list
	 */
	public List<Guilda> findByName(String name);

	/**
	 * Find by id owner.
	 *
	 * @param id the id
	 * @return the list
	 */
	public List<Guilda> findByIdOwner(String id);



}
