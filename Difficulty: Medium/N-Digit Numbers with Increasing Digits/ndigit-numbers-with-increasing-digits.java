class Solution {
    public static void solve(int n, int currentDigit, int currentNum, ArrayList<Integer> ans) {
        if(n == 0)
        {
            ans.add(currentNum);
            return;
        }
        for(int i = currentDigit + 1; i <= 9; i++) {
            solve(n - 1, i, currentNum * 10 + i, ans);
        }
    }
    
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                ans.add(i);
            }
            return ans;
        } else if (n > 9) {
            return ans;
        }
        for (int i = 1; i <= 9; i++) {
            solve(n - 1, i, i, ans);
        }

        return ans;
    }
}