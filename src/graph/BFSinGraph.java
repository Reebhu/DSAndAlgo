package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSinGraph {
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
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= adjacencyList.size(); i++) {
            if (!visited[i]) {
                q.offer(i);
                visited[i] = true;
                bfs(adjacencyList, visited, q);
            }
        }
    }

    private static void bfs(List<List<Integer>> adjacencyList, boolean[] visited, Queue<Integer> q) {
        while (!q.isEmpty()) {
            int i = q.poll();
            System.out.println(i);
            for (int j : adjacencyList.get(i - 1)) {
                if (!visited[j]) {
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}
