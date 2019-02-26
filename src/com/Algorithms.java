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

        final Item[] items = this.notesToItem(notes);
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());

        float weightSoFar = 0;
        double valueSoFar = 0;
        int currentItem = 0;

        while( currentItem < items.length && weightSoFar != backpackSize){
            if (weightSoFar + items[currentItem].getWeight() < backpackSize){
                valueSoFar  += items[currentItem].getValue();
                weightSoFar += items[currentItem].getWeight();
            } else {
                valueSoFar += ((backpackSize - weightSoFar) /
                        items[currentItem].getWeight()) *
                        items[currentItem].getValue();
                weightSoFar = backpackSize;
            }
            currentItem++;
        }

        System.out.println(Arrays.toString(items));
        return "Общая ценность предметов: " + valueSoFar + " "
                + "тяжесть рюкзака: " + weightSoFar + " "
                + "элемент:  " + currentItem;
    }

    Item[] notesToItem(ArrayList notes){
        Item[] items = new Item[notes.size()];
        for (int i =0; i < notes.size(); i++){
            String name = notes.get(i).toString().split(" ")[1];
            Float weight = Float.valueOf(notes.get(i).toString().split(" ")[2]);
            Float value = Float.valueOf(notes.get(i).toString().split(" ")[3]);
            items[i] = new Item(name, weight, value);
        }
        return items;
    }

    class Item{
        private String name;
        private double weight;
        private double value;

        public Item(String name, Float weight, Float value){
            this.name = name;
            this.weight = weight;
            this.value = value;
        }

        public double valuePerUnitOfWeight(){
            return value /  (double) weight;
        }

        public String getName() {
            return name;
        }

        public double getWeight() {
            return weight;
        }

        public double getValue() {
            return value;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String toString(){
            return "{item:  " + name + " weight: " + weight + " value: " + value + "}";
        }

    }

}
