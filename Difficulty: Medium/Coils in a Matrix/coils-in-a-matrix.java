import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        int m = 8 * n * n;
        int[] coil1 = new int[m];

        coil1[0] = 8 * n * n + 2 * n;
        int curr = coil1[0];
        int step = 2;
        int index = 1;
        int flag = 1;

        while(index < m)
        {
            for(int i=0;i<step && index<m;i++)
            {
                curr = curr - 4 * n * flag;
                coil1[index++] = curr;
            }
            for(int i=0;i<step && index<m;i++)
            {
                curr = curr + flag;
                coil1[index++] = curr;
            }
            step += 2;
            flag = -flag;
        }

        int[] coil2 = new int[m];
        for(int i=0;i<m;i++)
        {
            coil2[i] = 16 * n * n + 1 - coil1[i];
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i=m-1;i>=0;i--)
        {
            list1.add(coil1[i]);
            list2.add(coil2[i]);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(list2);
        result.add(list1);

        return result;
    }
}