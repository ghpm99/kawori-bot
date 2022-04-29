package com.kawori.service;

import java.util.List;

import com.kawori.model.Operator;
import com.kawori.repository.OperatorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OperatorService {

	private OperatorRepository operatorRepository;

	@Autowired
	public OperatorService(OperatorRepository operatorRepository) {
		this.operatorRepository = operatorRepository;
	}

	public Operator findById(String id) {
		return operatorRepository.findById(id).orElseGet(() -> {
			Operator user = new Operator();
			user.setId(id);
			user.setWebAuthorized(false);
			user.setRole("USER");
			return user;
		});
	}

	public Operator save(Operator operator) {

		return operatorRepository.save(operator);
	}

	public List<Operator> findAll() {
		return operatorRepository.findAll();
	}

	public long count() {
		return operatorRepository.count();
	}

	public Page<Operator> findAll(Pageable pageable){
		return operatorRepository.findAll(pageable);
	}

}
