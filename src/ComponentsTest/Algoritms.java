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
            int[] nums2 = new int[data.length()];
            int num;
            for(int i =0; i < data.length();i++)
            {
                num = numData % 10;
                numData = numData /10;
                nums[i] = num;
            }
            Arrays.sort(nums);

            for (int j = nums.length-1; j >= 0; j--) {
                nums2[nums.length -1 -j] = nums[j];
            }
            for (int k = 0; k < nums2.length; k++) {
                s = s + nums2[k];
            }
        }
        catch (IllegalArgumentException e) {s = "Неверный ввод";}
        finally{ return s; }
    }
}
