class Solution {
private:
    double determinant(vector<vector<double>>& mat, int n) {
        double det = 1.0;
        const double EPS = 1e-9;

        for(int i = 0; i < n; ++i) {
            int pivot = i;
            for(int j = i + 1; j < n; ++j) {
                if(abs(mat[j][i]) > abs(mat[pivot][i])) {
                    pivot = j;
                }
            }

            if(abs(mat[pivot][i]) < EPS) return 0.0;

            if(i != pivot) {
                swap(mat[i], mat[pivot]);
                det = -det;
            }

            det *= mat[i][i];

            for(int j = i + 1; j < n; ++j) {
                double factor = mat[j][i] / mat[i][i];
                for(int k = i; k < n; ++k) {
                    mat[j][k] -= factor * mat[i][k];
                }
            }
        }
        return det;
    }

public:
    int countSpanTree(int n, vector<vector<int>>& edges) {
        if(n <= 1) return 1;

        vector<vector<double>> laplacian(n, vector<double>(n, 0.0));
        for(const auto& edge : edges) {
            int u = edge[0];
            int v = edge[1];
            laplacian[u][u] += 1.0;
            laplacian[v][v] += 1.0;
            laplacian[u][v] -= 1.0;
            laplacian[v][u] -= 1.0;
        }

        vector<vector<double>> submatrix(n - 1, vector<double>(n - 1, 0.0));
        for(int i = 1; i < n; ++i) {
            for(int j = 1; j < n; ++j) {
                submatrix[i - 1][j - 1] = laplacian[i][j];
            }
        }

        double totalTrees = determinant(submatrix, n - 1);
        return static_cast<int>(round(totalTrees));
    }
};