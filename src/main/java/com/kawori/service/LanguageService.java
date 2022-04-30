package com.kawori.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.kawori.model.GuildDiscord;
import com.kawori.model.UserDiscord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;

@Service
public class LanguageService {

	@Autowired
	private GuildaService guildaService;

	@Autowired
	private OperatorService operatorService;

	private final String DEFAULT_LANGUAGE = "Brazil";

	public String getLanguage(Guild guild, User user) {
		GuildDiscord guilda = guildaService.findById(guild.getIdLong());
		UserDiscord operator = operatorService.findById(user.getIdLong());
		return getLanguage(guilda, operator);
	}

	private String getLanguage(GuildDiscord guild, UserDiscord user) {
		String language = DEFAULT_LANGUAGE;
		if (user.getRegion() != null) {
			language = user.getRegion();
		}
		return language;
	}

	public String loadMessage(Guild guild, User user, String message) {
		String region = getLanguage(guild, user);
		String fileName = System.getProperty("user.dir") + File.separator + "language" + File.separator + region
				+ ".lng";

		String retorno = null;
		Properties pro = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(fileName);
			pro.load(input);
			retorno = pro.getProperty(message);
		} catch (FileNotFoundException e) {
			createFile(System.getProperty("user.dir") + File.separator + "language", region + ".lng");
			return " _nameMention , that language is not yet supported!";
		} catch (IOException e) {
			return " _nameMention , that language is not yet supported!";
		}
		if (retorno == null) {
			retorno = message;
		}
		return retorno;
	}

	private void createFile(String path, String fileName) {
		File newDirectory = new File(path);
		File newFile = new File(path + File.separator + fileName);

		if (newDirectory.mkdirs()) {
			System.out.println("New Directory " + newDirectory.getAbsolutePath() + " was successfully created.");
		} else {
			System.out.println("New Directory " + newDirectory.getAbsolutePath() + " was failed to be created.");
		}

		try {
			if (newFile.createNewFile()) {
				System.out.println("New file " + newFile.getAbsolutePath() + " was successfully created.");
			} else {
				System.out.println("New file " + newFile.getAbsolutePath() + " was failed to be created.");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void setRegion(Guild guild, String region) {
		GuildDiscord guilda = guildaService.findById(guild.getIdLong());
		guildaService.save(guilda);

	}

	public void setRegion(User user, String region) {

		UserDiscord operator = operatorService.findById(user.getIdLong());
		operator.setRegion(region.toLowerCase());
		operatorService.save(operator);

	}

}
