//Minimum Path Sum_Grid-Based DP (Bottom-Up & Memoization)
//https://leetcode.com/problems/minimum-path-sum/
class Solution {
    public int memo[][];
    public int dp[][];
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0) dp[0][0]=grid[0][0];
                if(i>0 || j>0)
                {
                    int up=0;
                    if(i>0) up+=dp[i-1][j];
                    else up+=1e9;
                    int left=0;
                    if(j>0) left+=dp[i][j-1];
                    else left+=1e9;
                    dp[i][j]=grid[i][j]+Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
        // memo=new int[m][n];
        // for(int i[] : memo)
        // {
        //     Arrays.fill(i,-1);
        // }
        //return helper(m-1,n-1,grid);
    }

    // public int helper(int m,int n,int arr[][])
    // {
    //     if(m==0 && n==0) return arr[0][0];
    //     if(m<0 || n<0) return Integer.MAX_VALUE;
    //     if(memo[m][n]!=-1) return memo[m][n];

    //     int up=helper(m-1,n,arr);
    //     int left=helper(m,n-1,arr);
    //     return memo[m][n]=arr[m][n]+Math.min(up,left);
    // }
}
