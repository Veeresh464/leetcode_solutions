class Solution {


    int getLCS(String s1, String s2, int l1, int l2, int dp[][]){
        if(l1<0 || l2<0) return 0;

        if(dp[l1][l2] != -1) return dp[l1][l2];
        int ans1 = 0;
        int ans2 = 0;
        if(s1.charAt(l1) == s2.charAt(l2)){
            ans1 = 1 + getLCS(s1, s2, l1-1, l2-1, dp);
        }
        else{
            int take1 = getLCS(s1,s2, l1-1, l2, dp);
            int take2 = getLCS(s1,s2, l1, l2-1, dp);
            ans2 = Math.max(take1,take2);
        }
        return dp[l1][l2] = ans1+ans2;
    }

    public int minInsertions(String s1) {
        int n = s1.length();
        String s2 = new StringBuilder(s1).reverse().toString();
        int dp[][] = new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int ans = getLCS(s1,s2, s1.length()-1, s2.length()-1, dp);
        return n-ans;
    }
}