class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        // code here
        int n = men.length;
        int[] partnerMen = new int[n];
        int[] partnerWomen = new int[n];
        int[] nextProposal = new int[n];
        Arrays.fill(partnerWomen, -1);
        Arrays.fill(partnerMen, -1);
        Arrays.fill(nextProposal, 0);
        int[][] rank = new int[n][n];
        for(int w = 0; w < n; w++) {
            for(int i = 0; i < n; i++)
            {
                rank[w][women[w][i]] = i;
            }
        }
        Queue<Integer> freeMen = new LinkedList<>();
        for(int i = 0; i < n; i++) freeMen.add(i);
        while(!freeMen.isEmpty()) {
            int m = freeMen.poll();
            int w = men[m][nextProposal[m]];
            nextProposal[m]++;
            if(partnerWomen[w] == -1) {
                partnerWomen[w] = m;
                partnerMen[m] = w;
            }
            else {
                int current = partnerWomen[w];
                if(rank[w][m] < rank[w][current]) {
                    partnerWomen[w] = m;
                    partnerMen[m] = w;
                    partnerMen[current] = -1;
                    freeMen.add(current);
                } else {
                    freeMen.add(m);
                }
            }
        }
        return partnerMen;
    }
}