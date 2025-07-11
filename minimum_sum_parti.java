// User function Template for Java
//https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1

class Solution {

    public int minDifference(int nums[]) {
        // Your code goes here
        int sum=0;
        for(int i : nums)
        {
            sum+=i;
        }

        int n=nums.length;
        if (sum<0 || n==0) return 0;
        int dp[][]=new int[n][sum+1];
        for(int ind=0;ind<n;ind++)
        {
            dp[ind][0]=1;
        }

        for(int ind=1;ind<n;ind++)
        {
            for(int target=1;target<=sum;target++)
            {
                int take=0;
                if(target>=nums[ind])
                {
                    take=dp[ind-1][target-nums[ind]];
                }

                int notT=dp[ind-1][target];
                dp[ind][target]=(take==1 || notT==1) ? 1 : 0;
            }
        }

        int mini=(int) 1e9;
        for(int target=0;target<=sum;target++)
        {
            if(dp[n-1][target]==1)
            {
                //mini=Math.min(mini,(sum-target)-target);
                int remSum=sum-target;
                int ans=Math.abs(remSum-target);
                mini=Math.min(mini,ans);
            }
        }

        return mini;
    }
}
