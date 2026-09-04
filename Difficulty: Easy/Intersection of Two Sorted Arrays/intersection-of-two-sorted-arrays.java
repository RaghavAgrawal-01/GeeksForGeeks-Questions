class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int n = a.length, m = b.length;
        while(i < n && j < m)
        {
            if(i > 0 && a[i] == a[i - 1])
            {
                i++;
                continue;
            }
            if(j > 0 && b[j] == b[j - 1])
            {
                j++;
                continue;
            }
            if(a[i] == b[j]) {
                result.add(a[i]);
                i++;
                j++;
            } 
            else if(a[i] < b[j]) {
                i++;
            } 
            else{
                j++;
            }
        }
        return result;
    }
}