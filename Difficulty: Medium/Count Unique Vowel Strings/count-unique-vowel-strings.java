class Solution {
    public int vowelCount(String s) {
        int[] freq = new int[5];
        for(char ch : s.toCharArray())
        {
            if(ch == 'a') freq[0]++;
            else if(ch == 'e') freq[1]++;
            else if(ch == 'i') freq[2]++;
            else if(ch == 'o') freq[3]++;
            else if(ch == 'u') freq[4]++;
        }
        int count = 0;
        int ways = 1;
        for(int f : freq) 
        {
            if(f > 0)
            {
                count++;
                ways *= f;
            }
        }
        if(count == 0) return 0;
        return ways * factorial(count);
    }

    static int factorial(int n) {
        int fact = 1;
        for(int i = 2; i <= n; i++) fact *= i;
        return fact;
    }
}