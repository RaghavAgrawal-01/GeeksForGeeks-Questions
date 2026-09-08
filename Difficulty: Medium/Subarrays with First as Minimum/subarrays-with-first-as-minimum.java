class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        long count=0;
        for(int i=0; i<n; i++)
        {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()])
            {
                int idx = stack.pop();
                count += i-idx;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            count+= n-idx;
        }
        return (int)count;
    }
}
