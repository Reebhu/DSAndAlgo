package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSofGraph {
    public static void main(String[] args) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        List<Integer> node = new ArrayList<>();
        node.add(2);
        node.add(3);
        adjacencyList.add(node);
        node = new ArrayList<>();
        node.add(1);
        node.add(4);
        adjacencyList.add(node);

        node = new ArrayList<>();
        node.add(1);
        node.add(4);
        node.add(5);
        adjacencyList.add(node);

        node = new ArrayList<>();
        node.add(2);
        node.add(3);
        node.add(5);
        adjacencyList.add(node);

        node = new ArrayList<>();
        node.add(3);
        node.add(4);
        adjacencyList.add(node);

        node = new ArrayList<>();
        node.add(7);
        adjacencyList.add(node);

        node = new ArrayList<>();
        node.add(6);
        adjacencyList.add(node);
        boolean[] visited = new boolean[adjacencyList.size() + 1];
        traverseGraph(adjacencyList, visited);
    }

    static void traverseGraph(List<List<Integer>> adjacencyList, boolean[] visited) {
        for (int i = 1; i <= adjacencyList.size(); i++) {
            Queue<Integer> q = new LinkedList<>();
            if (!visited[i]) {
                q.add(i);
                visited[i] = true;
                dfs(i, adjacencyList, visited, q);
            }
        }
    }

    private static void dfs(int node, List<List<Integer>> adjacencyList, boolean[] visited, Queue<Integer> q) {
        System.out.println(node);
        for (int j : adjacencyList.get(node - 1)) {
            if (!visited[j]) {
                visited[j] = true;
                dfs(j, adjacencyList, visited, q);
            }
        }
    }
}
