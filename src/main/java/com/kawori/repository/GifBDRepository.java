package com.kawori.repository;

import java.util.List;

import com.kawori.model.GifBD;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Interface GifBDRepository.
 */
public interface GifBDRepository extends JpaRepository<GifBD, String> {

	/**
	 * Find by type.
	 *
	 * @param type the type
	 * @return the list
	 */
	public List<GifBD> findByType(String type);

}
