class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        // code here
        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int x : arr)
        {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for(int i = n - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && freq.get(arr[st.peek()]) <= freq.get(arr[i]))
            {
                st.pop();
            }

            if(st.isEmpty())
            {
                res[i] = -1;
            }
            else
            {
                res[i] = arr[st.peek()];
            }

            st.push(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int x : res)
        {
            ans.add(x);
        }

        return ans;
    }
}