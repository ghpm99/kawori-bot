package com.kawori.settings;

public class Settings {

    private static final boolean DEBUG = true;

    public static String getToken(){
        if(DEBUG){
            return LocalSettings.TOKEN;
        }
        return "";
    }

    public static String getPrefix(){
        if(DEBUG){
            return LocalSettings.PREFIX;
        }
        return "";
    }

    public static String getPrefixRole(){
        if(DEBUG){
            return LocalSettings.PREFIXROLE;
        }
        return "";
    }
}
