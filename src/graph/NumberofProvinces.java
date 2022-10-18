package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberofProvinces {
    public static void main(String[] args) {
        // adjacency matrix
        int[][] adj = {{1, 0}, {0, 1}};

        System.out.println(new NumberofProvinces().numProvinces(adj, 3));
    }

    public int numProvinces(int[][] adj, int V) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<Integer>());
        }

        // to change adjacency matrix to list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // self nodes are not considered
                if (adj[i][j] == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                q.offer(i);
                bfs(q, visited, adjLs);

            }
        }
        return count;
    }

    private void bfs(Queue<Integer> q, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        while (!q.isEmpty()) {
            int value = q.poll();
            for (Integer neighbour : adj.get(value)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.offer(neighbour);
                }
            }
        }
    }
}
