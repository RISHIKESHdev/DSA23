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
            case 3: // search in a 2D matrix
                System.out.println(searchMatrix(input.get2dNumArr(in),input.getNum(in)));
                break;
            case 4: // count negative in a 2D matrix
                System.out.println(countNegatives(input.get2dNumArr(in)));
                break;
            case 5: // arrange coins
                System.out.println(arrangeCoins(input.getNum(in)));
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
    public static boolean searchMatrix(int[][] nums,int target){
        int m=nums.length,n=nums[0].length;
        int ol=0,or=m-1,om=-1;
        while(ol<=or){
            om=(ol+or)/2;
            if(target<nums[om][0]) or=om-1;
            else if(target>nums[om][n-1]) ol=om+1;
            else{
                int il=0,ir=n-1,im=-1;
                while(il<=ir){
                    im=(il+ir)/2;
                    if(nums[om][im]>target) ir=im-1;
                    else if(nums[om][im]<target) il=im+1;
                    else return true;
                }
                return false;
            }
        }
       return false;
    }

    public static int countNegatives(int[][] grid){
        int l=0,r=grid[0].length-1,m=-1,res=0;
        for(int[] row:grid){
            while(l<=r){
                m=(l+r)/2;
                if(row[m]<0) r=m-1;
                else l=m+1;
            }
            res=res+grid[0].length-l;
            l=0;
            r=grid[0].length-1;
            m=-1;
        }
        return res;
    }
    public  static int arrangeCoins(int n){
        long left = 0, right = n;
    long k, curr;
    while (left <= right) {
      k = left + (right - left) / 2;
      curr = k * (k + 1) / 2;

      if (curr == n) return (int)k;

      if (n < curr) {
        right = k - 1;
      } else {
        left = k + 1;
      }
    }
    return (int)right;
    }
}
