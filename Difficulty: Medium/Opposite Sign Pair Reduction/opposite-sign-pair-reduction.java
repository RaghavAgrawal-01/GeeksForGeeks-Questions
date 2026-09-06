class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        // <Integer> stack = new ArrayList<>();
        ArrayList<Integer> stack = new ArrayList<>();
        for(int num : arr){
            boolean added = false;
            while(!stack.isEmpty()){
                int top = stack.get(stack.size() - 1);
                if((top > 0 && num < 0) || (top < 0 && num > 0))
                {
                    if(Math.abs(top) > Math.abs(num))
                    {
                        added = true;
                        break;
                    } 
                    else if (Math.abs(top) < Math.abs(num)) {
                        stack.remove(stack.size() - 1);
                        continue;
                    } 
                    else {
                        stack.remove(stack.size() - 1);
                        added = true;
                        break;
                    }
                }
                else {
                    break;
                }
            }
            if(!added) {
                stack.add(num);
            }
        }
        return stack;
    }
}