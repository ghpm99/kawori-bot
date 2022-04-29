package com.kawori.service;

import java.util.List;

import com.kawori.model.Log;
import com.kawori.repository.LogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class LogService {

	@Autowired
	private LogRepository logRepository;

	public void addEvent(Log log) {
		Log logSaved = logRepository.save(log);
		System.out.println(logSaved.toString());
	}

	public List<Log> getEvents() {
		return logRepository.findAll();
	}

	public Page<Log> findAll(Pageable pageable){
		return logRepository.findAll(pageable);
	}

}
