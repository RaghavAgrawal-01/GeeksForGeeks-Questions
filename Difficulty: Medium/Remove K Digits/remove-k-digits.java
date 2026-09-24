class Solution {
    public String removeKdig(String s, int k) {
        // code here
        int n = s.length();
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()) {
            while(!stk.isEmpty() && k > 0 && stk.peek() > c)
            {
                stk.pop();
                k--;
            }
            if(!stk.isEmpty() || c != '0') {
                stk.push(c);
            }
        }
        while(!stk.isEmpty() && k-- > 0)
        {
            stk.pop();
        }
        if(stk.isEmpty()) return "0";
        char[] arr = new char[n];
        while(!stk.isEmpty())
        {
            arr[n - 1] = stk.pop();
            n--;
        }
        return new String(arr, n, arr.length - n);
    }
}