// User function Template for Java
//https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int l1=s1.length();
        int l2=s2.length();
        int dp[][]=new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++) {
            dp[i][0]=0;
        }
        
        for(int i=0;i<=l2;i++) {
            dp[0][i]=0;
        }
        
        int maxi=0;
        for(int i=1;i<=l1;i++)
        {
            for(int j=1;j<=l2;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                    maxi=Math.max(maxi,dp[i][j]);
                }else{
                    dp[i][j]=0;
            
                }    
            }
        }
        
        return maxi;
    }
}
