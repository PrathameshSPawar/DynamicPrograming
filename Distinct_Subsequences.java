//https://leetcode.com/problems/distinct-subsequences/
class Solution {
    int dp[][];
    public int numDistinct(String s, String t) {
        int l1=s.length();
        int l2=t.length();
        dp=new int[l1+1][l2+1];
        for(int i[] : dp)
        {
            Arrays.fill(i,0);
        }
        for(int i=0;i<=l1;i++) {
            dp[i][0]=1;
        }

        for(int i=1;i<=l1;i++)
        {
            for(int j=1;j<=l2;j++)
            {
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[l1][l2];
        //return helper(l1-1,l2-1,s,t);
    }

    // public int helper(int l1,int l2,String str,String target)
    // {
    //     if(l2<0) return 1;
    //     if(l1<0) return 0;

    //     if(dp[l1][l2]!=-1) return dp[l1][l2];
    //     if(str.charAt(l1)==target.charAt(l2)) {
    //         return dp[l1][l2]=helper(l1-1,l2-1,str,target)+helper(l1-1,l2,str,target);
    //     } else {
    //         return dp[l1][l2]=helper(l1-1,l2,str,target);
    //     }
    // }
}
