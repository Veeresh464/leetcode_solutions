class Solution {

    int getAns(String t1, String t2, int i1, int i2, int dp[][]){
        if(i1 < 0 || i2 < 0) return 0;

        int common = 0;
        int take1 = 0;
        if(dp[i1][i2] != -1) return dp[i1][i2];
        if(t1.charAt(i1) == t2.charAt(i2)){
            common = 1+getAns(t1,t2,i1-1,i2-1, dp);
        }
        else take1 = Math.max(getAns(t1, t2, i1-1, i2, dp),getAns(t1,t2,i1,i2-1, dp));
        return dp[i1][i2] = take1+common;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return getAns(text1, text2, text1.length()-1, text2.length()-1, dp);
    }
}