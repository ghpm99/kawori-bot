package com.kawori.discord;

import javax.annotation.PreDestroy;
import javax.security.auth.login.LoginException;

import com.kawori.listener.BotListener;
import com.kawori.listener.GuildListener;
import com.kawori.listener.MessageListener;
import com.kawori.listener.ReactionListener;
import com.kawori.listener.ReadyListener;
import com.kawori.listener.UserListener;
import com.kawori.service.StatusService;
import com.kawori.settings.Settings;
import com.kawori.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

@Component
public class Discord {

    private JDA jda;
    private ReadyListener readyListener;
    private MessageListener messageListener;
    private ReactionListener reactionListener;
    private GuildListener guildListener;
    private BotListener botListener;
    private UserListener userListener;
    private StatusService statusService;
    private Settings settings;

    @Autowired
    public Discord(ReadyListener readyListener,
            MessageListener messageListener,
            ReactionListener reactionListener,
            GuildListener guildListener,
            BotListener botListener,
            UserListener userListener,
            StatusService statusService,
            Settings settings) {

        this.readyListener = readyListener;
        this.messageListener = messageListener;
        this.reactionListener = reactionListener;
        this.guildListener = guildListener;
        this.botListener = botListener;
        this.userListener = userListener;
        this.statusService = statusService;
        this.settings = settings;
    }

    @EventListener(ApplicationReadyEvent.class)
    private void init() {
        statusService.setStatusBot("Iniciando...");

        Util.PREFIX = settings.getPrefix();
        Util.PREFIXAUTOROLE = settings.getPrefixRole();

        JDABuilder builder = JDABuilder.createDefault(settings.getToken(),
                GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.DIRECT_MESSAGES, GatewayIntent.DIRECT_MESSAGE_REACTIONS).setAutoReconnect(true);

        builder.disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOTE);

        setListeners(builder);

        try {
            jda = builder.build();
            jda.awaitReady();

        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setListeners(JDABuilder builder) {

        builder.addEventListeners(readyListener);
        builder.addEventListeners(messageListener);
        builder.addEventListeners(reactionListener);
        builder.addEventListeners(guildListener);
        builder.addEventListeners(botListener);
        builder.addEventListeners(userListener);

    }

    @PreDestroy
    private void destroy(){
        statusService.setStatusBot("Encerrando");
        jda.shutdown();
    }

    public JDA getJDA() {
        return jda;
    }

}
