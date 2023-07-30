package src;

import java.util.Arrays;
import java.util.Scanner;

import common.*;

public class dynamicprog {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("dynamicprog");
        int n = input.getNum(in);
        switch(n){
            case 1: // climbing stairs
                System.out.println(climbStairs(input.getNum(in)));
                break;
            case 2: // pascal triangle
                System.out.println(generate(input.getNum(in)));
                break;
            case 3: // pascal triangle
                System.out.println(getRow(input.getNum(in)));
                break;
            case 4: // best time to buy and sell stock
                System.out.println(maxProfit(input.getNumArr(in)));
                break;
        }
        in.close();
    }

    public static int climbStairs(int n){
        if(n==1) return 1;
        else if(n==2) return 2;
        int dp[] = new int[n];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n-1];
    }
    public static List<List<Integer>> generate(int numRow){
        int jag[][] = new int[numRow][];
        for(int i=0;i<numRow;i++){
            int temp[] =new int[i+1];
            temp[0]=1;
            for(int j=1;j<i;j++){
                temp[j]=jag[i-1][j]+jag[i-1][j-1];
            }
            temp[i]=1;
            jag[i]=temp;
        }
        List<List<Integer>> ans = (List)Arrays.asList(jag);
        return ans;
    }
    public static java.util.List<Integer> getRow(int n){
        Integer[] arr = new Integer[n+1];
        Arrays.fill(arr,0);
        arr[0]=1;
        for(int i=0;i<=n;i++){
            for(int j=i;j>0;j--){
                arr[j]=arr[j]+arr[j-1];
            }
        }
        return Arrays.asList(arr);
    }
    public static int maxProfit(int[] nums){
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < nums.length; i++) {
            maxCur = Math.max(0, maxCur += nums[i] - nums[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
