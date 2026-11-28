class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int[][] jobs = new int[n][2];
        for(int i = 0; i < n; i++) {
            jobs[i][0] = deadline[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            int d = jobs[i][0];
            int p = jobs[i][1];
            minHeap.offer(p);
            if(minHeap.size() > d) {
                minHeap.poll();
            }
        }

        int count = minHeap.size();
        int totalProfit = 0;
        while(!minHeap.isEmpty()) {
            totalProfit += minHeap.poll();
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(totalProfit);
        return ans;
    }
}