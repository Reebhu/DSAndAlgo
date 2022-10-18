package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};

        int ans = new RottenOranges().orangesRotting(grid);
        System.out.println(ans);
    }

    private int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        visited = Arrays.copyOf(grid, n);
        Queue<Triplet> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    Triplet rottenOrange = new Triplet(i, j, 0);
                    q.offer(rottenOrange);
                }
            }
        }
        return bfs(visited, q, n, m);
    }

    private int bfs(int[][] visited, Queue<Triplet> q, int n, int m) {
        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, 1, -1, 0};
        int maxTime = -1;
        while (!q.isEmpty()) {
            Triplet orange = q.poll();
            for (int i = 0; i < 4; i++) {
                int row = orange.x + dr[i];
                int col = orange.y + dc[i];
                int time = orange.time;
                maxTime = Math.max(maxTime, time);
                if (row >= 0 && row < n && col >= 0 && col < m && visited[row][col] == 1) {
                    visited[row][col] = 2;
                    Triplet rottenNewOrange = new Triplet(row, col, time + 1);
                    q.offer(rottenNewOrange);
                }
            }
        }
        return maxTime;
    }

    class Triplet {
        int x;
        int y;
        int time;

        Triplet(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
