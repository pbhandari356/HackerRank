/*
Given a set, S, of n integers, print the size of a maximal subset, S', of S where the sum of any 2 numbers in S' are not evenly divisible by k.
The first line contains 2 space-separated integers, n and k, respectively. 
The second line contains n space-separated integers (we'll refer to the ith value as a_i) describing the unique values of the set.

Print the size of the largest possible subset (S').

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NonDivisibleSubset {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] val = new int[k];

        for (int i = 0; i < n; i++){
            val[in.nextInt()%k] += 1;
        }
        
        int j = 0;
        int div = 0;
               
        while (j < k/2 + 1) {
            if (j == 0){
                if (val[j]!=0)
                    div += 1;
            } else if (k%2==0 && j == k/2){
                if (val[j]!=0)
                    div += 1;
            } else {
                div += Math.max(val[j], val[k-j]);
            }
            j++;
        }

        System.out.println(div);
    }

}