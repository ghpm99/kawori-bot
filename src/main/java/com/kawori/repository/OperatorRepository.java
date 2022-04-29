package com.kawori.repository;

import java.util.Optional;

import com.kawori.model.Operator;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OperatorRepository extends JpaRepository<Operator, String> {

	public Optional<Operator> findById(String id);

}
