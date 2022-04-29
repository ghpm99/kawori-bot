package com.kawori.repository;

import java.util.List;

import com.kawori.model.AutoRole;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AutoRoleRepository extends JpaRepository<AutoRole, String> {

	public List<AutoRole> getByGuildAndChannelAndCanceled(String guild, String channel, boolean canceled);

	public Page<AutoRole> getByGuildAndCanceled(String guild, boolean canceled, Pageable pageable);
}
