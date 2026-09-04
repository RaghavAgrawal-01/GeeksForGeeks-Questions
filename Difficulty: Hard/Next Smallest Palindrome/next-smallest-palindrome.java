class Solution {
    public ArrayList<Integer> nextPalindrome(int[] num) {
        int n = num.length;
        int[] result = num.clone();

        for(int i = 0; i < n / 2; i++) {
            result[n - 1 - i] = result[i];
        }

        boolean isGreater = false;
        for(int i = 0; i < n; i++) {
            if(result[i] > num[i]) {
                isGreater = true;
                break;
            } else if(result[i] < num[i]) {
                isGreater = false;
                break;
            }
        }

        if(!isGreater) {
            int carry = 1;
            int left = (n - 1) / 2;
            int right = (n % 2 == 0) ? n / 2 : left;

            while(left >= 0) {
                int sum = result[left] + carry;
                result[left] = sum % 10;
                carry = sum / 10;
                result[right] = result[left];
                left--;
                right++;
            }

            if(carry > 0) {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(1);
                for(int i = 0; i < n - 1; i++) {
                    ans.add(0);
                }
                ans.add(1);
                return ans;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int val : result) {
            ans.add(val);
        }
        return ans;
    }
}