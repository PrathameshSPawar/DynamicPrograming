//First version of Knapsack
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


//Second Version of knapsack
//https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
class Solution {
    static int INT=(int)-1e9;
    static int dp[][];
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n=val.length;
        dp=new int[n][capacity+1];
        for(int cap=0;cap<=capacity;cap++)
        {
            dp[0][cap]=val[0]*(cap/wt[0]);
        }
        
        for(int ind=1;ind<n;ind++)
        {
            for(int cap=0;cap<=capacity;cap++)
            {
                int notT=0+dp[ind-1][cap];
                int take=INT;
                if(cap>=wt[ind]) take=val[ind]+dp[ind][cap-wt[ind]];
                dp[ind][cap]=Math.max(take,notT);
                
            }
        }
        return dp[n-1][capacity];
    }
    
    static int helper(int val[],int wt[],int ind,int cap)
    {
        if(ind==0)
        {
            return val[0]*(cap/wt[0]);
        }
        
        int notT=0+helper(val,wt,ind-1,cap);
        int take=INT;
        if(cap>=wt[ind]) take=val[ind]+helper(val,wt,ind,cap-wt[ind]);
        
        return Math.max(notT,take);
    }
}
