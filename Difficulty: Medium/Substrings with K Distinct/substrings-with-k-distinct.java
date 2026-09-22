// // Approach 1: Brute-force using nested loops. For each starting index i, we expand the substring to the right and maintain a frequency array to track distinct characters. If the number of distinct characters becomes exactly k, we count it. If it exceeds k, we break early.
// // Time Complexity: O(n^2) in the worst case due to nested loops, where n is the length of the string.
// // Space Complexity: O(1) because we use a fixed-size frequency array of size 26.
// class Solution {
//     int countSubstr(String s, int k) {
//         int n      = s.length();
//         int result = 0;

//         for (int i = 0; i < n; i++) {
//             int[] freq = new int[26]; // frequency array to store character counts
//             int distinctCnt = 0;      // number of distinct characters in current window

//             for (int j = i; j < n; j++) {
//                 if (freq[s.charAt(j) - 'a'] == 0) {
//                     distinctCnt++;         // new distinct character found
//                 }
//                 freq[s.charAt(j) - 'a']++; // increment frequency of current character

//                 if (distinctCnt == k) {
//                     result++; // valid substring with exactly k distinct characters
//                 } else if (distinctCnt > k) {
//                     break;    // more than k distinct characters, break early
//                 }
//             }
//         }

//         return result;
//     }
// }

// /*
//  *
//  * Dry Run
//  * Input: s = "aabc", k = 2
//  *
//  * i = 0
//  *  j = 0: freq = [1,...], distinctCnt = 1 → Not count
//  *  j = 1: freq = [2,...], distinctCnt = 1 → Not count
//  *  j = 2: freq = [2,1,...], distinctCnt = 2 → Count → result = 1 ("aab")
//  *  j = 3: freq = [2,1,1,...], distinctCnt = 3 → Break (more than k)
//  *
//  * i = 1
//  *  j = 1: freq = [1,...], distinctCnt = 1 → Not count
//  *  j = 2: freq = [1,1,...], distinctCnt = 2 → Count → result = 2 ("ab")
//  *  j = 3: freq = [1,1,1,...], distinctCnt = 3 → Break
//  *
//  * i = 2
//  *  j = 2: freq = [0,1,...], distinctCnt = 1 → Not count
//  *  j = 3: freq = [0,1,1,...], distinctCnt = 2 → Count → result = 3 ("bc")
//  *
//  * i = 3
//  *  j = 3: freq = [0,0,1,...], distinctCnt = 1 → Not count
//  *
//  * Final Answer: 3
//  *
//  */














// // Approach 2: Use sliding window to count substrings with at most K distinct characters. To get exactly K distinct, we subtract countAtMostK(s, k) - countAtMostK(s, k - 1).
// // Time Complexity: O(n), where n is the length of the string. Each character is processed at most twice (once by j and once by i).
// // Space Complexity: O(1) since at most 26 lowercase letters are stored in the hashmap.
// class Solution {
//     int countAtMostK(String s, int k) {
//         int n = s.length();
//         Map<Character, Integer> map = new HashMap<>();
//         int i = 0, j = 0, result = 0;

//         while (j < n) {
//             map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1); // include current char

//             while (map.size() > k) {
//                 map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
//                 if (map.get(s.charAt(i)) == 0) {
//                     map.remove(s.charAt(i)); // remove if freq is 0
//                 }
//                 i++;
//             }

//             result += j - i + 1; // valid substrings ending at j
//             j++;
//         }

//         return result;
//     }
//     int countSubstr(String s, int k) {
//         return countAtMostK(s, k) - countAtMostK(s, k - 1); // exactly K = atMost(k) - atMost(k-1)
//     }
// }

