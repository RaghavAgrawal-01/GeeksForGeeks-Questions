class Solution {
    public int largestSumCycle(int[] edge) {
        int n = edge.length;
        int[] visited = new int[n];
        int maxSum = -1;

        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                int curr = i;
                int step = 1;

                while(curr != -1) {
                    if(visited[curr] == 0) {
                        visited[curr] = step;
                        curr = edge[curr];
                        step++;
                    } else if(visited[curr] > 0) {
                        int cycleSum = 0;
                        int startNode = curr;
                        int temp = curr;

                        do {
                            cycleSum += temp;
                            temp = edge[temp];
                        } while(temp != startNode);

                        maxSum = Math.max(maxSum, cycleSum);
                        break;
                    } else {
                        break;
                    }
                }

                curr = i;
                while(curr != -1 && visited[curr] > 0) {
                    int next = edge[curr];
                    visited[curr] = -1;
                    curr = next;
                }
            }
        }

        return maxSum;
    }
}