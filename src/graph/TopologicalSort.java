package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = 6;
        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            adj.add(arr);
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        System.out.println(topologicalSort(adj));
    }

    static List<Integer> topologicalSort(List<List<Integer>> adjList) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adjList.size() + 1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited, stack);
            }
        }
        while (!stack.empty()) {
            res.add(stack.pop());
        }
        return res;
    }

    private static void dfs(int node, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int j : adjList.get(node)) {
            if (!visited[j]) {
                dfs(j, adjList, visited, stack);
            }
        }
        stack.push(node);
    }
}
