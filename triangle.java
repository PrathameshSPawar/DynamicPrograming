https://leetcode.com/problems/triangle/
class Solution {
    int memo[][];
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int prev[]=new int[n];
        int curr[]=new int[n];
        for(int j=0;j<n;j++)
        {
            prev[j]=triangle.get(n-1).get(j);
        }

        for(int i=n-2;i>=0;i--)
        {
            for(int j=i;j>=0;j--)
            {
                int down=triangle.get(i).get(j) + prev[j];
                int downR=triangle.get(i).get(j) + prev[j+1];
                curr[j]=Math.min(down,downR);
            }

            for(int j=i;j>=0;j--)
            {
                prev[j]=curr[j];
            }
        }
        return prev[0];
        // int m=triangle.size();
        // int n=triangle.size();
        // //memo=new int[m][n];
        // int dp[][]=new int[m][n];
        // // for(int i[] : memo)
        // // {
        // //     Arrays.fill(i,-1);
        // // }

        // for(int j=0;j<triangle.get(m-1).size();j++)
        // {
        //     dp[m-1][j]=triangle.get(m-1).get(j);
        // }

        // for(int i=m-2;i>=0;i--)
        // {
        //     for(int j=i;j>=0;j--)
        //     {
        //         int down=triangle.get(i).get(j)+dp[i+1][j];
        //         int downR=triangle.get(i).get(j)+dp[i+1][j+1];
        //         dp[i][j]=Math.min(down,downR);
        //     }
        // }
        // return dp[0][0];

        //return helper(triangle,0,0);
    }

    // public int helper(List<List<Integer>> list,int i,int j)
    // {
    //     if(i==list.size()-1)
    //     {
    //         return list.get(i).get(j);
    //     }
    //     if(memo[i][j]!=-1) return memo[i][j];

    //     int down=list.get(i).get(j) + helper(list,i+1,j);
    //     int downL=list.get(i).get(j) + helper(list,i+1,j+1);
    //     return memo[i][j]=Math.min(down,downL);
    // }
}
