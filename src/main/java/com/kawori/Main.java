package com.kawori;

import java.util.Date;

import javax.security.auth.login.LoginException;

import com.kawori.command.CommandHandler;
import com.kawori.command.commands.CmdAchievements;
import com.kawori.command.commands.CmdAdm;
import com.kawori.command.commands.CmdAutoRole;
import com.kawori.command.commands.CmdAvatar;
import com.kawori.command.commands.CmdChar;
import com.kawori.command.commands.CmdExcel;
import com.kawori.command.commands.CmdFun;
import com.kawori.command.commands.CmdGS;
import com.kawori.command.commands.CmdHelp;
import com.kawori.command.commands.CmdNodeWar;
import com.kawori.command.commands.CmdPick;
import com.kawori.command.commands.CmdRank;
import com.kawori.command.commands.CmdRegion;
import com.kawori.listener.BotListener;
import com.kawori.listener.GuildListener;
import com.kawori.listener.MessageListener;
import com.kawori.listener.ReactionListener;
import com.kawori.listener.ReadyListener;
import com.kawori.listener.UserListener;

import org.slf4j.helpers.Util;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main {

    private JDA jda;

    public Main(){

    }

    /** The cmd GS. */
    // Comandos
    private CmdGS cmdGS;

    /** The cmd rank. */
    private CmdRank cmdRank;

    /** The cmd help. */
    private CmdHelp cmdHelp;

    /** The cmd node war. */
    private CmdNodeWar cmdNodeWar;

    /** The cmd adm. */
    private CmdAdm cmdAdm;

    /** The cmd pick. */
    private CmdPick cmdPick;

    /** The cmd avatar. */
    private CmdAvatar cmdAvatar;

    /** The cmd fun. */
    private CmdFun cmdFun;

    /** The cmd char. */
    private CmdChar cmdChar;

    /** The cmd info. */
    private CmdInfo cmdInfo;

    /** The cmd config. */
    private CmdConfig cmdConfig;

    /** The cmd excel. */
    private CmdExcel cmdExcel;

    /** The cmd region. */
    private CmdRegion cmdRegion;

    /** The cmd auto role. */
    private CmdAutoRole cmdAutoRole;

    /** The cmd achievements. */
    private CmdAchievements cmdAchievements;

    /** The ready listener. */
    // Eventos Listeners
    private ReadyListener readyListener;

    /** The message listener. */
    private MessageListener messageListener;

    /** The reaction listener. */
    private ReactionListener reactionListener;

    /** The guild listener. */
    private GuildListener guildListener;

    /** The bot listener. */
    private BotListener botListener;

    /** The user listener. */
    private UserListener userListener;

    /** The status service. */
    // Services
    private StatusService statusService;

    /** The log service. */
    private LogService logService;

    /** The config service. */
    ConfigurationService configService;

    /**
     * Inits the.
     */
    public void init() {

        statusService.setStatusBot("Iniciando...");
        logService.addEvent(new Log(new Date(), "Iniciando Bot", "", "", "OK"));

        Util.PREFIX = configService.getByType("prefix").getValue();
        Util.PREFIXAUTOROLE = configService.getByType("prefixAutoRole").getValue();

        JDABuilder builder = JDABuilder.createDefault(configService.getByType("token").getValue(),
                GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.DIRECT_MESSAGES, GatewayIntent.DIRECT_MESSAGE_REACTIONS).setAutoReconnect(true);

        builder.disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOTE);

        setListeners(builder);

        setCommands();

        try {
            jda = builder.build();

        } catch (LoginException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }

    }

    /**
     * Sets the listeners.
     *
     * @param builder the new listeners
     */
    private void setListeners(JDABuilder builder) {
        logService.addEvent(new Log(new Date(), "Adicionando Listeners", "", "", "-"));
        builder.addEventListeners(readyListener);
        builder.addEventListeners(messageListener);
        builder.addEventListeners(reactionListener);
        builder.addEventListeners(guildListener);
        builder.addEventListeners(botListener);
        builder.addEventListeners(userListener);
        logService.addEvent(new Log(new Date(), "Listeners adicionados", "", "", "OK"));
    }

    /**
     * Sets the commands.
     */
    private void setCommands() {
        logService.addEvent(new Log(new Date(), "Adicionando Comandos", "", "", "-"));
        // util
        CommandHandler.commands.put("help", cmdHelp);
        CommandHandler.commands.put("info", cmdInfo);
        CommandHandler.commands.put("region", cmdRegion);
        CommandHandler.commands.put("achievements", cmdAchievements);

        // build
        CommandHandler.commands.put("gear", cmdGS);
        CommandHandler.commands.put("rank", cmdRank);
        CommandHandler.commands.put("char", cmdChar);

        // node war
        CommandHandler.commands.put("nw", cmdNodeWar);

        // adm
        CommandHandler.commands.put("adm", cmdAdm);
        CommandHandler.commands.put("config", cmdConfig);
        CommandHandler.commands.put("excel", cmdExcel);
        CommandHandler.commands.put("autorole", cmdAutoRole);

        // fun
        CommandHandler.commands.put("pick", cmdPick);
        CommandHandler.commands.put("avatar", cmdAvatar);
        CommandHandler.commands.put("hug", cmdFun);
        CommandHandler.commands.put("slap", cmdFun);
        CommandHandler.commands.put("nom", cmdFun);
        CommandHandler.commands.put("cuddle", cmdFun);
        CommandHandler.commands.put("kiss", cmdFun);
        CommandHandler.commands.put("bite", cmdFun);
        CommandHandler.commands.put("dance", cmdFun);
        CommandHandler.commands.put("awoo", cmdFun);
        CommandHandler.commands.put("owo", cmdFun);
        CommandHandler.commands.put("poke", cmdFun);
        CommandHandler.commands.put("lewd", cmdFun);
        CommandHandler.commands.put("blush", cmdFun);
        CommandHandler.commands.put("confused", cmdFun);
        CommandHandler.commands.put("cry", cmdFun);
        CommandHandler.commands.put("sad", cmdFun);
        CommandHandler.commands.put("pat", cmdFun);
        CommandHandler.commands.put("fox", cmdFun);
        CommandHandler.commands.put("punch", cmdFun);
        CommandHandler.commands.put("trap", cmdFun);
        CommandHandler.commands.put("explosion", cmdFun);

        logService.addEvent(new Log(new Date(), "Comandos adicionados", "", "", "OK"));
    }

    /**
     * Gets the jda.
     *
     * @return the jda
     */
    public JDA getJDA() {
        return jda;
    }

    public static void main(String[] args){
        new Main();
    }
}
