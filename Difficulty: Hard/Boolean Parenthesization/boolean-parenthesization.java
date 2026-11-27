class Solution {
    static int countWays(String s) {
        // code here
        int n= s.length();
        int[][] T = new int[n][n];
        int[][] F = new int[n][n];
        for(int i=0; i<n; i+=2){
            T[i][i] = s.charAt(i) == 'T' ? 1:0;
            F[i][i] = s.charAt(i) == 'F' ? 1:0;
        }
        for(int l=3; l<=n; l+=2){
            for(int i=0;i<=n-l; i+=2){
                int j=i+l-1;
                T[i][j]=0;
                F[i][j]=0;
                for(int k=i+1; k<j; k+=2){
                    int lt = T[i][k-1];
                    int lf= F[i][k-1];
                    int rt = T[k+1][j];
                    int rf = F[k+1][j];
                    char op=s.charAt(k);
                    if(op=='&'){
                        T[i][j] += lt*rt; //(T[i][j] + (lt*rt)%MOD) %MOD;
                        F[i][j] += lt*rf+lf*rt+lf*rf;    //(F[i][j] + ((lt*rf) %MOD + (lf * rt) % MOD + (lf*rf) % MOD) % MOD) % MOD;
                    }
                    else if(op=='|'){
                        T[i][j] += lt*rt + lt*rf + lf*rt;  //(T[i][j] + ((lt*rt) % MOD +(lt*rf) % MOD + (lf*rt) % MOD) % MOD) % MOD;
                        F[i][j] += lf*rf;   //(F[i][j] + (lf*rf) % MOD) % MOD;
                    }
                    else if(op=='^'){
                        T[i][j] += lt*rf + lf*rt;   //(T[i][j] + ((lt*rf)%MOD + (lf*rt) % MOD) %MOD) %MOD;
                        F[i][j] +=  lt*rt + lf*rf;  //(F[i][j] + ((lt*rt) % MOD +(lf*rf) % MOD) %MOD) %MOD;
                    }
                }
            }
        }
        return T[0][n-1];
    }
}