class Solution {
    public String chooseSwap(String s) {
        // code here
        int n = s.length();

        int[] first = new int[26];
        for(int i = 0; i < 26; i++)
        {
            first[i] = -1;
        }

        for(int i = 0; i < n; i++)
        {
            int idx = s.charAt(i) - 'a';
            if(first[idx] == -1)
            {
                first[idx] = i;
            }
        }

        char ch1 = 0, ch2 = 0;
        boolean found = false;

        for(int i = 0; i < n && !found; i++)
        {
            int curr = s.charAt(i) - 'a';

            for(int j = 0; j < curr; j++)
            {
                if(first[j] > i)
                {
                    ch1 = s.charAt(i);
                    ch2 = (char)(j + 'a');
                    found = true;
                    break;
                }
            }
        }

        if(!found) return s;

        char[] arr = s.toCharArray();

        for(int i = 0; i < n; i++)
        {
            if(arr[i] == ch1)
            {
                arr[i] = ch2;
            }
            else if(arr[i] == ch2)
            {
                arr[i] = ch1;
            }
        }

        return new String(arr);
    }
}