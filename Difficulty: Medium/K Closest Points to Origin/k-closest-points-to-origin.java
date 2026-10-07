import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a)));
        
        for (int[] pt : points) {
            pq.add(pt);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] pt = pq.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(pt[0]);
            temp.add(pt[1]);
            ans.add(temp);
        }
        return ans;
    }
    
    int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
