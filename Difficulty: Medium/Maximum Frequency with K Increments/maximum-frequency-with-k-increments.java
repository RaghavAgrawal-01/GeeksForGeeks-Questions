import java.util.*;

class Solution {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);

        int left = 0;
        int maxFreq = 0;
        long totalSum = 0;

        for (int right = 0; right < arr.length; right++)
        {
            totalSum += arr[right];

            while ((long) arr[right] * (right - left + 1) - totalSum > k)
            {
                totalSum -= arr[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}