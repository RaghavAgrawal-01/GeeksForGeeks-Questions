import java.io.*;
import java.util.*;

class Solution {
    // Time Complexity :- O(1);
    // Space Complexity :- O(1);
    
    long lcmTriplets(long N) {
        // code here
        if(N<=2) return N;
        if(N%2==0) {
            if(N%3==0) {
                return (N-1)*(N-2)*(N-3);
            } else {
                return (N-1)*(N-3)*(N);
            }
        } else {
            return (N-2)*(N-1)*(N);
        }
    }
}