class Solution {
    public int minComputation(int[] files) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int f : files) {
            pq.add(f);
        }

        int totalCost = 0;
        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int cost = first + second;
            totalCost += cost;
            pq.add(cost);
        }

        return totalCost;
    }
}