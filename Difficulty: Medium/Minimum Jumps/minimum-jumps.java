/*
My Approach:
Greedy Approach
Track the farthest position reachable at every step.
Use a variable end to mark the last index reachable within the current jump.
If i reaches end, make a jump and update end.
If at any point i == end and end < n-1, return -1.
Algorithm Steps:
Initialize three variables:
jumps = 0 → Tracks the number of jumps.
farthest = 0 → Tracks the farthest reachable index.
end = 0 → Marks the end of the current jump.
Iterate through the array (except the last element):
Update farthest = max(farthest, i + arr[i]).
If i == end:
Increase jumps.
Update end = farthest.
If end >= n-1, return jumps.
If the last index is never reached, return -1.
Time and Auxiliary Space Complexity
Expected Time Complexity: O(N), as we iterate through the array only once.
Expected Auxiliary Space Complexity: O(1), as we use only a few variables for tracking jumps and indices.
*/

class Solution {
    static int minJumps(int[] arr) {
        int n=arr.length, jumps=0, farthest=0, end=0;
        if(n==1) return 0;
        for(int i=0; i<n-1; i++)
        {
            farthest = Math.max(farthest, i + arr[i]);
            if(i == end)
            {
                jumps++;
                end = farthest;
                if(end >= n - 1) return jumps;
            }
        }
        return -1;
    }
}