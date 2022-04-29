package com.kawori.repository;

import java.util.List;
import java.util.Optional;

import com.kawori.model.Guilda;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GuildaRepository extends JpaRepository<Guilda, String> {

	public Optional<Guilda> findById(String id);

	public List<Guilda> findByName(String name);

	public List<Guilda> findByIdOwner(String id);



}
