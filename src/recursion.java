package src;

import java.util.ArrayList;
import java.util.Scanner;

import common.*;

public class recursion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("math");
        int n = input.getNum(in);
        switch(n){
            case 1: // find combinations
                System.out.println(combine(input.getNum(in),input.getNum(in)));
                break;
        }
        in.close();
    }
    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        generateCombinations(1,n,k,new ArrayList<Integer>(),result);
        return result;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    private static void generateCombinations(int start, int n, int k, ArrayList<Integer> combination, ArrayList<ArrayList<Integer>> result) {
        if (k == 0) {
            result.add(combination);
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            combination.add(i);
            generateCombinations(i + 1, n, k - 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
