class Solution {

    int getLCS(String s1, String s2, int l1, int l2, int dp[][]){
        if(l1<0 || l2<0) return 0;

        if(dp[l1][l2] != -1) return dp[l1][l2];
        int ans1=0;
        int ans2=0;
        if(s1.charAt(l1) == s2.charAt(l2)){
            ans1 = 1 + getLCS(s1,s2,l1-1,l2-1,dp);
        }
        else{
            ans2 = Math.max(getLCS(s1,s2,l1-1,l2,dp), getLCS(s1,s2,l1,l2-1,dp));
        }
        return dp[l1][l2]=ans1+ans2;
    }


    public int minDistance(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int dp[][] = new int[n1][n2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int res = getLCS(s1,s2,s1.length()-1, s2.length()-1, dp);
        int ans = 0;
        ans+= s1.length()-res;
        ans+= s2.length()-res;
        return ans;
    }
}