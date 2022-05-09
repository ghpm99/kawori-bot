package com.kawori.service;

import java.util.List;

import com.kawori.model.UserDiscord;
import com.kawori.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDiscord findById(long id) {
		return userRepository.findByIdDiscord(id).orElseGet(() -> {
			UserDiscord user = new UserDiscord();
			user.setIdDiscord(id);
			user.setWebAuthorized(false);
			user.setRole("USER");
			return user;
		});
	}

	public UserDiscord save(UserDiscord operator) {
		return userRepository.save(operator);
	}

	public List<UserDiscord> findAll() {
		return userRepository.findAll();
	}

	public long count() {
		return userRepository.count();
	}

	public Page<UserDiscord> findAll(Pageable pageable){
		return userRepository.findAll(pageable);
	}

	public UserDiscord findByIdDiscord(long discordId) {
		return userRepository.findByIdDiscord(discordId).orElseGet(() -> {
			UserDiscord user = new UserDiscord();
			user.setId(discordId);
			user.setWebAuthorized(false);
			user.setRole("USER");
			return user;
		});
	}

	public void registerUser(long idDiscord, String name, String discriminator) {
		UserDiscord user = findByIdDiscord(idDiscord);
		user.setName(name);
		user.setDiscriminator(discriminator);
		user.updateLastMessage();
		save(user);
	}

}
