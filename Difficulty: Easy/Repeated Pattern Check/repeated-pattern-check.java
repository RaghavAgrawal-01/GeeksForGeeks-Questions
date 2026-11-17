class Solution{
    public boolean findPattern(String s){
        int n=s.length();
        int countX=0;
        int countY=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='x'){
                if(countY>0){
                    if(countX!=countY){
                        return false;
                    }
                    countX=0;
                    countY=0;
                }
                countX++;
            }
            else{
                countY++;
            }
        }
        return countX==countY;
    }
}