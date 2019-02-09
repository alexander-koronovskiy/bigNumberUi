package ComponentsTest;

import java.util.Arrays;

class Algoritms {
    String bigNumAlgs(String data)
    {
        String s="";
        int numData;
        try {
            numData = Integer.parseInt(data);
            int[] nums = new int[data.length()];
            int num;
            for(int i =0; i < data.length();i++)
            {
                num = numData % 10;
                numData = numData /10;
                nums[i] = num;
            }
            Arrays.sort(nums);

            for (int j = nums.length-1; j >= 0; j--) {
                s = s + nums[j];
            }
        }
        catch (IllegalArgumentException e) {s = "Неверный ввод";}
        finally{ return s; }
    }
}
