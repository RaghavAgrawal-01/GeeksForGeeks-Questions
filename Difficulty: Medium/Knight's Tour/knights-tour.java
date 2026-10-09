class Solution {
    int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(-1);
            }
            board.add(row);
        }

        board.get(0).set(0, 0);

        if (solve(0, 0, 1, n, board)) {
            return board;
        }

        return new ArrayList<>();
    }

    boolean solve(int x, int y, int step, int n,
                  ArrayList<ArrayList<Integer>> board) {
        if (step == n * n) {
            return true;
        }

        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (isSafe(nx, ny, n, board)) {
                board.get(nx).set(ny, step);

                if (solve(nx, ny, step + 1, n, board)) {
                    return true;
                }

                board.get(nx).set(ny, -1);
            }
        }

        return false;
    }

    boolean isSafe(int x, int y, int n,
                   ArrayList<ArrayList<Integer>> board) {
        return x >= 0 && x < n &&
               y >= 0 && y < n &&
               board.get(x).get(y) == -1;
    }
}