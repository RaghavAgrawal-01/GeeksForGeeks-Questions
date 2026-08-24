import java.util.*;

class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if(mat[r][c] == '#') 
        {
            return 0;
        }

        int[][] minUp = new int[n][m];
        for(int i = 0; i < n; i++) 
        {
            Arrays.fill(minUp[i], Integer.MAX_VALUE);
        }

        boolean[][] visited = new boolean[n][m];
        Deque<int[]> dq = new ArrayDeque<>();

        minUp[r][c] = 0;
        dq.offer(new int[]{r, c});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int count = 0;

        while(!dq.isEmpty()) 
        {
            int[] curr = dq.pollFirst();
            int cr = curr[0];
            int cc = curr[1];

            if(visited[cr][cc]) 
            {
                continue;
            }
            visited[cr][cc] = true;

            int curUp = minUp[cr][cc];
            int curDown = curUp + cr - r;

            if(curUp <= u && curDown <= d) 
            {
                count++;
            }

            for(int i = 0; i < 4; i++) 
            {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == '.') 
                {
                    int nextUp = curUp + (i == 0 ? 1 : 0);
                    int nextDown = nextUp + nr - r;

                    if(nextUp <= u && nextDown <= d && nextUp < minUp[nr][nc]) 
                    {
                        minUp[nr][nc] = nextUp;
                        if(i == 0) 
                        {
                            dq.addLast(new int[]{nr, nc});
                        } 
                        else 
                        {
                            dq.addFirst(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        return count;
    }
}