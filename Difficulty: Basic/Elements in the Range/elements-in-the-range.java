class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        // code here
        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        for(int num : arr){
            set.add(num);
        }
        for(int i = start; i <= end; i++)
        {
            if(!set.contains(i))
            {
                return false;
            }
        }
        
        return true;
    }
}