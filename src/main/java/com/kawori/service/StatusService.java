package com.kawori.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatusService {

	@Autowired
	private GuildService guildaService;

	@Autowired
	private UserService operatorService;

    private String statusBot = "-";

    private final ZonedDateTime timeOn = ZonedDateTime.now();

    private long cmdReceived = 0;

    public String getStatusBot() {
        return statusBot;
    }

    public void setStatusBot(String statusBot) {
        this.statusBot = statusBot;
    }

    public ZonedDateTime getTimeOn() {
        return timeOn;
    }

    public long getCmdReceived() {
        return cmdReceived;
    }

    public void increaseCmdReceived() {
        this.cmdReceived++;
    }

    public long getGuildCount() {
    	return guildaService.count();
    }

    public long getUserCount() {
    	return operatorService.count();
    }

}
