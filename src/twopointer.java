package src;

import java.util.Arrays;
import java.util.Scanner;

import common.*;

public class twopointer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("twopointer");
        int n = input.getNum(in);
        switch(n){
            case 1: // unique count in asending array
                System.out.println(removeDuplicates(input.getNumArrAsen(in)));
                break;
            case 2: // remove given element in array
                System.out.println(removeElement(input.getNumArr(in),input.getNum(in)));
                break;
            case 3: // remove given element in array
                nextPermutation(input.getNumArr(in));
                break;
        }
        in.close();
    }
    public static int removeDuplicates(int[] nums){
        int insertIndx=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]!=nums[i]) nums[insertIndx++]=nums[i];
        }
        return insertIndx;
    }
    public static int removeElement(int[] nums, int val){
        int insertIndx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val) nums[insertIndx++]=nums[i];
        }
        return insertIndx;
    }
    public static void nextPermutation(int[] nums){
        int indx1=-1,indx2=-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                indx1 = i-1;
                break;
            }
        }
        if(indx1==-1) logic.reverseIntFrom(nums,0);
        else{
            for(int i=nums.length-1;i>0;i--){
                if(nums[i]>nums[indx1]){
                    indx2 = i;
                    break;
                }
            }
            logic.swapInt(nums, indx1, indx2);
            logic.reverseIntFrom(nums, indx1+1);
        }
        System.out.println(Arrays.toString(nums));
    }
}