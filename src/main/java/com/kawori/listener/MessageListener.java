package com.kawori.listener;

import com.kawori.command.CommandHandler;
import com.kawori.model.MessageDiscord;
import com.kawori.service.MessageService;
import com.kawori.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MessageListener extends ListenerAdapter {

	@Autowired
	private MessageService messageService;

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {

		if (event.getAuthor().isBot()) {
			return;
		}

		if (event.getChannelType() == ChannelType.PRIVATE) {
			onPrivateMessage(event);
		} else if (event.getChannelType() == ChannelType.TEXT) {
			onGuildMessage(event);
		}

	}

	private void onPrivateMessage(MessageReceivedEvent event) {

		event.getAuthor().openPrivateChannel().complete()
				.sendMessage(event.getAuthor().getName() + "Nao aceito mensagens privadas!").queue();

	}

	private void onGuildMessage(MessageReceivedEvent event) {

		String message = event.getMessage().getContentDisplay();
		Guild guild = event.getGuild();
		User user = event.getAuthor();

		MessageDiscord messageDiscord = new MessageDiscord();
		messageDiscord.setIdDiscord(event.getMessageIdLong());
		messageDiscord.setIdUserDiscord(user.getIdLong());
		messageDiscord.setIdGuildDiscord(guild.getIdLong());
		messageDiscord.setCommand(false);
		messageDiscord.generatedUUID();
		messageDiscord.setStatus(0);

		messageService.save(messageDiscord);

		if (message.startsWith(Util.PREFIX)
				& !event.getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) {

			CommandHandler.handleCommand(CommandHandler.parser.parse(message, event));

		} else if (message.startsWith(Util.PREFIXAUTOROLE)
				& !event.getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) {

		}
	}

}
