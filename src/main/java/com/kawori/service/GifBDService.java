package com.kawori.service;

import java.util.List;
import java.util.Random;

import com.kawori.model.GifBD;
import com.kawori.repository.GifBDRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class GifBDService {

	@Autowired
	private GifBDRepository gifBDRespository;

	public List<GifBD> findByType(String type) {
		return gifBDRespository.findByType(type);
	}

	public GifBD findRandomByType(String type) {
		List<GifBD> gifs = findByType(type);
		Random random = new Random();

		return gifs.get(random.nextInt(gifs.size()));
	}

	public GifBD save(GifBD gifBD) {

		return gifBDRespository.save(gifBD);
	}

	public List<GifBD> findAll(){
		return gifBDRespository.findAll();
	}

	public Page<GifBD> findAll(Pageable pageable){
		return gifBDRespository.findAll(pageable);
	}
}
