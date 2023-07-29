package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import common.*;

public class hash {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("hash");
        int n = input.getNum(in);
        switch(n){
            case 1://two sum
                System.out.println(Arrays.toString(twoSum(input.getNumArr(in),input.getNum(in))));
                break;
        }
        in.close();
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                int arr[]=new int[2];
                arr[0]=map.get(target-nums[i]);
                arr[1]=i;
                return arr;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return null;
        // for(int c = 1; c < nums.length; c++){
        //     for(int i = 0; i + c < nums.length;i++){
        //         if(nums[i] + nums[i + c] == target){
        //             return new int[] {i,i + c};
        //         }
        //     }
        // }
        // return new int[] {};
    }
}
