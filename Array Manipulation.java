/*
* you can see the problem on this link https://www.hackerrank.com/challenges/crush/problem
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int [] niz = new int[n+1];
        Arrays.fill(niz, 0);
        long maks = 0;
        long count = 0;
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            niz[a]+=k;
            if(b!=n){
                niz[b+1]-=k;
            }


        }

        for (int i=0; i<n+1; i++){
            count+=niz[i];
            if(maks<count){
                maks=count;
            }
        }
        System.out.println(maks);
        in.close();
    }
}