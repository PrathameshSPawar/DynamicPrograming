//https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
class Solution {
    static int dp[][];
    static int knapsack(int W, int val[], int wt[]) {
        int n=val.length;
        dp=new int[n][W+1];
        for(int i=wt[0];i<=W;i++)
        {
            dp[0][i]=val[0];
        }
        
        for(int ind=1;ind<n;ind++)
        {
            for(int wei=0;wei<=W;wei++)
            {
                int notT=0+dp[ind-1][wei];
                int take=0;
                if(wei>=wt[ind]) take=val[ind]+dp[ind-1][wei-wt[ind]];
                dp[ind][wei]=Math.max(notT,take);
            }
        }
        
        return dp[n-1][W];
        // code here
        // int n=val.length-1;
        // dp=new int[n+1][W+1];
        // for(int i[] : dp)
        // {
        //     Arrays.fill(i,-1);
        // }
        // return helper(n,W,val,wt);
    }
    
    // static int helper(int ind,int w,int val[],int wt[])
    // {
    //     if(ind==0)
    //     {
    //         if(wt[ind]<=w) return val[ind];
    //         else return 0;
    //     }
    //     if(dp[ind][w]!=-1) return dp[ind][w];
    //     int notT=0+helper(ind-1,w,val,wt);
    //     int take=Integer.MIN_VALUE;
    //     if(wt[ind]<=w) take=val[ind]+helper(ind-1,w-wt[ind],val,wt);
        
    //     return dp[ind][w]=Math.max(notT,take);
    // }
}
