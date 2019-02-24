package models;

import java.sql.*;
import java.util.ArrayList;

public class Backpack {

    public void insertData(Connection connection, String object,float volume, float value) {
        try {
            String sql = "INSERT INTO backpack VALUES (?,?,?)";
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setString(1,object);
            stat.setFloat(2, volume);
            stat.setFloat(3, value);
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
                        + result1.getFloat("volume") + " "
                        + result1.getFloat("value");
            }
        } catch (Exception e){e.printStackTrace(); }
        return s;
    }

    public ArrayList printAll(Connection connection){
        ArrayList notes = new ArrayList();

        try {
            Statement statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery
                    ("SELECT * FROM backpack;");
            while (result1.next()) {
                notes.add(result1.getInt("id") + " "
                        + result1.getString("object") + " "
                        + result1.getFloat("volume") + " "
                        + result1.getFloat("value"));
            }

        } catch (Exception e){e.printStackTrace(); }
        return notes;
    }

    public ArrayList printVolume(Connection connection){
        ArrayList notes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery
                    ("SELECT * FROM backpack;");
            while (result1.next()) {
                notes.add(result1.getFloat("volume"));
            }
        } catch (Exception e){e.printStackTrace(); }
        return notes;
    }

    public ArrayList printValue(Connection connection){
        ArrayList notes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery
                    ("SELECT * FROM backpack;");
            while (result1.next()) {
                notes.add(result1.getFloat("value"));
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
