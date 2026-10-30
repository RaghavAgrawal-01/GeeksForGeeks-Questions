class Solution {
    public ArrayList<Integer> findKClosest(int[] arr, int k, int x) {
        Integer[] boxedArr = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) {
            boxedArr[i] = arr[i];
        }

        Arrays.sort(boxedArr, (a, b) -> {
            int distA = Math.abs(a - x);
            int distB = Math.abs(b - x);
            if(distA != distB) {
                return Integer.compare(distA, distB);
            }
            return Integer.compare(b, a);
        });

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            if(boxedArr[i] != x) {
                result.add(boxedArr[i]);
            } else {
                k++; // Skip x if present
            }
        }

        return result;
    }
}