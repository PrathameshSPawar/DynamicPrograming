https://leetcode.com/problems/minimum-falling-path-sum/
class Solution {
    //public int memo[][];
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int dp[][]=new int[n][n];
        for(int j=0;j<n;j++)
        {
            dp[0][j]=matrix[0][j];
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int upL=Integer.MAX_VALUE;
                if(j>0) upL=matrix[i][j]+dp[i-1][j-1];
                int up=matrix[i][j]+dp[i-1][j];
                int upR=Integer.MAX_VALUE;
                if(j<n-1) upR=matrix[i][j]+dp[i-1][j+1];
                int curr=Math.min(up,Math.min(upL,upR));
                dp[i][j]=curr;
            }
        }

        int maxi=dp[n-1][0];
        for(int j=1;j<n;j++)
        {
            maxi=Math.min(maxi,dp[n-1][j]);
        }
        return maxi;
        // memo=new int[n][n];
        // for(int i[] : memo)
        // {
        //     Arrays.fill(i,-1);
        // }
        // int min=Integer.MAX_VALUE;
        // for(int i=0;i<n;i++)
        // {
        //     min=Math.min(min,helper(matrix,n-1,i));
        // }
        // return min;
    }

    // public int helper(int arr[][],int i,int j)
    // {
    //     int n=arr.length;
    //     if(j<0 || j>=n) return Integer.MAX_VALUE;
    //     if(i==0) return arr[0][j];
    //     if(memo[i][j]!=-1) return memo[i][j];
    //     int up=helper(arr,i-1,j);
    //     int upL=helper(arr,i-1,j-1);
    //     int upR=helper(arr,i-1,j+1);

    //     return memo[i][j]=arr[i][j]+Math.min(up,Math.min(upL,upR));
    // }
}
