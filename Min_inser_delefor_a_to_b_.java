https://leetcode.com/problems/delete-operation-for-two-strings/
class Solution {
    public int minDistance(String word1, String word2) {
        int l1=word1.length(),l2=word2.length();
        int dp[][]=new int[l1+1][l2+1];
        for(int i[] : dp)
        {
            Arrays.fill(i,0);
        }

        for(int ind1=1;ind1<=l1;ind1++)
        {
            for(int ind2=1;ind2<=l2;ind2++)
            {
                if(word1.charAt(ind1-1)==word2.charAt(ind2-1))
                {
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                }else{
                    dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }

        int lcs=dp[l1][l2];
        System.out.print(lcs);
        return (l1-lcs)+(l2-lcs);
    }
}
