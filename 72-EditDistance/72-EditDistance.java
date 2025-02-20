class Solution {
    int getAns(StringBuilder s1, StringBuilder s2, int l1, int l2, int dp[][]){
        if(l1 < 0) return l2+1;
        if(l2 < 0) return l1+1;

        if(dp[l1][l2] != -1) return dp[l1][l2];
        if(s1.charAt(l1) == s2.charAt(l2)){
            return dp[l1][l2] = getAns(s1,s2,l1-1,l2-1,dp);
        }
        else{
            int ansD = getAns(s1,s2,l1-1,l2,dp);
            int ansI = getAns(s1,s2,l1,l2-1,dp);
            int ansR = getAns(s1,s2, l1-1,l2-1,dp);
            return dp[l1][l2] = 1 + Math.min(ansD, Math.min(ansI,ansR));
        }
    }

    public int minDistance(String s1, String s2) {
        StringBuilder a = new StringBuilder(s1);
        StringBuilder b = new StringBuilder(s2);
        int n1 = s1.length();
        int n2 = s2.length();
        int dp[][] = new int[n1][n2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return getAns(a,b,n1-1,n2-1,dp);
    }
}