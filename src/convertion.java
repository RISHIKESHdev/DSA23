package src;

import java.util.Scanner;

import common.*;

public class convertion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("convert");
        int n = input.getNum(in);
        switch(n){
            case 1: // roman to integer
                System.out.println(romanToInt(input.getString(in)));
                break;
        }
        in.close();
    }
    public static int romanToInt(String ss){
        int ans=0,prev=0,num=0;
        for(int i=ss.length()-1;i>=0;i--){
            switch(ss.charAt(i)){
                case 'I':num=1; break;
                case 'V':num=5; break;
                case 'X':num=10; break;
                case 'L':num=50; break;
                case 'C':num=100; break;
                case 'D':num=500; break;
                case 'M':num=1000; break;
            }
            if(num<prev) ans=ans-num;
            else ans=ans+num;
            prev = num;
        }
        return ans;
    }
}
