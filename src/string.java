package src;

import java.util.Scanner;

import common.*;

public class string {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("string");
        int n = input.getNum(in);
        switch(n){
            case 1: // find longest comman prefix
                System.out.println(longestCommonPrefix(input.getStringArr(in)));
                break;
        }
        in.close();
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String prefix = strs[0];
        for(int i=1;i<=strs.length-1;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
