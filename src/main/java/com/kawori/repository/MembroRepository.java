package com.kawori.repository;

import java.util.List;
import java.util.Optional;

import com.kawori.model.Membro;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Interface MembroRepository.
 */
public interface MembroRepository extends JpaRepository<Membro, String>{

	/**
	 * Find by id user.
	 *
	 * @param id the id
	 * @return the list
	 */
	public List<Membro> findByIdUser(String id);

	/**
	 * Find by id user and id guild.
	 *
	 * @param idUser the id user
	 * @param idGuild the id guild
	 * @return the optional
	 */
	public Optional<Membro> findByIdUserAndIdGuild(String idUser, String idGuild);


}
