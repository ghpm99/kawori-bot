package com.kawori.service;

import java.util.Random;

import com.kawori.model.MessageDiscord;
import com.kawori.model.UserDiscord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {

    @Autowired
    private UserService userService;

    private final int INCREASE_COMMON_EXPERIENCE = 10;

    private final int INCREASE_COMMAND_EXPERIENCE = 50;

    public void generatedExperience(MessageDiscord messageDiscord) {
        if (messageDiscord.getStatus() == MessageDiscord.Status.FINISHED) {
            UserDiscord user = userService.findByIdDiscord(messageDiscord.getIdUserDiscord());
            if (messageDiscord.getCommand().equals("")) {
                generatedCommonExperience(messageDiscord, user);
            } else {
                generatedCommandExperience(messageDiscord, user);
            }
        }
    }

    private void generatedCommonExperience(MessageDiscord messageDiscord, UserDiscord user) {
        increaseUserExp(user, INCREASE_COMMON_EXPERIENCE);
        user.increaseMsgCount();
        userService.save(user);
    }

    private void generatedCommandExperience(MessageDiscord messageDiscord, UserDiscord user) {
        increaseUserExp(user, INCREASE_COMMAND_EXPERIENCE);
        user.increaseCmdCount();
        userService.save(user);
    }

    private void increaseUserExp(UserDiscord user, int fixedExp) {
        int currentExp = user.getExp();
        int increaseExp = (new Random().nextInt(10)) + fixedExp;
        user.setExp(currentExp + increaseExp);
    }

}
