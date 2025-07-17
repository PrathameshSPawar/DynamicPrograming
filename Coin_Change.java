//https://leetcode.com/problems/coin-change/
class Solution {
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        dp=new int[n][amount+1];
        int INT=(int)1e9;
        for(int i[] : dp)
        {
            Arrays.fill(i,0);
        }

        for(int target=0;target<=amount;target++)
        {
            if(target%coins[0]==0) dp[0][target]=target/coins[0];
            else dp[0][target]=INT;
        }

        for(int ind=1;ind<n;ind++)
        {
            for(int target=0;target<=amount;target++)
            {
                //if(dp[ind][target]!=-1) return dp[ind][target];
                int notT=0+dp[ind-1][target];
                int take=INT; 
                if(target>=coins[ind]) take=1+dp[ind][target-coins[ind]];
        
                dp[ind][target]=Math.min(notT,take);
            }
        }

        int ans=dp[n-1][amount];
        if(ans>=INT) return -1;
        return ans;


        // int ans=helper(n-1,coins,amount);
        // return ans==(int)1e9 ? -1 : ans;
    }

    // public int helper(int ind,int coins[],int target)
    // {
    //     if(ind==0)
    //     {
    //         if(target%coins[ind]==0) return target/coins[ind];
    //         else return (int)1e9;
    //     }

    //     if(dp[ind][target]!=-1) return dp[ind][target];
    //     int notT=0+helper(ind-1,coins,target);
    //     int take=(int)1e9;
    //     if(target>=coins[ind]) take=1+helper(ind,coins,target-coins[ind]);
        
    //     return dp[ind][target]=Math.min(notT,take);
    // }
}
