package com.kawori.repository;

import java.util.List;

import com.kawori.model.GifBD;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GifBDRepository extends JpaRepository<GifBD, String> {

	public List<GifBD> findByType(String type);

}
