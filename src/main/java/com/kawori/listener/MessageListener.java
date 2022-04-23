package com.kawori.listener;

import com.kawori.command.CommandHandler;
import com.kawori.util.Util;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving message events.
 * The class that is interested in processing a message
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addMessageListener<code> method. When
 * the message event occurs, that object's appropriate
 * method is invoked.
 *
 * @see MessageEvent
 */

public class MessageListener extends ListenerAdapter {

	/**
	 * On message received.
	 *
	 * @param evento the evento
	 */
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

	/**
	 * On private message.
	 *
	 * @param evento the evento
	 */
	private void onPrivateMessage(MessageReceivedEvent evento) {

		evento.getAuthor().openPrivateChannel().complete()
				.sendMessage(evento.getAuthor().getName() + "Nao aceito mensagens privadas!").queue();

	}

	/**
	 * On guild message.
	 *
	 * @param evento the evento
	 */
	private void onGuildMessage(MessageReceivedEvent evento) {

		String message = evento.getMessage().getContentDisplay();

		if (message.startsWith(Util.PREFIX)
				& !evento.getAuthor().getId().equals(evento.getJDA().getSelfUser().getId())) {

			CommandHandler.handleCommand(CommandHandler.parser.parse(message, evento));

		}else if(message.startsWith(Util.PREFIXAUTOROLE) & !evento.getAuthor().getId().equals(evento.getJDA().getSelfUser().getId())) {


		}
	}

}
