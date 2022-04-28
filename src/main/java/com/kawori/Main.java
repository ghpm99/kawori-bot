package com.kawori;

import javax.security.auth.login.LoginException;

import com.kawori.app.achievements.command.Achievements;
import com.kawori.app.avatar.command.Avatar;
import com.kawori.app.fun.command.Fun;
import com.kawori.app.help.command.Help;
import com.kawori.app.info.command.Info;
import com.kawori.app.pick.command.Pick;
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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

@SpringBootApplication
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
    private Help cmdHelp = new Help();
    private Pick cmdPick = new Pick();
    private Avatar cmdAvatar = new Avatar();
    private Fun cmdFun = new Fun();
    private Info cmdInfo = new Info();
    private CmdRegion cmdRegion = new CmdRegion();
    private Achievements cmdAchievements = new Achievements();

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
     * Gets the jda.
     *
     * @return the jda
     */
    public JDA getJDA() {
        return jda;
    }

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }
}
