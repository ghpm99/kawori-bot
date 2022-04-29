package com.kawori.listener;


import com.kawori.reaction.ReactionHandler;

import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class ReactionListener extends ListenerAdapter {

	@Override
	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
		if (ReactionHandler.reactions.containsKey(event.getMessageId())) {
			ReactionHandler.reactions.get(event.getMessageId()).onGuildMessageReaction(
					event.getReactionEmote().getName(), event.getUserId(), event.getGuild().getId(), true);
		}

	}

	@Override
	public void onGuildMessageReactionRemove(GuildMessageReactionRemoveEvent event) {
		super.onGuildMessageReactionRemove(event);
		if (ReactionHandler.reactions.containsKey(event.getMessageId())) {
			ReactionHandler.reactions.get(event.getMessageId()).onGuildMessageReaction(
					event.getReactionEmote().getName(), event.getUserId(), event.getGuild().getId(), false);
		}
	}

	@Override
	public void onPrivateMessageReactionAdd(PrivateMessageReactionAddEvent event) {
		super.onPrivateMessageReactionAdd(event);
		if(ReactionHandler.reactionsPrivate.containsKey(event.getMessageId())) {
			ReactionHandler.reactionsPrivate.get(event.getMessageId()).onPrivateMessageReaction(event.getReactionEmote().getName(), event.getUserId(), true);
		}
	}

	@Override
	public void onPrivateMessageReactionRemove(PrivateMessageReactionRemoveEvent event) {
		super.onPrivateMessageReactionRemove(event);
		if(ReactionHandler.reactionsPrivate.containsKey(event.getMessageId())) {
			ReactionHandler.reactionsPrivate.get(event.getMessageId()).onPrivateMessageReaction(event.getReactionEmote().getName(), event.getUserId(), false);
		}
	}
}
