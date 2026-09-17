class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int num : a) set.add(num);
        for(int num : b) set.add(num);
        return new ArrayList<>(set);
    }
}