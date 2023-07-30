package src;

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
}
