class Solution {
    public int firstElementKTime(int[] arr,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int x:arr){
            map.put(x,map.getOrDefault(x,0)+1);
            if(map.get(x)>=k){
                return x;
            }
        }
        return -1;
    }
}