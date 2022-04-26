package com.kawori.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conection {

    private Connection conn;
    private String user;
    private String password;
    private String porta;
    private String local;

    public Conection(String local, String porta, String user, String password) {
        this.local = local;
        this.porta = porta;
        this.user = user;
        this.password = password;
    }

    public void connection() {
        try {
            String url = "jdbc:postgresql://" + local + ":" + porta ;
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            props.setProperty("ssl", "true");
            conn = DriverManager.getConnection(url, props);
            System.out.println("Conectado!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar!");
        }
    }

    public Connection getConnection(){
        if(conn == null){
            connection();
        }
        return conn;
    }

    public void disconnection(){
        try {
            conn.close();
            System.out.println("Desconectado!");
        } catch (Exception e) {
            System.out.println("Erro ao desconectar!");
        }
    }

}
