https://leetcode.com/problems/unique-paths-ii/
class Solution {
    int memo[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        memo=new int[m][n];
        for(int i[] : memo) {
            Arrays.fill(i,0);
        }
        int MOD=2000000000;
        memo[0][0]=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(obstacleGrid[i][j] == 1) {
                    memo[i][j]=0; 
                }
                else if(i>0 || j>0) {
                    int up=0,left=0;
                    if(i>0) up=memo[i-1][j];
                    if(j>0) left=memo[i][j-1];
                    memo[i][j]=up+left;
                }
            }
        }
        return memo[m-1][n-1];

        // for(int i[] : memo)
        // {
        //     Arrays.fill(i,-1);
        // }
        //return helper(m,n,obstacleGrid)%MOD;
    }

    public int helper(int m,int n,int arr[][])
    {
        if(arr[m][n]==1) return 0;
        if(m==0 && n==0) return 1;
        if(memo[m][n]!=-1) return memo[m][n];
        int up=0;
        if(m>0) up=helper(m-1,n,arr);
        int left=0;
        if(n>0) left=helper(m,n-1,arr);
        return memo[m][n]=up+left; 
    }
}
