package graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionDFS {
    public static void main(String[] args) {
        int V = 11;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++)
            adj.add(i, new ArrayList<Integer>());
        adj.get(1).add(2);
        adj.get(2).add(4);
        adj.get(2).add(1);
        adj.get(4).add(2);

        adj.get(3).add(5);
        adj.get(5).add(10);
        adj.get(5).add(6);
        adj.get(5).add(3);
        adj.get(6).add(7);
        adj.get(6).add(5);
        adj.get(7).add(6);
        adj.get(7).add(8);
        adj.get(10).add(5);
        adj.get(10).add(9);
        adj.get(9).add(10);
        adj.get(9).add(8);
        adj.get(8).add(9);
        adj.get(8).add(7);
        adj.get(8).add(11);
        adj.get(11).add(8);
        System.out.println(adj);

        new CycleDetectionDFS().detectCycle(adj);

    }

    void detectCycle(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size() + 1];
        for (int i = 1; i < adj.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (isCyclePresentdfs(i, -1, adj, visited)) {
                    System.out.println(i);
                }
            }
        }
    }

    private boolean isCyclePresentdfs(int value, int parent, List<List<Integer>> adj, boolean[] visited) {

        for (int i : adj.get(value)) {
            if (!visited[i]) {
                visited[i] = true;
                if (isCyclePresentdfs(i, value, adj, visited) == true)
                    return true;
            } else if (i != parent) {
                System.out.println(i);
                return true;
            }
        }
        return false;
    }

    class Node {
        int data;
        int prev;

        Node(int data, int prev) {
            this.data = data;
            this.prev = prev;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Node{");
            sb.append("data=").append(data);
            sb.append(", prev=").append(prev);
            sb.append('}');
            return sb.toString();
        }
    }
}
