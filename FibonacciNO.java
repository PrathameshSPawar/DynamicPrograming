import java.util.*;
public class Main
{
    public static int n=(int) 1e6+5;
    public static int memo[]=new int[n];
    static {
        Arrays.fill(memo,-1);
    }
    
    public static int fibo(int n)
    {
        if(n==0) return 0;
        if(n==1) return 1;
        
        if(memo[n]!=-1) return memo[n];
        
        return memo[n]=fibo(n-1)+fibo(n-2);
    }
	public static void main(String[] args) {
		System.out.println(fibo(6));
	}
}
