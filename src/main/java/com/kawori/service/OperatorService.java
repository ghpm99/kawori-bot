package com.kawori.service;

import java.util.List;

import com.kawori.model.UserDiscord;
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

	public UserDiscord findById(long id) {
		return operatorRepository.findById(id).orElseGet(() -> {
			UserDiscord user = new UserDiscord();
			user.setId(id);
			user.setWebAuthorized(false);
			user.setRole("USER");
			return user;
		});
	}

	public UserDiscord save(UserDiscord operator) {

		return operatorRepository.save(operator);
	}

	public List<UserDiscord> findAll() {
		return operatorRepository.findAll();
	}

	public long count() {
		return operatorRepository.count();
	}

	public Page<UserDiscord> findAll(Pageable pageable){
		return operatorRepository.findAll(pageable);
	}

}
