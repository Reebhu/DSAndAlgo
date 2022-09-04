package recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public static void main(String[] args) {
        int n = 4;
        int[][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        int[][] visited = new int[n][n];
        String direction = "";
        List<String> res = new ArrayList<>();
        solveMaze(m, visited, n, 0, 0, direction, res);
        System.out.println(res);
    }

    private static void solveMaze(int[][] m, int[][] visited, int n, int i, int j, String direction, List<String> res) {
        if (i == n - 1 && j == n - 1) {
            res.add(direction);
            return;
        }
        if (canMoveDown(m, visited, n, i, j) == true) {
            visited[i][j] = 1;
            solveMaze(m, visited, n, i + 1, j, direction + "D", res);
            visited[i][j] = 0;
        }
        if (canMoveRight(m, visited, n, i, j) == true) {
            visited[i][j] = 1;
            solveMaze(m, visited, n, i, j + 1, direction + "R", res);
            visited[i][j] = 0;
        }

        if (canMoveLeft(m, visited, n, i, j) == true) {
            visited[i][j] = 1;
            solveMaze(m, visited, n, i, j - 1, direction + "L", res);
            visited[i][j] = 0;
        }
        if (canMoveUp(m, visited, n, i, j) == true) {
            visited[i][j] = 1;
            solveMaze(m, visited, n, i - 1, j, direction + "U", res);
            visited[i][j] = 0;
        }
        return;
    }

    private static boolean canMoveDown(int[][] m, int[][] visited, int n, int i, int j) {
        return (i == n - 2 && j == n - 1) || i < n - 1 && m[i + 1][j] == 1 && visited[i + 1][j] == 0;
    }

    private static boolean canMoveRight(int[][] m, int[][] visited, int n, int i, int j) {
        return (i == n - 1 && j == n - 2) || j < n - 1 && m[i][j + 1] == 1 && visited[i][j + 1] == 0;
    }

    private static boolean canMoveLeft(int[][] m, int[][] visited, int n, int i, int j) {
        return j > 0 && m[i][j - 1] == 1 && visited[i][j - 1] == 0;
    }

    private static boolean canMoveUp(int[][] m, int[][] visited, int n, int i, int j) {
        return i > 0 && m[i - 1][j] == 1 && visited[i - 1][j] == 0;
    }
}
