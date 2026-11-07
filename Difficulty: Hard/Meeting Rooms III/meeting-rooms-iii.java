// User function Template for Java
class Solution {
    public int mostBooked(int n, int[][] A) {
        int[] cnt = new int[n];
        PriorityQueue<int[]> occ = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> avail = new PriorityQueue<>();
        for(int i = 0; i < n; i++) avail.offer(i);
        Arrays.sort(A, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        for(int[] m : A)
        {
            int s = m[0], e = m[1];
            while(!occ.isEmpty() && occ.peek()[0] <= s) avail.offer(occ.poll()[1]);
            if(!avail.isEmpty())
            {
                int r = avail.poll();
                occ.offer(new int[]{e, r});
                cnt[r]++;
            }
            else {
                int[] t = occ.poll();
                occ.offer(new int[]{t[0] + e - s, t[1]});
                cnt[t[1]]++;
            }
        }
        int res = 0;
        for(int i = 1; i < n; i++) if (cnt[i] > cnt[res]) res = i;
        return res;
    }
}