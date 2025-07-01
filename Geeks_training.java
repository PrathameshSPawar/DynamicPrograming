// User function Template for Java

class Solution {
    public int memo[][];

    
    //This Solution:: Tabulation
    public int maximumPoints(int arr[][]) {
        // code here
        int n=arr.length;
        memo=new int[arr.length][4];
        for (int[] row : memo) {
            Arrays.fill(row, 0);
        }
        memo[0][0]=Math.max(arr[0][1],arr[0][2]);
        memo[0][1]=Math.max(arr[0][0],arr[0][2]);
        memo[0][2]=Math.max(arr[0][0],arr[0][1]);
        memo[0][3]=Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));
        for(int day=1;day<n;day++)
        {
            for(int last=0;last<4;last++)
            {
                memo[day][last]=0;
                for(int task=0;task<3;task++)
                {
                    if(task!=last)
                    {
                        int curr=arr[day][task]+memo[day-1][task];
                        memo[day][last]=Math.max(memo[day][last],curr);
                    }
                }
            }
        }
        return memo[n-1][3];
        
        // return helper(arr,arr.length-1,3);
    }

    //This Solution::Memorization
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
