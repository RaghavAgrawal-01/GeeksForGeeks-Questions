class Solution {
    static ArrayList<Integer> minMaxCandy(int arr[], int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;

        int minCost = 0;
        while (i <= j) {
            minCost += arr[i];
            j -= k;
            i++;
        }
        ans.add(minCost);

        i = 0;
        j = arr.length - 1;
        int maxCost = 0;
        while (i <= j) {
            maxCost += arr[j];
            i += k;
            j--;
        }
        ans.add(maxCost);

        return ans;
    }
}
