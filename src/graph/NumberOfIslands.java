package graph;

public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 0}
        };
        System.out.println(findNumberOfIslands(grid, grid.length, grid[0].length));
    }

    static int findNumberOfIslands(int[][] arr, int n, int m) {
        int count = 0;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && arr[i][j] == 1) {
                    count++;
                    dfs(i, j, visited, arr);
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, int[][] visited, int[][] arr) {
        visited[i][j] = 1;
        int n = arr.length;
        int m = arr[0].length;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (i + dr >= 0 && i + dr < n && j + dc >= 0 && j + dc < m && visited[i + dr][j + dc] == 0 && arr[i + dr][j + dc] == 1) {
                    dfs(i + dr, j + dc, visited, arr);
                }
            }
        }
    }
}
