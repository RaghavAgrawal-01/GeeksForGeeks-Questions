class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        // Code here
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:arr)
        {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->{
            if(map.get(a).equals(map.get(b))){
                return b-a;
            }
            return map.get(b)-map.get(a);
        });
        
        pq.addAll(map.keySet());
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<k; i++){
            res.add(pq.poll());
        }
        return res;
    }
}
