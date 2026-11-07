class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        ArrayList<String> ans = new ArrayList<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        HashSet<String> reserved = new HashSet<>(Arrays.asList(arr));
        for(String s : arr)
        {
            if(!countMap.containsKey(s)) {
                countMap.put(s, 1);
                ans.add(s);
            }
            else
            {
                int k = countMap.get(s);
                String newName = s + k;
                while(reserved.contains(newName))
                {
                    k++;
                    newName = s + k;
                }
                countMap.put(s, k + 1);
                reserved.add(newName);
                ans.add(newName);
            }
        }
        return ans;
    }
}