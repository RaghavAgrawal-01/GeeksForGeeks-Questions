class Solution {
    public int countSpanTree(int n, int[][] edges) {
        if (n == 1) return 1;
        double[][] lap = new double[n][n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            lap[u][u] += 1;
            lap[v][v] += 1;
            lap[u][v] -= 1;
            lap[v][u] -= 1;
        }
        int m = n - 1;
        double[][] mat = new double[m][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                mat[i - 1][j - 1] = lap[i][j];
            }
        }
        return (int) Math.round(determinant(mat));
    }
    private double determinant(double[][] a) {
        int n = a.length;
        double det = 1;
        for (int i = 0; i < n; i++) {
            int pivot = i;
            for (int j = i; j < n; j++) {
                if (Math.abs(a[j][i]) > Math.abs(a[pivot][i])) {
                    pivot = j;
                }
            }
            if (Math.abs(a[pivot][i]) < 1e-9) return 0;
            double[] temp = a[i];
            a[i] = a[pivot];
            a[pivot] = temp;
            if (i != pivot) det *= -1;
            det *= a[i][i];
            for (int j = i + 1; j < n; j++) {
                double factor = a[j][i] / a[i][i];
                for (int k = i; k < n; k++) {
                    a[j][k] -= factor * a[i][k];
                }
            }
        }
        return det;
    }
}