package com.kawori.message;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import com.kawori.command.Command;
import com.kawori.model.AutoRole;
import com.kawori.util.Emojis;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

// TODO: Auto-generated Javadoc
/**
 * The Class EmbedPattern.
 */
public class EmbedPattern {

	/** The message controller. */
	private MessageController messageController = new MessageController();

	/**
	 * Creates the select tier embed.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @return the embed builder
	 */
	public EmbedBuilder createSelectTierEmbed(User user, MessageChannel channel, Guild guild) {

		EmbedBuilder embed = new EmbedBuilder();

		messageController.setEmbedHead(guild, channel, user, embed);
		messageController.setEmbedTitle(guild, channel, user, embed, "msg_nw_title_01");
		messageController.setEmbedDescription(guild, channel, user, embed, "msg_nw_description_01");

		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_01_01"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_01_02"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_01_03"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_01_04"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_01_05"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_01_cancel"));

		return embed;
	}

	/**
	 * Creates the select tier embed additional.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @return the embed builder
	 */
	public EmbedBuilder createSelectTierEmbedAdditional(User user, MessageChannel channel, Guild guild) {

		EmbedBuilder embed = new EmbedBuilder();

		messageController.setEmbedHead(guild, channel, user, embed);
		messageController.setEmbedTitle(guild, channel, user, embed, "msg_nw_title_01");
		messageController.setEmbedDescription(guild, channel, user, embed, "msg_nw_description_01_add");

		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_01_add_01"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_01_add_02"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_01_add_03"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_01_cancel"));

		return embed;
	}

	/**
	 * Creates the select day of week embed.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @return the embed builder
	 */
	public EmbedBuilder createSelectDayOfWeekEmbed(User user, MessageChannel channel, Guild guild) {

		EmbedBuilder embed = new EmbedBuilder();

		messageController.setEmbedHead(guild, channel, user, embed);
		messageController.setEmbedTitle(guild, channel, user, embed, "msg_nw_title_01");
		messageController.setEmbedDescription(guild, channel, user, embed, "msg_nw_description_02");

		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_02_01"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_02_02"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_02_03"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_02_04"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_02_05"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_02_06"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_01_cancel"));

		return embed;
	}


	/**
	 * Creates the select day of month embed.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param days the days
	 * @return the embed builder
	 */
	public EmbedBuilder createSelectDayOfMonthEmbed(User user, MessageChannel channel, Guild guild,
			ArrayList<Date> days) {
		EmbedBuilder embed = new EmbedBuilder();

		messageController.setEmbedHead(guild, channel, user, embed);
		messageController.setEmbedTitle(guild, channel, user, embed, "msg_nw_title_01");
		messageController.setEmbedDescription(guild, channel, user, embed, "msg_nw_description_04");

		for (Date day : days) {
			embed.addField("Day", String.valueOf(getDayOfMonth(day)), false);

		}

		embed.addField(messageController.createEmbedField(guild, channel, user, "", "msg_nw_field_01_cancel"));

		return embed;
	}

	/**
	 * Gets the day of month.
	 *
	 * @param date the date
	 * @return the day of month
	 */
	private int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Creates the embed image.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param url the url
	 * @param description the description
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedImage(User user, MessageChannel channel, Guild guild, String url,
			String description) {
		EmbedBuilder embed = new EmbedBuilder();
		messageController.setEmbedDescription(guild, channel, user, embed, description);
		embed.setImage(url);

		return embed;
	}

	/**
	 * Creates the embed fun.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param url the url
	 * @param description the description
	 * @param args the args
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedFun(User user, MessageChannel channel, Guild guild, String url, String description,
			String... args) {
		EmbedBuilder embed = new EmbedBuilder();
		messageController.setEmbedDescription(guild, channel, user, embed, description, args);
		embed.setImage(url);

		return embed;
	}

	/**
	 * Creates the embed info user.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param familyName the family name
	 * @param activePersonagem the active personagem
	 * @param activeGear the active gear
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedInfoUser(User user, MessageChannel channel, Guild guild, String familyName,
			String activePersonagem, String activeGear) {
		EmbedBuilder embed = new EmbedBuilder();
		Member member = guild.retrieveMember(user).complete();
		//String nick = guild.getMember(user).getNickname();
		String nick = member.getNickname();
		if (nick == null) {
			nick = "null";
		}

		messageController.setEmbedHead(guild, channel, user, embed);
		messageController.setEmbedTitle(guild, channel, user, embed, "embed_info_title");
		messageController.setEmbedDescription(guild, channel, user, embed, "embed_info_description");

		String joined = member.getTimeJoined().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		embed.addField(messageController.createEmbedField(guild, channel, user, "Info", "embed_info_field_1",
				user.getId(), nick, user.getName()));
		embed.addField(messageController.createEmbedField(guild, channel, user, "Joined on", "embed_info_field_2", true,
				joined));
		embed.addField(messageController.createEmbedField(guild, channel, user, "Family", "embed_info_field_2", true,
				familyName));
		embed.addField(messageController.createEmbedField(guild, channel, user, "Active Personagem",
				"embed_info_field_2", activePersonagem));
		embed.addField(messageController.createEmbedField(guild, channel, user, "Active Gear", "embed_info_field_2",
				activeGear));

		return embed;
	}

	/**
	 * Creates the embed check is new personagem.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedCheckIsNewPersonagem(User user, MessageChannel channel, Guild guild) {
		EmbedBuilder embed = new EmbedBuilder();
		messageController.setEmbedHead(guild, channel, user, embed);
		messageController.setEmbedTitle(guild, channel, user, embed, "embed_gs_new_title");
		messageController.setEmbedDescription(guild, channel, user, embed, "embed_gs_new_description");

		embed.addField(messageController.createEmbedField(guild, channel, user, "", "embed_gs_new_field_1", "☑️"));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "embed_gs_new_field_2", "🆕"));

		return embed;

	}

	/**
	 * Creates the embed canceled.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedCanceled(User user, MessageChannel channel, Guild guild) {
		EmbedBuilder embed = new EmbedBuilder();
		messageController.setEmbedHead(guild, channel, user, embed);
		messageController.setEmbedTitle(guild, channel, user, embed, "embed_canceled_title");

		return embed;
	}

	/**
	 * Creates the embed sucess gear.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedSucessGear(User user, MessageChannel channel, Guild guild) {
		EmbedBuilder embed = new EmbedBuilder();
		messageController.setEmbedHead(guild, channel, user, embed);
		messageController.setEmbedTitle(guild, channel, user, embed, "embed_sucess_gear_title");

		return embed;
	}

	/**
	 * Creates the embed configure channels.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param channels the channels
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedConfigureChannels(User user, MessageChannel channel, Guild guild,
			List<TextChannel> channels) {
		EmbedBuilder embed = new EmbedBuilder();
		messageController.setEmbedHead(guild, channel, user, embed);
		messageController.setEmbedTitle(guild, channel, user, embed, "embed_configure_channels_title");
		String description = "";
		for (TextChannel textChannel : channels) {
			description = description.concat("<#" + textChannel.getId() + "> ");
		}
		messageController.setEmbedDescription(guild, channel, user, embed, "embed_configure_channels_description",
				description);

		embed.addField(messageController.createEmbedField(guild, channel, user, "", "embed_configure_channels_field_1",
				Emojis.CHECK_OK.getEmoji()));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "embed_configure_channels_field_2",
				Emojis.CANCEL.getEmoji()));

		return embed;
	}

	/**
	 * Creates the embed configure channels sucess.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param channels the channels
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedConfigureChannelsSucess(User user, MessageChannel channel, Guild guild,
			List<TextChannel> channels) {
		EmbedBuilder embed = new EmbedBuilder();
		messageController.setEmbedHead(guild, channel, user, embed);
		messageController.setEmbedTitle(guild, channel, user, embed, "embed_configure_channels_sucess_title");
		String description = "";
		for (TextChannel textChannel : channels) {
			description = description.concat("<#" + textChannel.getId() + "> ");
		}
		messageController.setEmbedDescription(guild, channel, user, embed,
				"embed_configure_channels_sucess_description", description);
		return embed;
	}

	/**
	 * Creates the embed configure roles.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param roles the roles
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedConfigureRoles(User user, MessageChannel channel, Guild guild, List<Role> roles) {
		EmbedBuilder embed = new EmbedBuilder();
		messageController.setEmbedHead(guild, channel, user, embed);
		messageController.setEmbedTitle(guild, channel, user, embed, "embed_configure_roles_title");
		String description = "";
		for (Role role : roles) {
			description = description.concat(role.getAsMention() + " ");
		}
		messageController.setEmbedDescription(guild, channel, user, embed, "embed_configure_roles_description",
				description);
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "embed_configure_roles_field_1",
				Emojis.ONE.getEmoji()));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "embed_configure_roles_field_2",
				Emojis.TWO.getEmoji()));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "embed_configure_roles_field_3",
				Emojis.THREE.getEmoji()));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "embed_configure_roles_field_4",
				Emojis.FOUR.getEmoji()));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "embed_configure_roles_field_5",
				Emojis.FIVE.getEmoji()));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "embed_configure_roles_field_6",
				Emojis.SIX.getEmoji()));
		embed.addField(messageController.createEmbedField(guild, channel, user, "", "embed_configure_roles_field_7",
				Emojis.CHECK_OK.getEmoji()));
		return embed;
	}

	/**
	 * Creates the embed configure roles sucess.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param roles the roles
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedConfigureRolesSucess(User user, MessageChannel channel, Guild guild,
			List<Role> roles) {
		EmbedBuilder embed = new EmbedBuilder();
		messageController.setEmbedHead(guild, channel, user, embed);
		messageController.setEmbedTitle(guild, channel, user, embed, "embed_configure_roles_sucess_title");
		String description = "";
		for (Role role : roles) {
			description = description.concat(role.getAsMention() + " ");
		}
		messageController.setEmbedDescription(guild, channel, user, embed, "embed_configure_roles_sucess_description",
				description);
		return embed;
	}

	/**
	 * Creates the embed help all.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param commands the commands
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedHelpAll(User user, MessageChannel channel, Guild guild,
			HashMap<String, Command> commands) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.setAuthor("Kaori Bot", "https://discord.gg/xtFBD6M", channel.getJDA().getSelfUser().getAvatarUrl());
		messageController.setEmbedTitle(guild, channel, user, embed, "embed_help_title");
		ArrayList<String> cmdFun = new ArrayList<String>();
		ArrayList<String> cmdUtil = new ArrayList<String>();
		ArrayList<String> cmdBuild = new ArrayList<String>();
		ArrayList<String> cmdRank = new ArrayList<String>();
		ArrayList<String> cmdNw = new ArrayList<String>();
		ArrayList<String> cmdAdm = new ArrayList<String>();

		commands.forEach((key, command) -> {
			switch (command.getPermissions()) {
			case CMD_FUN:
				cmdFun.add(key);
				break;
			case CMD_UTIL:
				cmdUtil.add(
						key + "(" + messageController.createMessage(guild, channel, user, command.helpShort()) + ")");
				break;
			case CMD_BUILD:
				cmdBuild.add(
						key + "(" + messageController.createMessage(guild, channel, user, command.helpShort()) + ")");
				break;
			case CMD_RANK:
				cmdRank.add(
						key + "(" + messageController.createMessage(guild, channel, user, command.helpShort()) + ")");
				break;
			case CMD_NW:
				cmdNw.add(key + "(" + messageController.createMessage(guild, channel, user, command.helpShort()) + ")");
				break;
			case CMD_ADM:
				cmdAdm.add(
						key + "(" + messageController.createMessage(guild, channel, user, command.helpShort()) + ")");
				break;
			}
		});

		embed.addField("ADM", cmdAdm.toString(), false);
		embed.addField("NODEWAR", cmdNw.toString(), false);
		embed.addField("RANK", cmdRank.toString(), false);
		embed.addField("BUILD", cmdBuild.toString(), false);
		embed.addField("FUN", cmdFun.toString(), false);
		embed.addField("UTIL", cmdUtil.toString(), false);

		return embed;
	}

	/**
	 * Creates the embed help.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param command the command
	 * @param commandKey the command key
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedHelp(User user, MessageChannel channel, Guild guild, Command command,
			String commandKey) {
		EmbedBuilder embed = new EmbedBuilder();
		embed.setAuthor("Kaori Bot", "https://discord.gg/xtFBD6M", channel.getJDA().getSelfUser().getAvatarUrl());
		embed.setTitle(commandKey.toUpperCase());
		messageController.setEmbedDescription(guild, channel, user, embed, command.help());

		return embed;
	}

	/**
	 * Creates the embed auto role apply.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param roles the roles
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedAutoRoleApply(User user, MessageChannel channel, Guild guild, List<Role> roles) {
		EmbedBuilder embed = new EmbedBuilder();

		String rolesName = "";
		for (Role role : roles) {
			rolesName = rolesName + " " + role.getName();
		}
		messageController.setEmbedTitle(guild, channel, user, embed, "embed_auto_role_title");
		messageController.setEmbedDescription(guild, channel, user, embed, "embed_auto_role_description", rolesName);

		return embed;
	}

	/**
	 * Creates the embed cancel auto role.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param autoRoles the auto roles
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedCancelAutoRole(User user, MessageChannel channel, Guild guild,
			List<AutoRole> autoRoles) {
		EmbedBuilder embed = new EmbedBuilder();

		messageController.setEmbedTitle(guild, channel, user, embed, "embed_auto_role_cancel_title");
		messageController.setEmbedDescription(guild, channel, user, embed, "embed_auto_role_cancel_description");

		for (AutoRole autoRole : autoRoles) {
			TextChannel textChannel = guild.getTextChannelById(autoRole.getChannel());
			Role role = guild.getRoleById(autoRole.getRole());
			embed.addField(messageController.createEmbedField(guild, channel, user, autoRole.getText(),
					"embed_auto_role_cancel_fiel", textChannel == null ? "null" : textChannel.getAsMention(),
					role == null ? "null" : role.getName()));
		}

		return embed;
	}

	/**
	 * Creates the embed canceled auto role.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param autoRole the auto role
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedCanceledAutoRole(User user, MessageChannel channel, Guild guild, AutoRole autoRole) {
		EmbedBuilder embed = new EmbedBuilder();

		messageController.setEmbedTitle(guild, channel, user, embed, "embed_auto_role_canceled_title");
		messageController.setEmbedDescription(guild, channel, user, embed, "embed_auto_role_canceled_description");

		TextChannel textChannel = guild.getTextChannelById(autoRole.getChannel());
		Role role = guild.getRoleById(autoRole.getRole());

		embed.addField(messageController.createEmbedField(guild, channel, user, autoRole.getText(),
				"embed_auto_role_canceled_fiel", textChannel == null ? "null" : textChannel.getAsMention(),
				role == null ? "null" : role.getName()));

		return embed;
	}

	/**
	 * Creates the embed configured auto role.
	 *
	 * @param user the user
	 * @param channel the channel
	 * @param guild the guild
	 * @param autoRole the auto role
	 * @return the embed builder
	 */
	public EmbedBuilder createEmbedConfiguredAutoRole(User user, MessageChannel channel, Guild guild,
			AutoRole autoRole) {
		EmbedBuilder embed = new EmbedBuilder();

		TextChannel textChannel = guild.getTextChannelById(autoRole.getChannel());
		Role role = guild.getRoleById(autoRole.getRole());

		messageController.setEmbedTitle(guild, channel, user, embed, "embed_auto_role_sucess_title");
		messageController.setEmbedDescription(guild, channel, user, embed, "embed_auto_role_sucess_description",
				textChannel == null ? "null" : textChannel.getAsMention(), autoRole.getText(),
				role == null ? "null" : role.getName());

		return embed;
	}

}
