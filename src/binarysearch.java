package src;

import java.util.Arrays;
import java.util.Scanner;

import common.*;

public class binarysearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("binarysearch");
        int n = input.getNum(in);
        switch(n){
            case 1: // find first and last index of a element in sorted array
                System.out.println(Arrays.toString(searchRange(input.getNumArrAsen(in),input.getNum(in))));
                break;
            case 2: // find element index in sorted array
                System.out.println(binsearchelementindx(input.getNumArrAsen(in),input.getNum(in)));
                break;
        }
        in.close();
    }

    public static int[] searchRange(int[] nums,int target){
        int[] ans = {-1,-1};
        ans[0]=binsearchtwoind(nums,target,true);
        if(ans[0]!=-1){
            ans[1]=binsearchtwoind(nums,target,false);
        }
        return ans;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    public static int binsearchtwoind(int[] nums,int target,boolean isFirstIndx){
        int l=0,r=nums.length-1,m=-1,ans=-1;
        while(l<=r){
            m=(l+r)/2;
            if(nums[m]>target) r=m-1;
            else if(nums[m]<target) l=m+1;
            else{
                ans=m;
                if(isFirstIndx) r=m-1;
                else l=m+1;
            }
        }
        return ans;
    }
    public static int binsearchelementindx(int[] nums,int target){
        int l=0,r=nums.length-1,m=0;
        if(target<=nums[0]) return 0;
        if(target>nums[nums.length-1]) return nums.length;
        if(target==nums[nums.length-1]) return nums.length-1;
        while(l<=r){
            m=(l+r)/2;
            if(nums[m]<target) l=m+1;
            else if(nums[m]>target) r=m-1;
            else return m;
        }
        return l;
    }
}
