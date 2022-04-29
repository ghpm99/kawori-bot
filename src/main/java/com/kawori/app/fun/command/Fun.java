package com.kawori.app.fun.command;

import java.util.List;

import com.kawori.command.Command;
import com.kawori.command.CommandHandler;
import com.kawori.message.EmbedPattern;
import com.kawori.message.MessageController;
import com.kawori.security.Permissions;
import com.kawori.util.Util;

import org.springframework.stereotype.Controller;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

@Controller
public class Fun extends Command {

	public Fun() {
		CommandHandler.commands.put("hug", this);
		CommandHandler.commands.put("slap", this);
		CommandHandler.commands.put("nom", this);
		CommandHandler.commands.put("cuddle", this);
		CommandHandler.commands.put("kiss", this);
		CommandHandler.commands.put("bite", this);
		CommandHandler.commands.put("dance", this);
		CommandHandler.commands.put("awoo", this);
		CommandHandler.commands.put("owo", this);
		CommandHandler.commands.put("poke", this);
		CommandHandler.commands.put("lewd", this);
		CommandHandler.commands.put("blush", this);
		CommandHandler.commands.put("confused", this);
		CommandHandler.commands.put("cry", this);
		CommandHandler.commands.put("sad", this);
		CommandHandler.commands.put("pat", this);
		CommandHandler.commands.put("fox", this);
		CommandHandler.commands.put("punch", this);
		CommandHandler.commands.put("trap", this);
		CommandHandler.commands.put("explosion", this);
	}
	private MessageController messageController = new MessageController();

	private EmbedPattern embedPattern = new EmbedPattern();

	@Override
	public void action(String[] args, MessageReceivedEvent event) {

		String invoke = event.getMessage().getContentDisplay().split(" ")[0].replaceFirst(Util.PREFIX, "");

		String msgCouple, msgSolo, gifType;

		switch (invoke) {
			case "hug":
				msgCouple = "msg_fun_hug_couple";
				msgSolo = "msg_fun_hug_solo";
				gifType = "HUG";
				break;

			case "slap":
				msgCouple = "msg_fun_slap_couple";
				msgSolo = "msg_fun_slap_solo";
				gifType = "SLAP";
				break;

			case "nom":
				msgCouple = "msg_fun_nom_couple";
				msgSolo = "msg_fun_nom_solo";
				gifType = "NOM";
				break;

			case "cuddle":
				msgCouple = "msg_fun_cuddle_couple";
				msgSolo = "msg_fun_cuddle_solo";
				gifType = "CUDDLE";
				break;

			case "kiss":
				msgCouple = "msg_fun_kiss_couple";
				msgSolo = "msg_fun_kiss_solo";
				gifType = "KISS";
				break;

			case "bite":
				msgCouple = "msg_fun_bite_couple";
				msgSolo = "msg_fun_bite_solo";
				gifType = "BITE";
				break;

			case "dance":
				msgCouple = "msg_fun_dance_couple";
				msgSolo = "msg_fun_dance_solo";
				gifType = "DANCE";
				break;

			case "awoo":
				msgCouple = "msg_fun_awoo_couple";
				msgSolo = "msg_fun_awoo_solo";
				gifType = "AWOO";
				break;

			case "owo":
				msgCouple = "msg_fun_owo_couple";
				msgSolo = "msg_fun_owo_solo";
				gifType = "OWO";
				break;

			case "poke":
				msgCouple = "msg_fun_poke_couple";
				msgSolo = "msg_fun_poke_solo";
				gifType = "POKE";
				break;

			case "lewd":
				msgCouple = "msg_fun_lewd_couple";
				msgSolo = "msg_fun_lewd_solo";
				gifType = "LEWD";
				break;

			case "blush":
				msgCouple = "msg_fun_blush_couple";
				msgSolo = "msg_fun_blush_solo";
				gifType = "BLUSH";
				break;

			case "confused":
				msgCouple = "msg_fun_confused_couple";
				msgSolo = "msg_fun_confused_solo";
				gifType = "CONFUSED";
				break;

			case "cry":
				msgCouple = "msg_fun_cry_couple";
				msgSolo = "msg_fun_cry_solo";
				gifType = "CRY";
				break;

			case "sad":
				msgCouple = "msg_fun_sad_couple";
				msgSolo = "msg_fun_sad_solo";
				gifType = "SAD";
				break;

			case "pat":
				msgCouple = "msg_fun_pat_couple";
				msgSolo = "msg_fun_pat_solo";
				gifType = "PAT";
				break;

			case "fox":
				msgCouple = "msg_fun_fox_couple";
				msgSolo = "msg_fun_fox_solo";
				gifType = "FOX";
				break;

			case "punch":
				msgCouple = "msg_fun_punch_couple";
				msgSolo = "msg_fun_punch_solo";
				gifType = "PUNCH";
				break;

			case "trap":
				msgCouple = "msg_fun_trap_couple";
				msgSolo = "msg_fun_trap_solo";
				gifType = "TRAP";
				break;

			case "explosion":
				msgCouple = "msg_fun_explosion_couple";
				msgSolo = "msg_fun_explosion_solo";
				gifType = "EXPLOSION";
				break;

			default:
				msgCouple = "msg_fun_error";
				msgSolo = "msg_fun_error";
				gifType = "ERROR";
		}

		sendFunny(event.getGuild(), event.getTextChannel(), event.getAuthor(), findMentioned(args, event),
				msgCouple, msgSolo, gifType);

	}

	@Override
	public void executed(boolean success, MessageReceivedEvent event) {

	}

	@Override
	public String help() {
		return "msg_fun_help";
	}

	private User findMentioned(String[] args, MessageReceivedEvent event) {
		User user = event.getAuthor();
		if (event.getMessage().getMentionedMembers().size() > 0) {
			user = event.getMessage().getMentionedMembers().get(0).getUser();
		} else if (args.length > 0) {
			List<Member> members = event.getGuild().getMembersByNickname(args[0], true);
			if (members.size() > 0) {
				user = members.get(0).getUser();
			} else {
				List<Member> users = event.getGuild().getMembersByName(args[0], true);
				if (users.size() > 0) {
					user = users.get(0).getUser();
				}
			}
		}
		return user;
	}

	private void sendFunny(Guild guild, TextChannel channel, User user1, User user2, String msgCouple, String msgSolo,
			String typeGif) {
		String msg = msgCouple;
		String url = "https://cdn.discordapp.com/attachments/721361526090498138/721469146730070158/14.gif";

		if (user1.getIdLong() == user2.getIdLong()) {
			msg = msgSolo;
		}

		messageController.sendEmbed(channel, embedPattern.createEmbedFun(user1, channel, guild, url, msg,
				user1.getAsMention(), user2.getAsMention()), null);
	}

	@Override
	public String helpShort() {
		return "msg_fun_helpshort";
	}

	@Override
	public Permissions getPermissions() {
		return Permissions.CMD_FUN;
	}

}
