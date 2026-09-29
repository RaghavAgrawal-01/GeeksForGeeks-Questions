class Solution {
    public int rowWithMax1s(int arr[][]) {
        int maxCount = 0;
        int rowIndex = -1;

        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                rowIndex = i;
            }
        }
        return rowIndex;
    }
}
