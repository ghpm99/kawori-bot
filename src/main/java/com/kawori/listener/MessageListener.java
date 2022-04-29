package com.kawori.listener;

import com.kawori.command.CommandHandler;
import com.kawori.util.Util;

import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Component
public class MessageListener extends ListenerAdapter {


	@Override
	public void onMessageReceived(MessageReceivedEvent evento) {

		if (evento.getAuthor().isBot()) {
			return;
		}

		if (evento.getChannelType() == ChannelType.PRIVATE) {
			onPrivateMessage(evento);
		} else if (evento.getChannelType() == ChannelType.TEXT) {
			onGuildMessage(evento);
		}

	}

	private void onPrivateMessage(MessageReceivedEvent evento) {

		evento.getAuthor().openPrivateChannel().complete()
				.sendMessage(evento.getAuthor().getName() + "Nao aceito mensagens privadas!").queue();

	}

	private void onGuildMessage(MessageReceivedEvent evento) {

		String message = evento.getMessage().getContentDisplay();

		if (message.startsWith(Util.PREFIX)
				& !evento.getAuthor().getId().equals(evento.getJDA().getSelfUser().getId())) {

			CommandHandler.handleCommand(CommandHandler.parser.parse(message, evento));

		}else if(message.startsWith(Util.PREFIXAUTOROLE) & !evento.getAuthor().getId().equals(evento.getJDA().getSelfUser().getId())) {


		}
	}

}
