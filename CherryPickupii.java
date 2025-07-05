https://leetcode.com/problems/cherry-pickup-ii/
class Solution {
    int memo[][][];
    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        memo=new int[m][n][n];
        for(int i[][] : memo)
        {
            for(int j[] : i)
            {
                Arrays.fill(j,-1);
            }
        }
        return helper(grid,0,0,n-1);
    }

    public int helper(int arr[][],int i,int j1,int j2)
    {
        int n=arr.length;
        int m=arr[0].length;
        if(j1<0 || j1>=m || j2<0 || j2>=m) return (int)-1e9;
        if(i==n-1) {
            if(j1==j2) return arr[i][j1];
            else return arr[i][j1]+arr[i][j2];
        }

        if(memo[i][j1][j2]!=-1) return memo[i][j1][j2];

        int maxi=0;
        for(int j10=-1;j10<=1;j10++)
        {
            for(int j20=-1;j20<=1;j20++)
            {
                if(j1==j2) {
                    int curr=arr[i][j1]+helper(arr,i+1,j1+j10,j2+j20);
                    maxi=Math.max(maxi,curr);
                } else { 
                    int curr=arr[i][j1] + arr[i][j2] + helper(arr,i+1,j1+j10,j2+j20);
                    maxi=Math.max(maxi,curr);
                }
            }
        }
        return memo[i][j1][j2]=maxi;
    }
}
