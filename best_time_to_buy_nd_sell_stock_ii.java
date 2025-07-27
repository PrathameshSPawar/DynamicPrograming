//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
class Solution {
    int dp[][];
    public int maxProfit(int[] prices) {
        //int ind=0;
        int n=prices.length;

        dp=new int[prices.length+1][2];
        for(int i[] : dp)
        {
            Arrays.fill(i,0);
        }

        dp[n][0]=0;
        dp[n][1]=0;
        for(int ind=n-1;ind>=0;ind--)
        {
            
            for(int buy=0;buy<=1;buy++)
            {   
                int profit=0;
                if(buy==0) {
                    //for buy the stock
                    profit=Math.max(-prices[ind]+dp[ind+1][1],0+dp[ind+1][0]);
                } else {
                    //for sell the stock
                    profit=Math.max(prices[ind]+dp[ind+1][0],dp[ind+1][1]);
                }
                dp[ind][buy]=profit;
            }
        }

        return dp[0][0];

        //return helper(ind,buy,prices);
    }

    public int helper(int ind,int buy,int prices[])
    {
        if(ind>=prices.length)
        {
            return 0;
        }

        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit=0;
        if(buy==1) {
            profit=Math.max((-prices[ind]+helper(ind+1,0,prices)),(0+helper(ind+1,1,prices)));
        } else {
            profit=Math.max((prices[ind]+helper(ind+1,1,prices)),(0+helper(ind+1,0,prices)));
        }

        return dp[ind][buy]=profit;
    }
}
