package models;

import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.*;

class JDBCtest {

    //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
    String url = "jdbc:postgresql://localhost:5432/data";
    String name = "postgres";
    String password = "iron2479";
    Connection connection = null;

    public static void main(String args[]) {

        String age = "15";
        String city = "Orenburg";
        String person = "Igor";
        JDBCtest j = new JDBCtest();

        try {
            Connection connection = j.connectToDB();
            j.isertData(connection,age,city,person);
            j.printLast(connection);
        } catch (Exception e){
            System.out.println("Не могу выролнить запрос");
        }

    }

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

    public void isertData(Connection connection, String data1, String data2, String data3) {
        try {
            String sql = "INSERT INTO company VALUES (?,?,?)";
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1, data1);
            stat.setString(2, data2);
            stat.setString(3, data3);
            stat.executeUpdate();
            System.out.println("Данные добавлены: " + data1 + " " + data2 + " " + data3);
        } catch (Exception e){
            System.out.println("Не могу выполнить запрос");
            e.printStackTrace();
        }
    }

    public void printLast(Connection connection){
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet result1 = statement.executeQuery("SELECT * FROM company order by id desc limit 1;");
            while (result1.next()) {
                System.out.println(result1.getString("name") + " " + result1.getString("age"));
            }
        } catch (Exception e){e.printStackTrace();}
    }

}