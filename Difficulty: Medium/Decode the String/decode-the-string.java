class Solution {
    static String decodedString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int idx = 0;
        while(idx < s.length()) {
            if(Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while(Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                counts.push(count);
            } else if(s.charAt(idx) == '[') {
                result.push(res);
                res = "";
                idx++;
            } else if(s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int repeatTimes = counts.pop();
                for(int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx);
                idx++;
            }
        }
        return res;
    }
}