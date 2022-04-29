package com.kawori.reaction;

public interface Reaction {

	public void onGuildMessageReaction(String emote, String idUser, String idGuild, boolean isAdd);

}