/* PROBLEM DESCRIPTION FROM HACKERRANK
Given a graph which consists of several edges connecting the N nodes in it. 
It is required to find a subgraph of the given graph with the following properties:
- The subgraph contains all the nodes present in the original graph.
- The subgraph is of minimum overall weight (sum of all edges) among all such subgraphs.
- It is also required that there is exactly one, exclusive path between any two nodes of the subgraph.

One specific node S is fixed as the starting point of finding the subgraph. 
Find the total weight of such a subgraph (sum of all edges in the subgraph)

Input Format:
First line has two integers N, denoting the number of nodes in the graph and M, denoting the number of edges in the graph.
The next M lines each consist of three space separated integers x y r, where x and y denote the two nodes between which the undirected edge exists,  denotes the length of edge between the corresponding nodes.
The last line has an integer S, denoting the starting node.

Constraints:
2 <= N <= 3000
1 <= M <= (N * (N-1))/2
1 <= x,y,S <= N
0 <= r <= 10^5
If there are edges between the same pair of nodes with different weights, they are to be considered as is, like multiple edges.

Output Format:
Print a single integer denoting the total weight of tree so obtained (sum of weight of edges).
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PrimMST {

    public static class Tuple implements Comparable<Tuple> {
        private int x;
        private int weight;

        public Tuple(int x, int weight) {
            this.x = x;
            this.weight = weight;
        }

        @Override
        public int compareTo(Tuple o) {
            return (this.weight - o.weight  < 0 ? -1 : 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        int edges = sc.nextInt();
        int cost = 0;

        Set<Integer> visited = new HashSet<Integer>();
        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>();
        Map<Integer, ArrayList<Tuple>> graph = new HashMap<Integer, ArrayList<Tuple>>();

        for (int e = 0; e < edges; e++) {
            int f = sc.nextInt();
            int s = sc.nextInt();
            int weight = sc.nextInt();
            Tuple f1 = new Tuple(s,weight);
            Tuple s1 = new Tuple(f,weight);
            if (!graph.containsKey(f))
                graph.put(f, new ArrayList<Tuple>());
            if (!graph.containsKey(s))
                graph.put(s, new ArrayList<Tuple>());
            graph.get(f).add(f1);
            graph.get(s).add(s1);
        }

        int start = sc.nextInt();
        visited.add(start);

        for (Tuple t : graph.get(start)) {
            queue.add(t);
        }

        while (visited.size() != node) {
            Tuple next = queue.poll();
            if (!visited.contains(next.x)) {
                visited.add(next.x);
                cost += next.weight;
                for (Tuple t : graph.get(next.x)) {
                    queue.add(t);
                }
            }
        }

        System.out.println(cost);
    }
}