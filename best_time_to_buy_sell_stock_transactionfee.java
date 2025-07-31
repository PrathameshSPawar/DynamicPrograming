//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
class Solution {
    int dp[][];
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        dp=new int[n+1][2];
        for(int i[] : dp) {
            Arrays.fill(i,0);
        }

        for(int ind=n-1;ind>=0;ind--) {
            for(int buy=0;buy<2;buy++) {
                int profit=0;
                if(buy==1) {
                    profit=Math.max(-fee-prices[ind]+dp[ind+1][0],dp[ind+1][buy]);
                } else {
                    profit=Math.max(prices[ind]+dp[ind+1][1],dp[ind+1][0]);
                }
                dp[ind][buy]=profit;
            }
        }

        return dp[0][1];
        //return helper(0,1,fee,prices);
    }

    public int helper(int ind,int buy,int fee,int prices[])
    {
        if(ind>=prices.length) return 0;

        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit=0;

        if(buy==1) {
            profit=Math.max(-fee-prices[ind]+helper(ind+1,0,fee,prices),0+helper(ind+1,buy,fee,prices));
        } else {
            profit=Math.max(prices[ind]+helper(ind+1,1,fee,prices),helper(ind+1,buy,fee,prices));
        }
        return dp[ind][buy]=profit;
    }
}
