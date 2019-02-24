package com;

import models.Backpack;
import models.Company;
import models.ConnectDB;
import java.sql.Connection;
import java.util.*;

class Algorithms{
    final static float backpackSize = Swingtest.LIMIT;

    String bigNumAlgs(String data) {
        String s="";
        int numData;

        try
        {
            numData = Integer.parseInt(data);
            int[] nums = new int[data.length()];
            int num;
            for(int i =0; i < data.length();i++)
            {
                num = numData % 10;
                numData = numData /10;
                nums[i] = num;
            }

            s = String.join("",Arrays.stream(nums).boxed().
                    sorted(Collections.reverseOrder())
                    .map(String::valueOf)
                    .toArray(String[]::new));
        }
        catch (IllegalArgumentException e) { s = "Неверный ввод"; }
        finally { return s; }
    }

    String sum(String a, String b) {
        int sum;
        String s="";
        try
        {
            sum = Integer.parseInt(a) + Integer.parseInt(b);
            s = String.valueOf(sum);
        }
        catch (IllegalArgumentException e) { s = "Неверный ввод"; }
        finally { return s; }
    }

    String note(String age, String name){
        Company company = new Company();
        company.insertData(new ConnectDB().connectToDB(), age, "Moscow", name);
        return  company.printLast(new ConnectDB().connectToDB());
    }

    String putInBackpack(String object, String volume, String value) {

        float numVolume = 0;
        float numValue = 0;
        String s = "";
        Backpack backpack = new Backpack();

        try {
            numVolume = Float.valueOf(volume);
            numValue = Float.valueOf(value);
        } catch (Exception e){
            numVolume = 0;
            numValue = 0;
            e.printStackTrace();
        } finally {
            if (numValue != 0) {
                backpack.insertData
                        (new ConnectDB().connectToDB(), object, numVolume, numValue);
                s = s + backpack.printLast(new ConnectDB().connectToDB());
            }
        }
        if (s.equals("")) return "Не могу внести предмет. Проверьте введенные данные.";
        else return s;
    }

    String cleanBackPack(){
        return "Статус рюкзака: "
                + new Backpack().DeleteAll(new ConnectDB().connectToDB());
    }

    String backPackAlgorithm(){
        ArrayList notes;
        Backpack backpack = new Backpack();
        Connection connection = new ConnectDB().connectToDB();
        notes = backpack.printAll(connection);
        return this.sortedByWorth(notes) + "";
    }

    Map sortedByWorth(ArrayList notes){
        Map worth = new TreeMap<>(Collections.reverseOrder());
        float tmp;
        for (int i =0; i < notes.size(); i++){
            tmp = Float.valueOf(notes.get(i).toString().split(" ")[3]) /
                    Float.valueOf(notes.get(i).toString().split(" ")[2]);
            worth.put(tmp,notes.get(i));
        }
        return worth;
    }

    String oldPackingAlgorithm(ArrayList notes){

        float valueSize = 0;
        float currentPackSize = backpackSize;
        float k;
        int i = 0;
        int range = notes.size();


        while (currentPackSize !=0){
            float elementVolume = Float.valueOf(notes.get(i).toString().split(" ")[2]);
            float elementValue = Float.valueOf(notes.get(i).toString().split(" ")[3]);

            if (currentPackSize > elementVolume){
                currentPackSize = currentPackSize - elementVolume;
                valueSize = valueSize + Float.valueOf(notes.get(i).toString().split(" ")[3]);
            }
            if (currentPackSize < elementVolume){
                k = currentPackSize / elementVolume;
                valueSize = valueSize + k * elementValue;
            }
            i++;
            if (i == range) break;
        }

        return "Общая ценность: " + valueSize + " "
                + "Объем оставшегося пространства: " + currentPackSize;
    }

    void newPackingAlorithm(Map<Float,String> dictionary){
        // пока в слваре есть элемент
        // извлекаем из него строку, из строки - значение объема части
        // алгоритм, похожий на oldPacking, написанный ранее
    }

}
