package com.kawori;

import javax.security.auth.login.LoginException;

import com.kawori.command.CommandHandler;
import com.kawori.command.commands.CmdAchievements;
import com.kawori.command.commands.CmdAvatar;
import com.kawori.command.commands.CmdFun;
import com.kawori.command.commands.CmdHelp;
import com.kawori.command.commands.CmdInfo;
import com.kawori.command.commands.CmdPick;
import com.kawori.command.commands.CmdRegion;
import com.kawori.listener.BotListener;
import com.kawori.listener.GuildListener;
import com.kawori.listener.MessageListener;
import com.kawori.listener.ReactionListener;
import com.kawori.listener.ReadyListener;
import com.kawori.listener.UserListener;
import com.kawori.service.StatusService;
import com.kawori.settings.Settings;
import com.kawori.util.Util;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Main{

    private JDA jda;

    public Main(){

        statusService.setStatusBot("Iniciando...");

        Util.PREFIX = Settings.getPrefix();
        Util.PREFIXAUTOROLE = Settings.getPrefixRole();

        JDABuilder builder = JDABuilder.createDefault(Settings.getToken(),
                GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.DIRECT_MESSAGES, GatewayIntent.DIRECT_MESSAGE_REACTIONS).setAutoReconnect(true);

        builder.disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOTE);

        setListeners(builder);

        setCommands();

        try {
            jda = builder.build();
            jda.awaitReady();

        } catch (LoginException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /** The cmd help. */
    private CmdHelp cmdHelp = new CmdHelp();

    /** The cmd pick. */
    private CmdPick cmdPick = new CmdPick();

    /** The cmd avatar. */
    private CmdAvatar cmdAvatar = new CmdAvatar();

    /** The cmd fun. */
    private CmdFun cmdFun = new CmdFun();


    /** The cmd info. */
    private CmdInfo cmdInfo = new CmdInfo();


    /** The cmd region. */
    private CmdRegion cmdRegion = new CmdRegion();


    /** The cmd achievements. */
    private CmdAchievements cmdAchievements = new CmdAchievements();

    /** The ready listener. */
    // Eventos Listeners
    private ReadyListener readyListener = new ReadyListener();

    /** The message listener. */
    private MessageListener messageListener = new MessageListener();

    /** The reaction listener. */
    private ReactionListener reactionListener = new ReactionListener();

    /** The guild listener. */
    private GuildListener guildListener = new GuildListener();

    /** The bot listener. */
    private BotListener botListener = new BotListener();

    /** The user listener. */
    private UserListener userListener = new UserListener();

    /** The status service. */
    // Services
    private StatusService statusService = new StatusService();

    /**
     * Sets the listeners.
     *
     * @param builder the new listeners
     */
    private void setListeners(JDABuilder builder) {

        builder.addEventListeners(readyListener);
        builder.addEventListeners(messageListener);
        builder.addEventListeners(reactionListener);
        builder.addEventListeners(guildListener);
        builder.addEventListeners(botListener);
        builder.addEventListeners(userListener);

    }

    /**
     * Sets the commands.
     */
    private void setCommands() {
        // util
        CommandHandler.commands.put("help", cmdHelp);
        CommandHandler.commands.put("info", cmdInfo);
        CommandHandler.commands.put("region", cmdRegion);
        CommandHandler.commands.put("achievements", cmdAchievements);


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