// /*
//  *
//  * Dry Run
//  * Input: s = "aabc", k = 2
//  *
//  * Step 1: countAtMostK(s, 2)
//  *  i = 0, j = 0 → map = {a:1} → +1 substrings → result=1
//  *  j = 1 → map = {a:2} → +2 substrings → result=3
//  *  j = 2 → map = {a:2, b:1} → +3 substrings → result=6
//  *  j = 3 → map = {a:2, b:1, c:1} → size=3 → shrink window: remove a, then a again → map = {b:1, c:1} → i=2 → +2 substrings → result=8
//  *
//  * Step 2: countAtMostK(s, 1)
//  *  i = 0, j = 0 → map = {a:1} → +1 substrings → result=1
//  *  j = 1 → map = {a:2} → +2 substrings → result=3
//  *  j = 2 → map = {a:2, b:1} → shrink: remove a twice → map = {b:1} → i=2 → +1 substrings → result=4
//  *  j = 3 → map = {b:1, c:1} → shrink: remove b → map = {c:1} → i=3 → +1 substrings → result=5
//  *
//  * Final Answer = 8 - 5 = 3 (Valid substrings with exactly 2 distinct: "aab", "ab", "bc")
//  *
//  */













// Approach 3: Sliding Window with Fixed-Size Array. Count substrings with at most K distinct characters using a frequency array of size 26. To get substrings with exactly K distinct characters, subtract countAtMostK(s, k) - countAtMostK(s, k - 1).
// Time Complexity: O(n), where n is the length of the string. Each character is processed at most twice (once by i and once by j).
// Space Complexity: O(1), using a fixed-size array of size 26 for lowercase characters.
class Solution {
    int countAtMostK(String s, int k) {
        int n = s.length();                 // Length of the string
        int[] freq = new int[26];           // Frequency array for 'a' to 'z'
        int i = 0, j = 0;                   // Two pointers
        int result      = 0;                // Count of substrings
        int distinctCnt = 0;                // Number of distinct characters

        while (j < n) {
            if (freq[s.charAt(j) - 'a'] == 0) {
                distinctCnt++;              // New distinct character
            }
            freq[s.charAt(j) - 'a']++;      // Add character to the window

            while (distinctCnt > k) {
                freq[s.charAt(i) - 'a']--;  // Shrink from the left
                if (freq[s.charAt(i) - 'a'] == 0) {
                    distinctCnt--;          // A distinct character is completely removed
                }
                i++;
            }

            result += j - i + 1;            // Valid substrings ending at j
            j++;
        }

        return result;
    }
    int countSubstr(String s, int k) {
        return countAtMostK(s, k) - countAtMostK(s, k - 1); // Exactly K distinct substrings
    }
}

/*
 *
 * Dry Run
 * Input: s = "aabc", k = 2
 *
 * countAtMostK(s, 2)
 * Window: [0, 0] → freq = {a:1} → distinct = 1 → +1 → result = 1
 * Window: [0, 1] → freq = {a:2} → distinct = 1 → +2 → result = 3
 * Window: [0, 2] → freq = {a:2, b:1} → distinct = 2 → +3 → result = 6
 * Window: [0, 3] → freq = {a:2, b:1, c:1} → distinct = 3 → shrink window
 *       → remove a: freq = {a:1, b:1, c:1} → still 3 → remove a: freq[a]=0 → distinct = 2
 *       → i=2 → +2 substrings → result = 8
 *
 * countAtMostK(s, 1)
 * Window: [0, 0] → freq = {a:1} → distinct = 1 → +1 → result = 1
 * Window: [0, 1] → freq = {a:2} → +2 → result = 3
 * Window: [0, 2] → freq = {a:2, b:1} → distinct = 2 → shrink → remove a twice → distinct = 1
 *       → i=2 → +1 → result = 4
 * Window: [2, 3] → freq = {b:1, c:1} → distinct = 2 → shrink → remove b → b=0 → distinct = 1
 *       → i=3 → +1 → result = 5
 *
 * Final = 8 - 5 = 3 → substrings with exactly 2 distinct = "aab", "ab", "bc"
 *
 */