package src;

import java.util.Scanner;

import common.*;
import helper.TrieNodeChar;

public class trie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("trie");
        int n = input.getNum(in);
        switch(n){
            case 1: // find longest comman prefix
                System.out.println(longestCommonPrefix(input.getStringArr(in)));
                break;
        }
        in.close();
    }
    public static String longestCommonPrefix(String[] arr){
        StringBuilder ans = new StringBuilder();
        TrieNodeChar root = new TrieNodeChar();
        for(int i=0;i<arr.length;i++){
            TrieNodeChar curr =root;
            for(int j=0;j<arr[i].length();j++){
                if(curr.character[arr[i].charAt(j)-'a']==null){
                    TrieNodeChar toAdd = new TrieNodeChar();
                    curr.character[arr[i].charAt(j)-'a'] = toAdd;
                }
                curr = curr.character[arr[i].charAt(j)-'a'];
                curr.prefixCount++;
            }
            curr.isEndOfWord=true;
        }
        for(int i=0;i<arr[0].length();i++){
            if(root.character[arr[0].charAt(i)-'a'].prefixCount==arr.length){
                ans.append(arr[0].charAt(i));
                root= root.character[arr[0].charAt(i)-'a'];
            }else break;
        }
        return String.valueOf(ans);
    }
}
