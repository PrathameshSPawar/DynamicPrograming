//https://leetcode.com/problems/wildcard-matching/description/
class Solution {
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        int l1=s.length();
        int l2=p.length();
        dp=new Boolean[l1+1][l2+1];
        dp[0][0]=true;
        
        for(int i=1;i<=l1;i++) {
            dp[i][0]=false;
        }

        for(int i=1;i<=l2;i++) {
            boolean flag=true;
            for(int ii=1;ii<=i;ii++) {
                if(p.charAt(ii-1)!='*') {
                    flag=false;
                }
            }

            dp[0][i]=flag;
        }


        for(int i=1;i<=l1;i++) {
            for(int j=1;j<=l2;j++) {
                if(s.charAt(i-1)==p.charAt(j-1)  || p.charAt(j-1)=='?') {
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1] || dp[i-1][j];
                }else {
                    dp[i][j]=false;
                }
            }
        }

        return dp[l1][l2];
        //return helper(l1-1,l2-1,s,p);
    }

    public boolean helper(int l1,int l2,String s,String t)
    {
        if(l1<0 && l2<0) return true;
        if(l1>=0 && l2<0) return false;
        if(l1<0 && l2>=0) {
            for(int i=l2;i>=0;i--)
            {
                if(t.charAt(i)!='*') return false;
            }
            return true;
        }
        if(dp[l1][l2]!=null) return dp[l1][l2];

        if(s.charAt(l1)==t.charAt(l2) || t.charAt(l2)=='?') { 
            return dp[l1][l2]=helper(l1-1,l2-1,s,t);
        }

        if(t.charAt(l2)=='*') {
            return dp[l1][l2]=helper(l1,l2-1,s,t) || helper(l1-1,l2,s,t);
        }

        return false;
    }
}
