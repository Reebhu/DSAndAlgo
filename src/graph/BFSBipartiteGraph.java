package graph;

import java.util.*;

public class BFSBipartiteGraph {
    public static void main(String[] args) {
        int n = 7;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(4).add(3);
        adj.get(3).add(4);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(4).add(6);
        adj.get(6).add(4);

        adj.get(1).add(6);
        adj.get(6).add(1);


        BFSBipartiteGraph obj = new BFSBipartiteGraph();
        if (obj.checkBipartite(adj, n) == true) System.out.println("Yes Bipartite");
        else System.out.println("Not Bipartite");

    }

    private boolean checkBipartite(List<List<Integer>> adj, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[adj.size() + 1];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                q.offer(i);
                color[i] = 1;
                if (canColorGraph(adj, q, color)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canColorGraph(List<List<Integer>> adj, Queue<Integer> q, int[] color) {
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i : adj.get(node)) {
                if (color[i] == -1) {
                    color[i] = 1 - color[node];
                    q.offer(i);
                } else if (color[i] == color[node]) {
                    System.out.println(i);
                    return false;
                }
            }
        }
        return true;
    }
}
