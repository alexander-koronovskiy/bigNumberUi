package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Backpack {

    public void insertData(Connection connection, String object,int volume, int value) {
        try {
            String sql = "INSERT INTO backpack VALUES (?,?,?)";
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1,object);
            stat.setInt(2, volume);
            stat.setInt(3, value);
            stat.executeUpdate();
            System.out.println("Данные добавлены: " + object + " " + volume + " " + value);
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
            ResultSet result1 = statement.executeQuery
                    ("SELECT * FROM backpack order by id desc limit 1;");
            while (result1.next()) {
                s = s + result1.getInt("id") + " "
                        + result1.getString("object") + " "
                        + result1.getInt("volume") + " "
                        + result1.getInt("value");
            }
        } catch (Exception e){e.printStackTrace(); }
        return s;
    }

    public ArrayList<String> printAll(Connection connection){
        ArrayList<String> notes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery
                    ("SELECT * FROM backpack;");
            while (result1.next()) {
                notes.add(result1.getInt("id") + " "
                        + result1.getString("object") + " "
                        + result1.getInt("volume") + " "
                        + result1.getInt("value"));
            }
        } catch (Exception e){e.printStackTrace(); }
        return notes;
    }

    public String DeleteAll(Connection connection){
        String s1 = "";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM backpack;");
            s1 = "Содержимое удалено";
        }catch (Exception e){ s1 = "Ошибка удаления"; e.printStackTrace();}
        finally {
            return s1;
        }
    }

}
