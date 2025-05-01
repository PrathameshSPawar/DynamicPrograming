/*You are given a positive integer 'N'. You have to reduce it to one by performing following steps.
(i). Reduce it to N-1. (N ==> N-1)
(ii). If it is divisble by 2, then divide it by 2. (N ==> N/2)
(iii). If it is divisble by 3, then divide it by 3. (N ==> N/3)

Input:
N = 16
Output: 3 (16 -> 8 -> 4 -> 2 -> 1)*/

//This is greeedy solution which may some case likie 10 etc
public static void main(String[] args) {
        Scanner pp=new Scanner(System.in);
        int n=pp.nextInt();
        int steps=0;
        while(n!=1)
        {
            if(n%2==0) n=n/2;
            else if(n%3==0) n=n/3;
            else n=n-1;
            steps++;
        }
        System.out.print(steps);
	}

//here is recursive,memorizing solution
    public static int n=(int)1e6+5;
    public static int memo[]=new int[n];
    static{
        Arrays.fill(memo,-1);
    }
    public static int top_down(int n)
    {
        if(n==1) return 0;
        
        if(memo[n]!=-1) return memo[n];
        
        int ans=(n-1)+1;
        if(n%2==0) ans=Math.min(ans,top_down(n/2)+1);
        if(n%3==0) ans=Math.min(ans,top_down(n/3)+1);
        return memo[n]=ans;
    }
	public static void main(String[] args) {
		System.out.println(top_down(10));
	}
//TC: O(N)
//ASC: O(N*N) callstack,memo

//here is using tabulation 
public static int bottom_up(int n)
    {
        int memo[]=new int[n+1];
        memo[1]=0;
        for(int i=2;i<=n;i++)
        {
            memo[i]=memo[i-1]+1;
            if(i%2==0) memo[i]=Math.min(memo[i],memo[i/2]+1);
            if(i%3==0) memo[i]=Math.min(memo[i],memo[i/3]+1);
        }
        return memo[n];
        
    }
