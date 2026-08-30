class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        long[] pref = new long[n];

        pref[0] = (long) r[0] - l[0] + 1;
        for(int i = 1; i < n; i++) 
        {
            pref[i] = pref[i - 1] + ((long) r[i] - l[i] + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int k : rank) 
        {
            int low = 0;
            int high = n - 1;
            int idx = n - 1;

            while(low <= high) 
            {
                int mid = low + (high - low) / 2;

                if(pref[mid] >= k) 
                {
                    idx = mid;
                    high = mid - 1;
                } 
                else 
                {
                    low = mid + 1;
                }
            }

            long prevCount = idx > 0 ? pref[idx - 1] : 0;
            long offset = k - prevCount - 1;
            int mark = (int) (l[idx] + offset);

            result.add(mark);
        }

        return result;
    }
}