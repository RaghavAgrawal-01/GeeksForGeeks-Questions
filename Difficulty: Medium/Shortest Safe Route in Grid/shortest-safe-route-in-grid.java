class Solution {
    public int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] safe = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                safe[i][j] = 1;
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    safe[i][j] = 0;
                    for(int d = 0; d < 4; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];
                        if(ni >= 0 && ni < n && nj >= 0 && nj < m) {
                            safe[ni][nj] = 0;
                        }
                    }
                }
            }
        }

        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            java.util.Arrays.fill(dist[i], -1);
            if(safe[i][0] == 1) {
                q.add(new int[]{i, 0});
                dist[i][0] = 1;
            }
        }

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = dist[r][c];

            if(c == m - 1) return d;

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && safe[nr][nc] == 1 && dist[nr][nc] == -1) {
                    dist[nr][nc] = d + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}