package com.kawori.repository;

import com.kawori.model.Log;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface LogRepository.
 */
public interface LogRepository extends JpaRepository<Log, String>{

}
