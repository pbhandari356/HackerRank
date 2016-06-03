/* FROM HACKERRANK 
Atul is into graph theory, and he is learning about trees nowadays. He observed that the removal of an edge from a given tree T will result in the formation of two separate trees, T1 and T2.
Each vertex of the tree T is assigned a positive integer. Your task is to remove an edge, such that the Tree_diff of the resultant trees is minimized. Tree_diff is defined as the following:

Input Format: 
The first line will contain an integer N, i.e. the number of vertices in the tree.
The next line will contain N integers separated by a single space, i.e. the values assigned to each of the vertices (where the first one is the root of the tree).
The next N-1 lines contain a pair of integers each, separated by a single space, that denote the edges of the tree.
In the above input, the vertices are numbered from 1 to N.

Output Format: 
A single line containing the minimum value of Tree_diff.

Constraints:
C <= N <= 10^5
1 <= number written on each vertex <= 1001

*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CutTheTree {
    private static int[] value;
    private static boolean[] visited;
    private static int[] parent;
    private static Map<Integer, List<Integer>> tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int min = Integer.MAX_VALUE;
        value = new int[vertex];
        parent = new int[vertex];
        visited = new boolean[vertex];
        

        for (int i = 0; i < vertex; i++) {
            int temp = sc.nextInt();
            value[i] = temp;
        }

        tree = new HashMap<Integer, List<Integer>>();
        for (int j = 0; j < vertex-1;j++) {
            int f = sc.nextInt()-1;
            int s = sc.nextInt()-1;
            if (!tree.containsKey(f))
                tree.put(f, new ArrayList<Integer>());
            tree.get(f).add(s);
            if (!tree.containsKey(s))
                tree.put(s, new ArrayList<Integer>());
            tree.get(s).add(f);
        }

        dfs(0);
        visited = new boolean[vertex];    
        for (int k : tree.keySet()) {
            List<Integer> edge = tree.get(k);
            for (int e : edge) {
                int v = Math.abs(value[0] - value[e] - value[e]);
                min = parent[e] == k && min > v ? v : min; 
            }
        }
        
        System.out.println(min);
    }

    private static int dfs(int n) {
        visited[n] = true;
        List<Integer> edge = tree.get(n);
        for (int e : edge) {
            if (!visited[e]) {
                parent[e] = n;
                value[n] = value[n] + dfs(e);
            }
        }
        return value[n];
    }

}