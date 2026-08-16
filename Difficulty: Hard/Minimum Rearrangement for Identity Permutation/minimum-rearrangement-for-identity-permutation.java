class Solution {
    int minOperations(int[] b) {
        // code here
        int n = b.length;
        boolean[] visited = new boolean[n];
        Map<Integer, Integer> primeMaxPowers = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            if(!visited[i])
            {
                int curr = i;
                int length = 0;
                while(!visited[curr])
                {
                    visited[curr] = true;
                    curr = b[curr] - 1;
                    length++;
                }
                int temp = length;
                for(int p = 2; p * p <= temp; p++)
                {
                    if(temp % p == 0)
                    {
                        int count = 0;
                        while(temp % p == 0)
                        {
                            count++;
                            temp /= p;
                        }
                        primeMaxPowers.put(p, Math.max(primeMaxPowers.getOrDefault(p, 0), count));
                    }
                }
                if(temp > 1) {
                    primeMaxPowers.put(temp, Math.max(primeMaxPowers.getOrDefault(temp, 0), 1));
                }
            }
        }
        long ans = 1;
        long MOD = 1000000007;
        for(Map.Entry<Integer, Integer> entry : primeMaxPowers.entrySet())
        {
            long base = entry.getKey();
            int exp = entry.getValue();
            for(int j = 0; j < exp; j++)
            {
                ans = (ans * base) % MOD;
            }
        }
        return (int) ans;
    }
};