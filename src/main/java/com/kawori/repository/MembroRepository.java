package com.kawori.repository;

import java.util.List;
import java.util.Optional;

import com.kawori.model.Membro;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MembroRepository extends JpaRepository<Membro, String>{

	public List<Membro> findByIdUser(String id);

	public Optional<Membro> findByIdUserAndIdGuild(String idUser, String idGuild);

}
