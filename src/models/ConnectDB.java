package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectDB {

    //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
    private String url = "jdbc:postgresql://localhost:5432/data";
    private String name = "postgres";
    private String password = "iron2479";
    Connection connection = null;

    public Connection connectToDB() {
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            //Создаём соединение
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Соединение установлено");
        } catch (Exception e) {
            System.out.println("Не удается соединиться с сервером");
        }
        return connection;
    }

}
