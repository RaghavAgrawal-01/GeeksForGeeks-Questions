class Solution {
    public void sortIt(int[] arr) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for(int num : arr) {
            if(num % 2 != 0) {
                odd.add(num);
            }
            else {
                even.add(num);
            }
        }
        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even);
        int idx = 0;
        for(int num : odd) {
            arr[idx++] = num;
        }
        for(int num : even) {
            arr[idx++] = num;
        }
    }
}