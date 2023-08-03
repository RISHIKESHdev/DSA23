package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import common.*;

public class stack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("stack");
        int n = input.getNum(in);
        switch(n){
            case 1: // find next greater element
                System.out.println(Arrays.toString(nextGreaterElement(input.getNumArr(in),input.getNumArr(in))));
                break;
        }
        in.close();
    }
    public static int[] nextGreaterElement(int[] nums1,int[] nums2){
        int ans[] = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums2){
            while(!stack.isEmpty() && n> stack.peek()){
                map.put(stack.pop(),n);
            }
            stack.push(n);
        }
        int i=0;
        for(int n:nums1){
            ans[i++]=map.getOrDefault(n,-1);
        }
        return ans;
    }
}
