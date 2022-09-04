package graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionDirectedDFS {
    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> graph = new ArrayList<>(V);

        //Vertex - 0
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        neighbors.add(1);
        graph.add(neighbors);

        //Vertex - 1
        neighbors = new ArrayList<Integer>();
        neighbors.add(2);
        neighbors.add(5);
        graph.add(neighbors);

        //Vertex - 2
        neighbors = new ArrayList<Integer>();
        neighbors.add(3);
        graph.add(neighbors);

        //Vertex - 3
        neighbors = new ArrayList<Integer>();
        neighbors.add(4);
        graph.add(neighbors);

        //Vertex - 4
        neighbors = new ArrayList<Integer>();
        neighbors.add(0);
        neighbors.add(1);
        graph.add(neighbors);

        //Vertex - 5
        neighbors = new ArrayList<Integer>();
        graph.add(neighbors);
        new CycleDetectionDirectedDFS().detectCycle(graph);
    }

    void detectCycle(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size() + 1];
        boolean[] dfsVisited = new boolean[adj.size() + 1];
        for (int i = 1; i < adj.size(); i++) {
            if (!visited[i]) {
                if (isCyclePresentdfs(i, -1, adj, dfsVisited, visited)) {
                    System.out.println("Cycle Detected");
                }
            }
        }
    }

    private boolean isCyclePresentdfs(int value, int parent, List<List<Integer>> adj, boolean[] dfsVisited, boolean[] visited) {
        visited[value] = true;
        dfsVisited[value] = true;
        for (int i : adj.get(value)) {
            if (!visited[i]) {
                if (isCyclePresentdfs(i, value, adj, visited, visited) == true)
                    return true;
            } else if (dfsVisited[i] && visited[i]) {
                System.out.println(i);
                return true;
            }
        }
        dfsVisited[value] = false;
        return false;
    }
}
