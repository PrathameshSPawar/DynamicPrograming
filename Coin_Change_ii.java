//https://leetcode.com/problems/coin-change-ii/
class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        int n=coins.length;
        dp=new int[n][amount+1];
        for(int i[] : dp) {
            Arrays.fill(i,0);
        }
    
        // for(int i=0;i<n;i++) {
        //     dp[i][0]=1;
        // }
        
        for(int i=0;i<=amount;i++) {
            if(i%coins[0]==0) dp[0][i]=1;
        }

        for(int ind=1;ind<n;ind++)
        {
            for(int target=0;target<=amount;target++)
            {
                int notT=dp[ind-1][target];
                int take=0;
                if(target>=coins[ind]) take=dp[ind][target-coins[ind]];
                dp[ind][target]=notT+take;
            }
        }

        return dp[n-1][amount];
        //return helper(coins,amount,n-1);
    }

    // public int helper(int coins[],int target,int ind)
    // {
    //     if(target==0) return 1;
    //     if(ind==0)
    //     {
    //         if(target%coins[0]==0) return 1;
    //         else return 0;
    //     }

    //     if(dp[ind][target]!=-1) return dp[ind][target];
    //     int notT=helper(coins,target,ind-1);
    //     int take=0;
    //     if(target>=coins[ind]) take=helper(coins,target-coins[ind],ind);

    //     return dp[ind][target]=take+notT;
    // }
}
