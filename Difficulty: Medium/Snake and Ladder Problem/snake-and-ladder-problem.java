class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        // code here
        int totalCells = n * n;
        int[] board = new int[totalCells + 1];

        for(int i = 0; i < lad.length; i += 2) 
        {
            board[lad[i]] = lad[i + 1];
        }

        for(int i = 0; i < sn.length; i += 2) 
        {
            board[sn[i]] = sn[i + 1];
        }

        boolean[] visited = new boolean[totalCells + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while(!queue.isEmpty()) 
        {
            int[] curr = queue.poll();
            int cell = curr[0];
            int throwsCount = curr[1];

            if(cell == totalCells) 
            {
                return throwsCount;
            }

            for(int dice = 1; dice <= 6; dice++) 
            {
                int nextCell = cell + dice;

                if(nextCell <= totalCells) 
                {
                    int dest = board[nextCell] != 0 ? board[nextCell] : nextCell;

                    if(!visited[dest]) 
                    {
                        visited[dest] = true;
                        queue.offer(new int[]{dest, throwsCount + 1});
                    }
                }
            }
        }

        return -1;
        
    }
}