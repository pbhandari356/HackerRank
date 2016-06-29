/*You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they're all the same height, then print the height. The removals must be performed in in such a way as to maximize the height.

Note: An empty stack is still a stack.

Input Format

The first line contains three space-separated integers, n1, n2, and n3, describing the respective number of cylinders in stacks 1, 2, and 3. The subsequent lines describe the respective heights of each cylinder in a stack from top to bottom:

The second line contains n1 space-separated integers describing the cylinder heights in stack 1.
The third line contains n2 space-separated integers describing the cylinder heights in stack 2.
The fourth line contains n3 space-separated integers describing the cylinder heights in stack 3.
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EqualStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
        }
        
        //CODE STARTS HERE
        int i = 0; int j = 0; int k=0;
        
        int min = Math.min(Math.min(h_1,h_2),h_3);
        int height = 0;
        
        while (height == 0 && i!=n1 && j!=n2 && k!=n3) {
            
            if (h_1 == h_2 && h_2 == h_3) {
                height = h_1;
            }
            
            if (h_1 > min && n1 != 0) {
                h_1 -= h1[i];
                i++;
            }
            if (h_2 > min  && n2 != 0) {
                h_2 -= h2[j];
                j++;
            }
            if (h_3 > min && n3 != 0) {
                h_3 -= h3[k];
                k++;
            }
            
            min = Math.min(Math.min(h_1,h_2),h_3);
        
        }            
            System.out.println(height);
    }
}
