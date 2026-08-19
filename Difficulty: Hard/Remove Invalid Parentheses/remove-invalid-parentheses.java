class Solution {
    
    boolean isValid(String s){
        int count = 0;
        for(char c : s.toCharArray())
        {
            if(c == '(') count++;
            else if(c == ')')
            {
                count--;
                if(count < 0) return false;
            }
        }

        return count == 0;
    }
    public List<String> validParenthesis(String s) {
        // code here
        List<String> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(s);
        visited.add(s);

        boolean found = false;

        while(!q.isEmpty()){

            String curr = q.poll();

            if(isValid(curr)){
                ans.add(curr);
                found = true;
            }

            if(found) continue;

            for(int i = 0; i < curr.length(); i++){

                char c = curr.charAt(i);

                if(c != '(' && c != ')') continue;

                String next = curr.substring(0, i) + curr.substring(i + 1);

                if(!visited.contains(next)){
                    visited.add(next);
                    q.offer(next);
                }
            }
        }

        Collections.sort(ans);

        return ans;
    }
}