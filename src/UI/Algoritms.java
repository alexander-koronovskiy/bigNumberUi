package UI;

import models.Company;
import models.ConnectDB;
import java.sql.*;

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

    String note(String data, String otherdata){
        Company company = new Company();
        company.isertData(new ConnectDB().connectToDB(), data, "Moscow", otherdata);
        return  company.printLast(new ConnectDB().connectToDB());
    }
}
