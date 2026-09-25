class Solution {
    public String binaryNextNumber(String s) {
        // code here
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = n - 1;

        while(i >= 0 && arr[i] == '1')
        {
            arr[i] = '0';
            i--;
        }

        if(i >= 0)
        {
            arr[i] = '1';

            int start = 0;
            while(start < n - 1 && arr[start] == '0')
            {
                start++;
            }
            return new String(arr, start, n - start);
        }
        else
        {
            StringBuilder sb = new StringBuilder();
            sb.append('1');
            for(int j = 0; j < n; j++)
            {
                sb.append('0');
            }
            return sb.toString();
        }
    }
}