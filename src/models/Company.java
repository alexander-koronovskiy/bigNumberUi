package models;

import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.*;

public class Company {

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

    public String printLast(Connection connection){
        String s = "";
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet result1 = statement.executeQuery("SELECT * FROM company order by id desc limit 1;");
            while (result1.next()) {
                s = s + result1.getInt("id") + " " + result1.getString("name") + " " + result1.getString("age");
            }
        } catch (Exception e){e.printStackTrace(); }
        return s;
    }

    public String deleteLast(Connection connection){
        String s = "";
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet result1 = statement.executeQuery("SELECT MAX(id) FROM company");
            while (result1.next()) {
                s = s + result1.getInt("id");
            }
        } catch (Exception e){e.printStackTrace(); }
        return s;
    }

}