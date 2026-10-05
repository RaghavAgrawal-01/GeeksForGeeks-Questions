import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = arr.length + 1;

        for(int i = 2; i <= n; i++)
        {
            ArrayList<int[]> list = new ArrayList<>();
            int curr = i;
            int k = 0;

            while(curr > 1)
            {
                int parent = arr[curr - 2];
                k++;
                list.add(new int[]{parent, k});
                curr = parent;
            }

            list.sort((a, b) -> Integer.compare(a[0], b[0]));

            for(int[] item : list)
            {
                ArrayList<Integer> tuple = new ArrayList<>();
                tuple.add(i);
                tuple.add(item[0]);
                tuple.add(item[1]);
                result.add(tuple);
            }
        }

        return result;
    }
}