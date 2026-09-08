class Solution {
    public int findMax(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int len = s.length;

        int bestNum = n;
        int bestSum = digitSum(n);

        for(int i = len - 1; i >= 0; i--) {
            if(s[i] == '0') continue;

            char[] temp = s.clone();
            temp[i]--;
            for(int j = i + 1; j < len; j++) {
                temp[j] = '9';
            }

            int cand = Integer.parseInt(new String(temp));
            int sum = digitSum(cand);

            if(sum > bestSum || (sum == bestSum && cand > bestNum)) {
                bestSum = sum;
                bestNum = cand;
            }
        }

        return bestNum;
    }

    private int digitSum(int x) {
        int sum = 0;
        while(x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}