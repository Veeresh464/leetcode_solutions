class Solution {
    // recursive
    // int getAns(StringBuilder text1, StringBuilder text2, int t1, int t2, int [][] dp){
    //     if(t1<0 || t2<0) return 0;

    //     int res=0;
    //     if(dp[t1][t2] != -1) return dp[t1][t2];
    //     if(text1.charAt(t1) == text2.charAt(t2)){
    //         res+= 1+ getAns(text1, text2, t1-1, t2-1, dp);
    //     }
    //     else{
    //         res = Math.max(getAns(text1, text2, t1-1, t2, dp), getAns(text1, text2, t1, t2-1, dp));
    //     }
    //     return dp[t1][t2]=res;
    // }
    // public int longestCommonSubsequence(String text1, String text2) {
    //     StringBuilder a = new StringBuilder(text1);
    //     StringBuilder b = new StringBuilder(text2);
    //     int [][] dp = new int[a.length()][b.length()];
    //     for(int row[]:dp){
    //         Arrays.fill(row,-1);
    //     }
    //     return getAns(a, b, a.length()-1, b.length()-1, dp);
    // }

    // tabulation
    public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder a = new StringBuilder(text1);
        StringBuilder b = new StringBuilder(text2);
        int [][] dp = new int[a.length()][b.length()];
        for(int i=0; i<a.length(); i++){
            for(int j=0; j<b.length(); j++){
                if(a.charAt(i) == b.charAt(j)) dp[i][j] = 1+ ((i-1 >= 0 && j-1 >= 0)? dp[i-1][j-1]:0);
                else{
                    dp[i][j] = Math.max( (i-1 >= 0)? dp[i-1][j]:0 , (j-1 >= 0)? dp[i][j-1]:0);
                }
            }
        }
        return dp[a.length()-1][b.length()-1];
    }

}