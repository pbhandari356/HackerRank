/*
Given an array  of  elements, find the maximum possible sum of a:
- Contiguous subarray
- Non-contiguous (not necessarily contiguous) subarray.

Empty subarrays/subsequences should not be considered.

Input Format

First line of the input has an integer T. T cases follow. 
Each test case begins with an integer N. In the next line, N integers follow representing the elements of array .

Output Format

Two, space separated, integers denoting the maximum contiguous and non-contiguous subarray. 
At least one integer should be selected and put into the subarrays (this may be required in cases where all elements are negative).

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaximumSubarray {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            int non_contiguous = 0;
            int min = Integer.MIN_VALUE;
                          
            for (int j = 0; j < size; j++) {
                arr[j] = sc.nextInt();
                if (arr[j] < 0 && min < arr[j]) {
                    min = arr[j]; 
                }
                
                if (arr[j] > 0)
                    non_contiguous += arr[j];
            }
            
            int sum = maxSum(arr, 0, size-1);               
            if (non_contiguous == 0) {
                non_contiguous = min; 
                sum = min;
            }
            System.out.println(sum + " " + non_contiguous);
        }
    }
    //DIVIDE and CONQUER APPROACH 
    public static int maxSum(int[] arr, int low, int high) {
        if (low == high)
            return arr[low];

        int middle = (low+high)/2;

        return max(maxSum(arr,low,middle), maxSum(arr,middle+1,high), maxCrossSum(arr,low,middle,high));
    }

    public static int max(int a, int b) {
        return (a > b)? a : b; 
    }

    public static int max(int a, int b, int c) {
        return max(max(a,b), c); 
    }

    public static int maxCrossSum(int[] arr, int low, int middle, int high) {
            
            int current_sum = 0;            
            int left_max_sum = 0;
            int right_max_sum = 0;
            
            for (int i=middle; i >= low; i--) {
                current_sum += arr[i];
                if (left_max_sum < current_sum)
                    left_max_sum = current_sum;
            }
            
            current_sum = 0;            

            for (int j=middle+1; j <= high; j++) {
                current_sum += arr[j];
                if (right_max_sum < current_sum)
                    right_max_sum = current_sum;
            }

            return  left_max_sum+right_max_sum;

    }

       
        
        /*NAIVE APPROACH
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int size = sc.nextInt();            


            int non_contiguous = 0;
            int current_sum = 0;            
            int max_sum = 0;
            int min = Integer.MIN_VALUE;
            for (int j=0; j < size; j++) {
                int value = sc.nextInt();                
                if (value < 0 && min < value) {
                    min = value; 
                }                                 
                current_sum += value;                  
                if (current_sum < 0) {
                    current_sum = 0;
                } else if (max_sum < current_sum) {
                    max_sum = current_sum;
                }
                if (value > 0) {
                    non_contiguous += value;
                }                                   
            }
            if (non_contiguous <= 0 &&  max_sum <= 0)
                System.out.println(min + " " + min);
            else 
                System.out.println(max_sum + " " + non_contiguous);
        }
    }
        */
    }

