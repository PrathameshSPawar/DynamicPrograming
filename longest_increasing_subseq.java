//https://leetcode.com/problems/longest-increasing-subsequence/
class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        dp=new int[n+1][n+1];
        for(int i[] : dp) {
            Arrays.fill(i,0);
        }

        for(int ind=n-1;ind>=0;ind--) {
            for(int prev_max=ind-1;prev_max>=-1;prev_max--) {
                int maxi=0;
                if(prev_max==-1 || nums[ind]>nums[prev_max]) {
                    maxi=1+dp[ind+1][ind+1];
                }

                int notT=0+dp[ind+1][prev_max+1];
                maxi=Math.max(maxi,notT);
                dp[ind][prev_max+1]=maxi;
            }
        }

        return dp[0][0];
        //return helper(0,-1,nums);
    }

    public int helper(int ind,int prev_max,int nums[])
    {
        if(ind == nums.length) return 0;
        if(dp[ind][prev_max+1]!=-1) return dp[ind][prev_max+1];
        int maxi=0;
        if(prev_max==-1 || nums[ind]>nums[prev_max]) {
            maxi=1+helper(ind+1,ind,nums);
        }

        int notT=0+helper(ind+1,prev_max,nums);
        maxi=Math.max(maxi,notT);
        return dp[ind][prev_max+1]=maxi;
    }
}


//https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1
// User function Template for Java

import java.util.*;
class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        ArrayList<Integer> ans=new ArrayList<>();
        int lastInd=0,n=arr.length,maxLen=1;
        int hash[]=new int[n];
        for(int i=0;i<n;i++) hash[i]=i;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        
        for(int ind=0;ind<n;ind++) {
            for(int prev=0;prev<ind;prev++) {
                if(arr[prev]<arr[ind] && 1+dp[prev]>dp[ind]) {
                    dp[ind]=1+dp[prev];
                    hash[ind]=prev;
                }
            }
            //System.out.print(dp[ind]+" ");
            if (dp[ind] > maxLen) {
                maxLen = dp[ind];
                lastInd = ind;
            }
        }
        
        while(hash[lastInd]!=lastInd) {
            ans.add(0,arr[lastInd]);
            lastInd=hash[lastInd];
        }
        ans.add(0,arr[lastInd]);
        return ans;
    }
}
//
