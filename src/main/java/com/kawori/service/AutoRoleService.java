package com.kawori.service;

import java.util.List;

import com.kawori.model.AutoRole;
import com.kawori.repository.AutoRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AutoRoleService {

	@Autowired
	private AutoRoleRepository autoRoleRepository;

	public List<AutoRole> getAutoRole(String idGuild, String idChannel) {
		return autoRoleRepository.getByGuildAndChannelAndCanceled(idGuild, idChannel, false);
	}

	public Page<AutoRole> getAutoRole(String idGuild, Pageable pageable) {
		return autoRoleRepository.getByGuildAndCanceled(idGuild, false, pageable);
	}

	public AutoRole createAutoRole(String idGuild, String idChannel, String idRole, String text) {
		AutoRole newAutoRole = new AutoRole(
				idGuild,
				idChannel,
				idRole,
				text,
				false
		);
		return autoRoleRepository.save(newAutoRole);
	}

	public AutoRole cancelAutoRole(AutoRole autorole) {
		autorole.setCanceled(true);
		return autoRoleRepository.save(autorole);
	}

	public List<AutoRole> findAll(){
		return autoRoleRepository.findAll();
	}

	public Page<AutoRole> findAll(Pageable pageable){
		return autoRoleRepository.findAll(pageable);
	}

}
