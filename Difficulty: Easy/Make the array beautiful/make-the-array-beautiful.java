class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        // code here
        List<Integer> stack = new ArrayList<>();
        for(int num : arr)
        {
            if(!stack.isEmpty() && ((stack.get(stack.size() - 1) >= 0 && num < 0) || (stack.get(stack.size() - 1) < 0 && num >= 0)))
            {
                stack.remove(stack.size() - 1);
            }
            else
            {
                stack.add(num);
            }
        }
        return stack;
    }
}