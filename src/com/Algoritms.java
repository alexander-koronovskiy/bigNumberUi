package com;

import models.Backpack;
import models.Company;
import models.ConnectDB;

import java.util.Arrays;
import java.util.Collections;

class Algoritms{
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

        int numVolume = 0;
        int numValue = 0;
        String s = "";
        Backpack backpack = new Backpack();

        try {
            numVolume = Integer.parseInt(volume);
            numValue = Integer.parseInt(value);
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

    String backPackAlgoritm(){ return "Оптимальная сортировка предметов произведена";}

    String cleanBackPack(){
        return "Статус рюкзака: "
                + new Backpack().DeleteAll(new ConnectDB().connectToDB());
    }


}
