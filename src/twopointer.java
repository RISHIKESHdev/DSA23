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
            case 4: // merge sorted array
                merge(input.getNumArr(in),input.getNum(in),input.getNumArrAsen(in),input.getNum(in));
                break;
            case 5: // best time to buy and sell stock
                System.out.println(maxProfit(input.getNumArr(in)));
                break;
            case 6: // Microsoft SDE-1 2023
                System.out.println(microsoftLongSubstring(input.getString(in)));
                break;
            case 7: // Move Zeroes
                System.out.println(Arrays.toString(moveZeroes(input.getNumArr(in))));
                break;
            case 8: // close sum possible two sorted array
                System.out.println(Arrays.toString(closeSumSortArr(input.getNum(in),input.getNumArrAsen(in),input.getNumArrAsen(in))));
                break;
            case 9: // squares of sorted array
                System.out.println(Arrays.toString(sortedSquares(input.getNumArrAsen(in))));
                break;
            case 10: // longest subarray atmost k
                System.out.println(atMostSum(input.getNumArr(in),input.getNum(in)));
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
    public static void merge(int[] nums1,int m,int[] nums2, int n){
        int a= m-1,b=n-1,insertIndx=nums1.length-1;
        while(b>=0){
            if(a>=0 && nums1[a]>nums2[b]){
                nums1[insertIndx]=nums1[a];
                a--;
                insertIndx--;
            }else{
                nums1[insertIndx]=nums2[b];
                b--;
                insertIndx--;
            }
        }
        System.out.println(Arrays.toString(nums1));
    }
    public static int maxProfit(int[] nums){
        int ans=0,i=0,j=1;
        while(j<nums.length){
            if(nums[i]>nums[j]){
                i=j;
                j++;
            }else{
                ans=Math.max(nums[j]-nums[i],ans);
                j++;
            }
        }
        return ans;
    }
    public static String microsoftLongSubstring(String s){
        String ans="";
        int i=0,j=1,aux=1,maxSub=0,temp=0,ansi=0,ansj=0;
        while(j<s.length()){
            if(s.charAt(j)==s.charAt(j-1)) aux++;
            else if(s.charAt(j)!=s.charAt(j-1)) aux=1;
            if(aux>2){
                temp=maxSub;
                maxSub=Math.max(maxSub,j-(i+1));
                if(temp!=maxSub){
                    ansi=i;
                    ansj=j;
                }
                i=j-1;
                aux=2;
            }
            j++;
        }
        ans=s.substring(ansi, ansj);
        return ans;
    }
    public static int[] moveZeroes(int[] nums){
        if(nums.length!=1){
            int i=0,j=0,temp=0;
            while(j<nums.length){
                if(nums[j]!=0){
                    temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    i++;
                }
                j++;
            }
        }
        return nums;
    }
    public static int[] closeSumSortArr(int x,int[] A,int[] B){
        int booli=0,boolj=0,fir=-1,sec=-1,prevCom=1000000,first=-1,second=-1,i=0,j=B.length-1,ans=0;
        while(i<B.length && j>=0){
            if(A[i]+B[j]<=x){
                if(A[i]+B[j] > ans){
                    first=A[i];
                    second=B[j];
                    booli=1;
                }
                i++;
            }else{
                if(A[i]+B[j]<prevCom){
                    prevCom=A[i]+B[j];
                    fir=A[i];
                    sec=B[j];
                    boolj=1;
                }
                j--;
            }
        }
        if(booli==1 && boolj==1){
            if(first+second -x >= fir+sec-x) return new int[]{fir,sec};
            else return new int[]{first,second};
        }else if(boolj==1) return new int[]{fir,sec};
        else return new int[]{first,second};
    }
    public static int[] sortedSquares(int[] nums){
        int[] ans = new int[nums.length];
        int i=0,j=nums.length-1,s1=0,s2=0;
        int l=nums.length-1;
        while(i<=j){
            s1=nums[i]*nums[i];
            s2=nums[j]*nums[j];
            if(s1<s2){
                ans[l--]=s2;
                j--;
            }else{
                ans[l--]=s1;
                i++;        
            }
        }
        return ans;
    }
    public static int atMostSum(int[] arr, int k)
  {
    int n=arr.length;
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += arr[j];
        if (sum <= k) {
            result = Math.max(result, (j - i + 1));
        }
        else {
          break;
        }
      }
    }
    return result;
  }
}