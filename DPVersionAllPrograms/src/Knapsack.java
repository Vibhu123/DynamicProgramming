
public class Knapsack {

	public static int getValRec(int W,int wt[],int val[],int n)
	{
		if(n==0||W==0)
			return 0;
		if(wt[n-1]>W)
			return getValRec(W, wt, val, n-1);
		else
			return Math.max(val[n-1]+getValRec(W-wt[n-1], wt, val, n-1), 
					getValRec(W, wt, val, n-1));
	}
	
	public static int getVal(int W,int wt[],int val[],int n)
	{
		int dp[][]=new int[n+1][W+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=W;j++)
			{
				if(i==0||j==0)
					dp[i][j]=0;
				else if(wt[i-1]<=j)
					dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		return dp[n][W];
	}
	
	public static void main(String[] args)
	{
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    System.out.println(getValRec(W, wt, val, wt.length));
	    System.out.println(getVal(W, wt, val, wt.length));
	}
	
}
