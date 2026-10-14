class Solution {
    public ArrayList<String> generateBinary(int n) {
        // code here
        Queue<String> q = new LinkedList<>();
        ArrayList<String> ans = new ArrayList<>();
        
        q.add("1");
        for(int i=0 ; i<n ; i++){
            String x=q.remove();
            ans.add(x);
            q.add(x+"0");
            q.add(x+"1");
        }
        return ans;
    }
}
