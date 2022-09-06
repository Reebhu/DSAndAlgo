package dp;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        // int[][]arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int n = arr.length;
        int m = arr[0].length;
        int[][] out = setMatrixZero(arr, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(out[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] setMatrixZero(int[][] arr, int n, int m) {
        boolean isColZero = false;
        for(int i = 0; i< n; i++) {
            if(arr[i][0]==0)
                isColZero = true;
            for(int j=0; j<m; j++) {
                if(arr[i][j]==0) {
                    arr[i][0]= arr[0][j]=0;
                }
            }
        }
//        for(int i=0;i< n;i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }

        for(int i =n-1; i>=0 ; i--) {
            for (int j = m-1; j >=1; j--) {
                if(arr[i][0]==0 || arr[0][j]==0) {
                    arr[i][j]=0;
                }
            }
            if(isColZero) {
                arr[i][0]=0;
            }
        }
        return arr;
    }

}
