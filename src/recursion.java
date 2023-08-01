package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import common.*;

public class recursion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        qList.getQList("math");
        int n = input.getNum(in);
        switch(n){
            case 1: // find combinations
                System.out.println(combine(input.getNum(in)));
                break;
        }
        in.close();
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(1,n,k,new ArrayList<Integer>(),result);
        return result;
    }
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////
    private static void generateCombinations(int start, int n, int k, List<Integer> combination, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            combination.add(i);
            generateCombinations(i + 1, n, k - 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
