package com.kawori.repository;

import java.util.Optional;

import com.kawori.model.Configuration;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ConfigurationRepository extends JpaRepository<Configuration, String> {

	public Optional<Configuration> getByType(String type);

}
