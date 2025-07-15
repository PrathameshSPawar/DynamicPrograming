//https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
class Solution {
    int dp[][];
    int countPartitions(int[] arr, int d) {
        // code here
        int summ=0;
        for(int i : arr) {
            summ+=i;
        }
        if(summ-d<0 || (summ-d)%2==1) return 0;
        int sum=((summ-d)/2);
        dp=new int[arr.length][sum+1];
        
        for(int i[] : dp)
        {
            Arrays.fill(i,0);
        }
        if(arr[0] == 0) dp[0][0]=2;
        else dp[0][0]=1;
        
        if(arr[0]!=0 && arr[0]<=sum)dp[0][arr[0]]=1;
        
        for(int ind=1;ind<arr.length;ind++)
        {
            for(int target=0;target<=sum;target++)
            {
                int notT=dp[ind-1][target];
                int take=0;
                if(target>=arr[ind]) take=dp[ind-1][target-arr[ind]];
                dp[ind][target]=notT+take;
            }
        }
        return dp[arr.length-1][sum];
        
        //return helper(arr,arr.length-1,((sum-d)/2));
    }
    
    int helper(int arr[],int ind,int sum)
    {
        if(ind==0)
        {
            if(arr[0]==0 && sum==0) return 2;
            if(sum==0 || sum==arr[0]) return 1;
            return 0;
        }
        if(dp[ind][sum]!=-1) return dp[ind][sum];
        
        int take=0;
        if(sum>=arr[ind]) take=helper(arr,ind-1,sum-arr[ind]);
        
        int notT=helper(arr,ind-1,sum);
        
        return dp[ind][sum]=take + notT;
    }
}
