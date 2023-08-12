package src;

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{	
	public static long[] b = new long[500005];
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		 Scanner sc = new Scanner(System.in);
        long k = 10;
        long n = 4;
        long i = 1;
        while (i <= n) {
            b[(int) i] = sc.nextLong();
            i++;
        }

        long low = 1;
        long answer = -1;
        long high = Long.MAX_VALUE;
        long kv = 0;
        while (low <= high && kv == 0) {
            long mid = (low + high) / 2;
            if (chk(mid, n, k)) {
                if (mid == 1) {
                    kv = 1;
                    answer = 1;
                } else {
                    if (!chk(mid - 1, n, k)) {
                        answer = mid;
                        kv = 1;
                    } else {
                        high = mid - 1;
                    }
                }
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
	}
	public static boolean chk(long gg, long n, long k) {
        

        int i = 1;
        long Tot_k = 0;
        while (i <= n) {
            long ki = sol(gg, b[i]);
            Tot_k += (ki);
            i++;
        }

        return Tot_k >= k;
    }
    public static long sol(long gg, long b1) {
      
        long low = 0;
        long high = 10000000;
        long bb = gg / b1;
        long vv = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            long gg1 = mid * mid - mid + 1;
            if (gg1 <= bb) {
                if (gg1 == bb) {
                    return mid;
                } else {
                    vv = Math.max(vv, mid);
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return vv;
    }
}