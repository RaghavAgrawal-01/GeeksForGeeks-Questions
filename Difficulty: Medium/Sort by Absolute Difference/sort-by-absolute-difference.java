// class Solution {
//     public void rearrange(int[] arr, int x) {
//         // code here
//         Integer[] temp = new Integer[arr.length];
//         for(int i = 0; i < arr.length; i++)
//         {
//             temp[i] = arr[i];
//         }
//         Arrays.sort(temp, (a, b) -> Math.abs(a - x) - Math.abs(b - x));
//         for(int i = 0; i < arr.length; i++)
//         {
//             arr[i] = temp[i];
//         }
//     }
// }









class Solution {
    public void rearrange(int[] arr, int x) {
        // code here
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for(int num : arr) {
            int diff = Math.abs(num - x);
            map.putIfAbsent(diff, new ArrayList<>());
            map.get(diff).add(num);
        }

        int i = 0;
        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            for(int num : entry.getValue()) {
                arr[i++] = num;
            }
        }
    
    }
}