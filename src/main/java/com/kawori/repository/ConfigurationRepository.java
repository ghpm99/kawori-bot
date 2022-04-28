package com.kawori.repository;

import java.util.Optional;

import com.kawori.model.Configuration;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Interface ConfigurationRepository.
 */
public interface ConfigurationRepository extends JpaRepository<Configuration, String> {

	/**
	 * Gets the by type.
	 *
	 * @param type the type
	 * @return the by type
	 */
	public Optional<Configuration> getByType(String type);

}
