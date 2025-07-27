//https://leetcode.com/problems/edit-distance/
class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {
        int l1=word1.length();
        int l2=word2.length();
        dp=new int[l1+1][l2+1];
        for(int i[] : dp) {
            Arrays.fill(i,0);
        }

        for(int j=0;j<=l2;j++) {
            dp[0][j]=j;
        }

        for(int i=0;i<=l1;i++) {
            dp[i][0]=i;
        }

        for(int i=1;i<=l1;i++) {
            for(int j=1;j<=l2;j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else { 
                    int insert=1+dp[i][j-1];
                    int delete=1+dp[i-1][j];
                    int replace=1+dp[i-1][j-1];
                    dp[i][j]=Math.min(insert,Math.min(delete,replace));
                }            
            }
        }
        return dp[l1][l2];
        //return helper(l1-1,l2-1,word1,word2);
    }

    // public int helper(int l1,int l2,String s,String t)
    // {
    //     if(l1<0) return l2+1;
    //     if(l2<0) return l1+1;
        
    //     if(dp[l1][l2]!=-1) return dp[l1][l2];
    //     if(s.charAt(l1)==t.charAt(l2)) return helper(l1-1,l2-1,s,t);
    //     int insert=1+helper(l1,l2-1,s,t);
    //     int delete=1+helper(l1-1,l2,s,t);
    //     int replace=1+helper(l1-1,l2-1,s,t);
    //     return dp[l1][l2]=Math.min(insert,Math.min(delete,replace));
    // }
}
