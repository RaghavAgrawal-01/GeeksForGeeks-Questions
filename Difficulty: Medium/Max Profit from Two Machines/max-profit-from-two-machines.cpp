class Solution {
public:
    int maxProfit(int x, int y, vector<int>& a, vector<int>& b) {
        int n = a.size();
        long long totalProfit = 0;

        vector<int> diff(n);
        for(int i = 0; i < n; ++i) {
            totalProfit += b[i];
            diff[i] = a[i] - b[i];
        }

        sort(diff.rbegin(), diff.rend());

        int minA = max(0, n - y);
        int maxA = min(n, x);

        for(int i = 0; i < minA; ++i) {
            totalProfit += diff[i];
        }

        for(int i = minA; i < maxA; ++i) {
            if(diff[i] > 0) {
                totalProfit += diff[i];
            } else {
                break;
            }
        }

        return totalProfit;
    }
};