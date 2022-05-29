package com.kawori.listener;

import com.kawori.command.CommandHandler;
import com.kawori.model.MessageDiscord;
import com.kawori.model.MessageDiscord.Status;
import com.kawori.service.ExperienceService;
import com.kawori.service.GuildService;
import com.kawori.service.MessageService;
import com.kawori.service.UserService;
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

	@Autowired
	private UserService userService;

	@Autowired
	private GuildService guildService;

	@Autowired
	private ExperienceService experienceService;

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {

		if (event.getAuthor().isBot()) {
			return;
		}

		//Salva o registro do usuario no banco de dados
		userService.registerUser(event.getAuthor().getIdLong(), event.getAuthor().getName(), event.getAuthor().getDiscriminator());

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

		//Salva o registro de uma nova mensagem no banco de dados
		MessageDiscord messageDiscord = messageService.createNewMessage(event.getMessageIdLong(), user.getIdLong(),
				guild.getIdLong());

		//Salva guild no banco de dados
		guildService.registerGuild(guild.getIdLong(), guild.getName(), guild.getOwnerIdLong());

		if (message.startsWith(Util.PREFIX)
				& !event.getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) {

			try {
				messageDiscord.setCommand(message.substring(0));
				messageDiscord.setStatus(Status.PENDING);

				CommandHandler.handleCommand(CommandHandler.parser.parse(message, event));

			} catch (Exception e) {
				messageDiscord.setStatus(Status.ERROR);
			}

		} else if (message.startsWith(Util.PREFIXAUTOROLE)
				& !event.getAuthor().getId().equals(event.getJDA().getSelfUser().getId())) {

		}

		messageService.finishMessage(messageDiscord);

		experienceService.generatedExperience(messageDiscord);

	}

}
