import java.util.Arrays;
class Solution {
    private static final int MOD = 1000000007;
    private int findWays(int[] num, int tar) {
        int n = num.length;
        int[] dp = new int[tar + 1];
        dp[0] = num[0] == 0 ? 2 : 1;
        if(num[0] != 0 && num[0] <= tar) dp[num[0]] = 1;
        for(int ind=1; ind<n; ind++)
        {
            int[] newDp = new int[tar + 1];
            for(int target=0; target<=tar; target++)
            {
                int notTaken = dp[target];
                int taken = target >= num[ind] ? dp[target - num[ind]] : 0;
                newDp[target] = (notTaken + taken) % MOD;
            }
            dp = newDp;
        }
        return dp[tar];
    }

    public int countPartitions(int[] arr, int diff) {
        int sum = Arrays.stream(arr).sum();
        if(sum < diff || (sum - diff) % 2 != 0) return 0;
        int target = (sum - diff) / 2;
        return findWays(arr, target);
    }
}