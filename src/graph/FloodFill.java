package graph;

import util.Util;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int iniColor = 1;
        int newColor = 2;
        int sc = 2, sr = 2;
        int[][] ans = floodFill(image, iniColor, newColor, sc, sr);

        Util.print2DArray(ans);
    }

    private static int[][] floodFill(int[][] image, int iniColor, int newColor, int sc, int sr) {
        int n = image.length;
        int m = image[0].length;

        int[][] visited =
                Arrays.copyOf(image, image.length);

        if (visited[sc][sr] == iniColor)
            dfs(sc, sr, visited, image, newColor, iniColor);
        return visited;
    }

    private static void dfs(int i, int j, int[][] visited, int[][] image, int newColor, int iniColor) {

        int n = visited.length;
        int m = visited[0].length;
        visited[i][j] = newColor;

        /*
         *            i-1,j
         *     i,j-1  i,j i, j+1
         *            i+1,j
         * */

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for (int move = 0; move < 4; move++) {
            if (i + dr[move] >= 0 && i + dr[move] < n && j + dc[move] >= 0 && j + dc[move] < m &&
                    visited[i + dr[move]][j + dc[move]] == iniColor) {
                dfs(i + dr[move], j + dc[move], visited, image, newColor, iniColor);
            }
        }

    }
}
