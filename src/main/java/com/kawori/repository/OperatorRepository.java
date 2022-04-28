package com.kawori.repository;

import java.util.Optional;

import com.kawori.model.Operator;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Interface OperatorRepository.
 */
public interface OperatorRepository extends JpaRepository<Operator, String> {

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Operator> findById(String id);

}
