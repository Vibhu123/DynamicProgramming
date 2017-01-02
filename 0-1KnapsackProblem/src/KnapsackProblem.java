/*
 *Given a knapsack of W capacity and two arrays of containing weights and values of n items
 *find the items which will give the maximum value such that they do not exceed the knapsack
 *weight.
 */

public class KnapsackProblem {

	//Recursive structure
	public static int getMaxVal(int W,int val[],int w[],int n)
	{
		if(n==0||W==0)
			return 0;
		if(w[n-1]>W)
			return getMaxVal(W, val, w, n-1);
		else
			return Math.max(val[n-1]+getMaxVal(W-w[n-1], val, w, n-1), 
					getMaxVal(W, val, w, n-1));
	}
	//DP version
	public static int getMaxValDP(int W,int val[],int wt[],int n)
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
	    
	    //Recursive version
	    System.out.println(getMaxVal(W, val, wt, wt.length));
	    //DP Version
	    System.out.println(getMaxValDP(W, val, wt, wt.length));
	}
	
}
