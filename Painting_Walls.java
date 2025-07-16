//https://leetcode.com/problems/painting-the-walls/description/
class Solution {
    int dp[][];
    public int paintWalls(int[] cost, int[] time) {
        int n=cost.length;
        dp=new int[n][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        
        //return helper(n-1,n,cost,time);
    }

    public int helper(int ind,int walls,int cost[],int time[])
    {
        if(walls <= 0) return 0;
        if(ind <0) return Integer.MAX_VALUE;
        if(dp[ind][walls]!=-1) return dp[ind][walls];
        //if(walls==0) return 0;
        int notT=0+helper(ind-1,walls,cost,time);
        int take=Integer.MAX_VALUE;
        int next=helper(ind-1,walls-1-time[ind],cost,time);
        if(next!=Integer.MAX_VALUE)
        {
            take=cost[ind]+next;
        }
        return dp[ind][walls]=Math.min(notT,take);
    }
}
