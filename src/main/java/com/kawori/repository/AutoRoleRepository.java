package com.kawori.repository;

import java.util.List;

import com.kawori.model.AutoRole;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO: Auto-generated Javadoc
/**
 * The Interface AutoRoleRepository.
 */
public interface AutoRoleRepository extends JpaRepository<AutoRole, String> {

	/**
	 * Gets the by guild and channel and canceled.
	 *
	 * @param guild the guild
	 * @param channel the channel
	 * @param canceled the canceled
	 * @return the by guild and channel and canceled
	 */
	public List<AutoRole> getByGuildAndChannelAndCanceled(String guild, String channel, boolean canceled);

	/**
	 * Gets the by guild and canceled.
	 *
	 * @param guild the guild
	 * @param canceled the canceled
	 * @param pageable the pageable
	 * @return the by guild and canceled
	 */
	public Page<AutoRole> getByGuildAndCanceled(String guild, boolean canceled, Pageable pageable);

}
