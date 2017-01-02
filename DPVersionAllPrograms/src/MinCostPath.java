
public class MinCostPath {

	public static int getCostRec(int arr[][],int m,int n)
	{
		if(n<0||m<0)
			return Integer.MAX_VALUE;
		else if(m==0&&n==0)
			return arr[m][n];
		else
			return Math.min(getCostRec(arr, m-1, n), 
					Math.min(getCostRec(arr, m, n-1), getCostRec(arr, m-1, n-1)))+arr[m][n];
					
	}
	
	public static int getCost(int arr[][],int m,int n)
	{
		int dp[][]=new int[m+1][n+1];
		
		dp[0][0]=arr[0][0];
		for(int i=1;i<=m;i++)
			dp[i][0]=arr[i][0]+dp[i-1][0];
		for(int j=1;j<=n;j++)
			dp[0][j]=arr[0][j]+dp[0][j-1];
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				dp[i][j]=Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]))+arr[i][j];
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args)
	{
		int arr[][] = { {1, 2, 3},{4, 8, 2},{1, 5, 3} };
		System.out.println(getCostRec(arr, arr.length-1, arr[0].length-1));
		System.out.println(getCost(arr, arr.length-1, arr[0].length-1));
	}
	
}
