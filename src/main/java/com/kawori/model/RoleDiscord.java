package com.kawori.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class RoleDiscord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long idGuild;
	private long idRole;
	private String name;
	private int red;
	private int green;
	private int blue;
	private int position;
	private boolean administrator;
	private boolean manageChannels;
	private boolean managePermissions;
	private boolean manageRoles;
	private boolean manageServer;
	private boolean messageManage;
	private boolean messageMentionEveryone;
	private boolean messageRead;
	private boolean messageWrite;
	private boolean nicknameChange;
	private boolean nicknameManage;
	private boolean botRole;
	private boolean active;
	private boolean cmdFun;
	private boolean cmdUtil;
	private boolean cmdBuild;
	private boolean cmdNodeWar;
	private boolean cmdAdm;
	private boolean cmdRank;

}
