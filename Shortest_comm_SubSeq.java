//https://leetcode.com/problems/shortest-common-supersequence/
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int l1=str1.length();
        int l2=str2.length();
        int dp[][]=new int[l1+1][l2+1];
        for(int i[] : dp) {
            Arrays.fill(i,-1);
        }

        for(int ind1=1;ind1<=l1;ind1++) {
            for(int ind2=1;ind2<=l2;ind2++) {
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1))
                {
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                }else{
                    dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }

        int length=l1+l2-dp[l1][l2];

        StringBuilder ans=new StringBuilder();
        while(l1>0 && l2>0)
        {
            if(str1.charAt(l1-1)==str2.charAt(l2-1))
            {   
                ans.append(str1.charAt(l1-1));
                l1-=1;
                l2-=1;
            }else if(dp[l1][l2-1]>dp[l1-1][l2]) {
                ans.append(str2.charAt(l2-1));
                l2-=1;
            }else {
                ans.append(str1.charAt(l1-1));
                l1-=1;
            }
        }

        while(l1>0)
        {
            ans.append(str1.charAt(l1-1));
            l1-=1;
        }

        while(l2>0)
        {
            ans.append(str2.charAt(l2-1));
            l2-=1;        
        }
        return ans.reverse().toString();
    }
}
