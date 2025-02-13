class Solution {

    int getAns(StringBuilder text1, StringBuilder text2, int t1, int t2, int [][] dp){
        if(t1<0 || t2<0) return 0;

        int res=0;
        if(dp[t1][t2] != -1) return dp[t1][t2];
        if(text1.charAt(t1) == text2.charAt(t2)){
            res+= 1+ getAns(text1, text2, t1-1, t2-1, dp);
        }
        else{
            res = Math.max(getAns(text1, text2, t1-1, t2, dp), getAns(text1, text2, t1, t2-1, dp));
        }
        return dp[t1][t2]=res;
    }

    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder(rev);
        int [][] dp = new int[s1.length()][s2.length()];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return getAns(s1,s2,s1.length()-1,s2.length()-1,dp);
        
    }
}