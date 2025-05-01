/*
Another Count Bits Problem
Print the number of set bits in each from 1 to N.
Input:
N = 5
Output: 1 1 2 1 2
*/

import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner pp=new Scanner(System.in);
	    int n=pp.nextInt();
	    int dp[]=new int[n+1];
	    dp[0]=0;
	    for(int i=1;i<=n;i++)
	    {
	        //dp[i]=dp[i/2] + (i&1);
	        dp[i]=dp[i/2] + (i%2);
	        System.out.print(dp[i]+ " ");
	    }
	}
}


public class Main
{
    public static int n=(int)1e5+6;
    public static int dp[]=new int[n];
    
    public static int countSet(int n)
    {
        if(n==0) return dp[0]=0;
        if(n==1) return dp[1]=1;
        if(n==2) return dp[2]=1;
        //if(n==3) return dp[3]=2;
        
        if(n%2==0) dp[n]=dp[n/2];
        else dp[n]=dp[n/2]+1;
        return dp[n];
    }
	public static void main(String[] args) {
	    Scanner pp=new Scanner(System.in);
	    int n=pp.nextInt();
	    for(int i=1;i<=n;i++)
	    {
	        System.out.println(countSet(i));
	    }
	}
}
