class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == word.charAt(0)) {
                    if(search(mat, word, i, j, dx, dy)) {
                        ArrayList<Integer> pos = new ArrayList<>();
                        pos.add(i);
                        pos.add(j);
                        ans.add(pos);
                    }
                }
            }
        }

        return ans;
    }

    private boolean search(char[][] mat, String word, int r, int c, int[] dx, int[] dy) {
        int n = mat.length;
        int m = mat[0].length;
        int len = word.length();

        if(len == 1) return true;

        for(int dir = 0; dir < 8; dir++) {
            int cr = r + dx[dir];
            int cc = c + dy[dir];
            int k = 1;

            while(k < len) {
                if(cr < 0 || cr >= n || cc < 0 || cc >= m || mat[cr][cc] != word.charAt(k)) {
                    break;
                }
                cr += dx[dir];
                cc += dy[dir];
                k++;
            }

            if(k == len) {
                return true;
            }
        }

        return false;
    }
}