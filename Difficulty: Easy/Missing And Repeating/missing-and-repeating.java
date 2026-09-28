class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        int xor_all = 0, xor1 = 0, xor2 = 0;
        for(int i = 0; i < n; i++)
        {
            xor_all ^= arr[i];
            xor_all ^= (i + 1);
        }
        int set_bit = xor_all & ~(xor_all - 1);
        for(int i = 0; i < n; i++)
        {
            if((arr[i] & set_bit) != 0)
                xor1 ^= arr[i];
            else
                xor2 ^= arr[i];

            if(((i + 1) & set_bit) != 0)
                xor1 ^= (i + 1);
            else
                xor2 ^= (i + 1);
        }
        int repeating = 0, missing = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == xor1) {
                repeating = xor1;
                missing = xor2;
                break;
            }
            else if(arr[i] == xor2) {
                repeating = xor2;
                missing = xor1;
                break;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        return result;
    }
}