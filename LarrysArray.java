/*
Larry has a permutation of N numbers, A, whose unique elements range from 1 to N . He wants A to be sorted, so he delegates the task of doing so to his robot. The robot can perform the following operation as many times as it wants:

- Choose any 3 consecutive indices and rotate their elements in such a way that ABC rotates to BCA, which rotates to CAB, which rotates back to ABC.
  For example: if {1,6,5,2,4,3} and the robot rotates (6,5,2), A becomes {1,5,2,6,4,3}.

On a new line for each test case, print  if the robot can fully sort ; otherwise, print .

Input Format:

The first line contains an integer, T , the number of test cases. 
The 2T subsequent lines each describe a test case over 2 lines:
- An integer, N , denoting the size of A.
- N space-separated integers describing A, where the ith value describes element ai.

Output Format:

On a new line for each test case, print YES if the robot can fully sort A; otherwise, print NO.
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LarrysArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i=0; i < cases; i++) {
            int l = sc.nextInt();
            int[] arr = new int[l];
            for (int arr_i=0; arr_i < l; arr_i++) {
                arr[arr_i] = sc.nextInt(); 
            }

            int inversion = 0;
            for (int x = 0; x < arr.length; x++) {
                for (int j = x+1; j < arr.length; j++) {
                    if (arr[x] > arr[j])
                        inversion++;
                }
            }  
            
            if (inversion%2 == 0)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
}