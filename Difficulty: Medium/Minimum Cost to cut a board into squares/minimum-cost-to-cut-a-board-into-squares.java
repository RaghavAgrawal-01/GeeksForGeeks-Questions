class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        // code here
        Arrays.sort(x);
        Arrays.sort(y);
        
        int i = x.length-1 , j = y.length-1 , verticalCuts = 1 , horizontalCuts = 1 , result = 0;
        
        while(i >= 0 && j >= 0){
            
            if(x[i] > y[j]){
                
                result += (x[i]* verticalCuts);
                horizontalCuts++;
                i--;
            }
            
            else{
                
                result += (y[j]*horizontalCuts);
                verticalCuts++;
                j--;
            }
        }
        
        while(i >=0 ){
            
            result += (x[i]* verticalCuts);
            i--;
        }
        
        while(j >= 0){
            
            result += (y[j]*horizontalCuts);
            j--;
        }
        
        return result;
    }
}
     