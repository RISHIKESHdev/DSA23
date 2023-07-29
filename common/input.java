package common;

import java.util.Arrays;
import java.util.Scanner;

public class input {
    public static int getNum(Scanner in){
        System.out.print("Enter an Integer value: ");
        int n=in.nextInt();
        return n;
    }
    public static int[] getNumArr(Scanner in){
        System.out.print("Enter Array size: ");
        int n=in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=getNum(in);
        }
        System.out.print("Array: ");
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static String getString(Scanner in){
        System.out.print("Enter a String value: ");
        String ss = in.next();
        return ss;
    }
    public static String[] getStringArr(Scanner in){
        System.out.print("Enter Array size: ");
        int n=in.nextInt();
        String arr[] = new String[n];
        for(int i=0;i<n;i++){
            arr[i]=getString(in);
        }
        System.out.print("Array: ");
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static int[] getNumArrAsen(Scanner in){
        System.out.print("Enter Array size: ");
        int n=in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=getNum(in);
        }
        Arrays.sort(arr);
        System.out.print("Array: ");
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
