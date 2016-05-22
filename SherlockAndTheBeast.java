/*
Sherlock Holmes suspects his archenemy, Professor Moriarty, is once again plotting something diabolical. Sherlock's companion, 
Dr. Watson, suggests Moriarty may be responsible for MI6's recent issues with their supercomputer, The Beast.

Shortly after resolving to investigate, Sherlock receives a note from Moriarty boasting about infecting The Beast with a virus; 
however, he also gives him a clue—a number, N. Sherlock determines the key to removing the virus is to find the largest Decent Number having N digits.

A Decent Number has the following properties:
- Its digits can only be 3's and/or 5's.
- The number of 3's it contains is divisible by 5.
- The number of 5's it contains is divisible by 3.
- If there are more than one such number, we pick the largest one.

Moriarty's virus shows a clock counting down to The Beast's destruction, and time is running out fast. Your task is to help Sherlock find the key before The Beast is destroyed!

*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockAndTheBeast {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int m = n;
            while (m%3 != 0) {
                m-=5;
            }
            if (m < 0) {
                System.out.println(-1);
            }    
            else {
                for (int i = 0; i < m; i++)
                    System.out.print(5);
                for (int j = 0; j < (n-m); j++)
                    System.out.print(3);
                System.out.println("");
            }
        }        
            
        
    }
     
}
