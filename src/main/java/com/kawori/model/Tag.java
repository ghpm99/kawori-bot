package com.kawori.model;

import java.awt.Color;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class Tag.
 */
@Data
@Entity
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String idGuild;

	/** The id role. */
	private String idRole;

	/** The name. */
	private String name;

	/** The red. */
	private int red;

	/** The green. */
	private int green;

	/** The blue. */
	private int blue;

	/** The position. */
	private int position;

	/** The administrator. */
	private boolean administrator;

	/** The manage channels. */
	private boolean manageChannels;

	/** The manage permissions. */
	private boolean managePermissions;

	/** The manage roles. */
	private boolean manageRoles;

	/** The manage server. */
	private boolean manageServer;

	/** The message manage. */
	private boolean messageManage;

	/** The message mention everyone. */
	private boolean messageMentionEveryone;

	/** The message read. */
	private boolean messageRead;

	/** The message write. */
	private boolean messageWrite;

	/** The nickname change. */
	private boolean nicknameChange;

	/** The nickname manage. */
	private boolean nicknameManage;

	/** The bot role. */
	private boolean botRole;

	/** The active. */
	private boolean active;

	/** The cmd fun. */
	private boolean cmdFun;

	/** The cmd util. */
	private boolean cmdUtil;

	/** The cmd build. */
	private boolean cmdBuild;

	/** The cmd node war. */
	private boolean cmdNodeWar;

	/** The cmd adm. */
	private boolean cmdAdm;

	/** The cmd rank. */
	private boolean cmdRank;

}
