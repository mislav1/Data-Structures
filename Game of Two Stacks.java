/*
* you can see the problem on this link https://www.hackerrank.com/challenges/game-of-two-stacks/problem
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int calculate (int n, int m, int x, int[] a, int[] b){

        int counter = 0;
        long[] sum1 = new long[a.length];
        long[] sum2 = new long[b.length];
        long zbroj1 = 0;
        long zbroj2 = 0;

        for (int i = 0; i < sum1.length; i++){
            zbroj1 += a[i];
            sum1[i] = zbroj1;

        }
        for (int i = 0; i < sum2.length; i++){
            zbroj2 += b[i];
            sum2[i] = zbroj2;

        }
        /*System.out.println(Arrays.toString(sum1));
        System.out.println(Arrays.toString(sum2));*/

        if (sum1[0] > x){
            int maks = binarno(sum2, x, 0);
            if (maks > counter){
                counter =  maks;
            }
        }else {
            for (int i = 0; i < sum1.length; i++){
                if (sum1[i] > x){
                    break;
                }
                int maks = i + binarno(sum2, x, sum1[i]) + 1;
                if (maks > counter){
                    counter = maks;
                    /*System.out.println(i);
                    System.out.println(binarno(sum2, x, sum1[i]));*/
                }
            }
        }
        if (sum2[0] > x){
            int maks = binarno(sum1, x, 0);
            if (maks > counter){
                counter = maks;
            }

        }else {
            for (int i = 0; i < sum2.length; i++){
                if (sum2[i] > x){
                    break;
                }
                int maks = i + binarno(sum1, x, sum2[i]) + 1;
                if (maks > counter){
                    counter = maks;
                    /*System.out.println(i);
                    System.out.println(binarno(sum1, x, sum2[i]));*/
                }
            }
        }


        return counter;
    }

    public static int binarno (long[] sum2, int x, long pocetnaVrijednost){
        long value = x - pocetnaVrijednost;
        int lo = 0;
        int hi = sum2.length - 1;

        while (lo < hi){
            int mid = lo + (hi-lo+1) / 2;
            if (sum2[mid] > value){
                hi = mid - 1;
            }else {
                lo = mid;
            }
        }
        if (lo > 0){
            return lo + 1;
        }
        return lo;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] b = new int[m];
            for(int b_i=0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
            }


            System.out.println(calculate(n,m,x,a,b));
        }
    }
}