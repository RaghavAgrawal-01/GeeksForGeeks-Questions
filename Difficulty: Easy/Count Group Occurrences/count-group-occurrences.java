class Solution {
    public int getCount(String s,int k){
        int n=s.length();
        int[] groupCounts=new int[26];
        int i=0;
        while(i<n){
            char c=s.charAt(i);
            int j=i;
            while(j<n&&s.charAt(j)==c){
                j++;
            }
            groupCounts[c-'a']++;
            i=j;
        }
        int ans=0;
        for(int count:groupCounts){
            if(count==k){
                ans++;
            }
        }
        return ans;
    }
}