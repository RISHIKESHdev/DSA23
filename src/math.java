package src;

import java.util.Arrays;
import java.util.Scanner;
import common.*;

public class math {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("math");
        int n = input.getNum(in);
        switch(n){
            case 1: // is num palindrome
                System.out.println(isNumPalindrome(input.getNum(in)));
                break;
            case 2: // plus 1 in array
                System.out.println(Arrays.toString(plusOne(input.getNumArr(in))));
                break;
            case 3: // missing number
                System.out.println(missingNumber(input.getNumArr(in)));
                break;
        }
        in.close();
    }

    public static boolean isNumPalindrome(int x){
        int z=0;
        int y=x;
        while(y>0){
            z=z*10+y%10;
            y=y/10;
        }
        return x==z;
    }
    public static int[] plusOne(int[] nums){
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<9){
                nums[i]++;
                return nums;
            }else nums[i]=0;
        }
        int[] rnums = new int[nums.length+1];
            rnums[0]=1;
            return rnums;
    }
    public static int missingNumber(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return (nums.length*(nums.length+1)/2)-sum;
    }
}
