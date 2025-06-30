// User function Template for Java

class Solution {
    public int memo[][];
    public int maximumPoints(int arr[][]) {
        // code here
        memo=new int[arr.length][4];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(arr,arr.length-1,3);
    }
    
    public int helper(int arr[][],int day,int last)
    {
        if(day==0)
        {
            int maxi=0;
            for(int i=0;i<3;i++)
            {
                if(i!=last)
                {
                    maxi=Math.max(maxi,arr[0][i]);
                }
            }
            return maxi;
        }
        
        if(memo[day][last]!=-1) return memo[day][last];
        int maxi=0;
        for(int i=0;i<3;i++)
        {
            if(i!=last)
            {
                int curr=arr[day][i]+helper(arr,day-1,i);
                maxi=Math.max(maxi,curr);
            }
        }
        return memo[day][last]=maxi;
    }
}
