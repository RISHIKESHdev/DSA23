package src;

import java.util.Scanner;

import common.*;

public class bitmanipulation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("bitmanipulation");
        int n = input.getNum(in);
        switch(n){
            case 1: // single number
                System.out.println(singleNumber(input.getNumArr(in)));
                break;
            case 2: // missing number
                System.out.println(missingNumber(input.getNumArr(in)));
                break;  
        }
        in.close();
    }
    public static int singleNumber(int[] nums){
        int ans=0;
        for(int i:nums) ans=ans^i;
        return ans;
    }
    public static int missingNumber(int[] nums){
        int ans =0;
        for(int i=0;i<nums.length;i++){
            ans=ans^i;
            ans=ans^nums[i];
        }
        return ans^nums.length;
    }
}
