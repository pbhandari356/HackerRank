/*
PROBLEM DESCRIPTION FROM HACKERRANK

It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride!
There are  people queued up, and each person wears a sticker indicating their initial position in the queue (i.e.: 1,2,....n-1,n with the first number denoting the frontmost position).
Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions, they still wear the same sticker denoting their original place in line. One person can bribe at most two other persons.
That is to say, if n = 8 and Person 5 and Person 4 bribes , the queue will look like this: 1,2,3,5,4,6,7,8
Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!
Note: Each  wears sticker , meaning they were initially the  person in queue.

Input Format:
The first line contains an integer, T, denoting the number of test cases. 
Each test case is comprised of two lines; the first line has n (an integer indicating the number of people in the queue), and the second line has n space-separated integers describing the final state of the queue.

Output Format

Print an integer denoting the minimum number of bribes needed to get the queue into its final state; print "Too chaotic" if the state is invalid (requires Person X to bribe more than 2 people).
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NewYearChaos {
    public static int result;
    public static boolean chaos = false;
    public static void main(String[] args) {       
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int q[] = new int[n];
            int swap = 0;
            for(int q_i=0; q_i < n; q_i++){
                q[q_i] = in.nextInt();
            }
            int ind = q.length-1;
            int previous = 0;
            setSwap(0);

            /*YOUR CODE HERE*/
            while (ind >= 1 && !chaos) {
                previous = result;
                result = swapCount(ind-1, ind, q, getSwap());                
                if (Math.abs(result-previous) > 2) {
                    chaos = true;
                }
                ind -= 1;
            }            
            if (chaos) 
                System.out.println("Too chaotic");
            else
                System.out.println(getSwap());
            chaos = false;
        }
        
    }
    
    public static int swapCount(int before, int after, int[] q, int swap){      
        if (after <= q.length-1 && q[before] > q[after]) {           
            int temp = q[before];
            q[before] = q[after];
            q[after] = temp;             
            swap++;                          
            before++; after++;           
            setSwap(swap);
            swapCount(before, after, q, getSwap()); //recursively call swap function until all swaps are covered starting from 'before' to 'after'
        }       
        return getSwap();
    }

    public static void setSwap(int r){
         result = r;
    }
    
    public static int getSwap() {
        return result;
    }
        
}
