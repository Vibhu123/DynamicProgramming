/*
 * Find the min cost to reach a position (m,n) in a matrix starting from top left corner.
 * Each cell represents the cost to traverse itself.Now from each cell (i,j) one can 
 * either go right (i,j+1), or bottom (i+1,j) or diagonal (i+1,j+1). So if we start
 * from the desired position these moves will be reversed which is done in solution below. 
 */
public class MinCostPath {

	//Recursive version
	public static int minCostPathRecur(int arr[][],int m,int n)
	{
		if(n<0||m<0)//If we go to negative state while recursing return MAX value
			return Integer.MAX_VALUE;
		else if(n==0&&m==0)//If we reach at the desired position return the cell value
			return arr[m][n];
		else//Recur for the rest and return the min of them + cost of current cell
			return Math.min(minCostPathRecur(arr, m-1, n), //Up
					Math.min(minCostPathRecur(arr, m, n-1), //Left
							minCostPathRecur(arr, m-1, n-1)))+arr[m][n];//Diagonal
	}
	//DP Version
	public static int minCostPathDP(int arr[][],int m,int n)
	{
		int [][] dp=new int[m+1][n+1];
		dp[0][0]=arr[0][0];
		for(int i=1;i<=m;i++)
			dp[i][0]=arr[i][0]+dp[i-1][0];
		for(int j=1;j<=n;j++)
			dp[0][j]=arr[0][j]+dp[0][j-1];
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				dp[i][j]=Math.min(dp[i-1][j], Math.min(dp[i][j-1], 
						dp[i-1][j-1]))+arr[i][j];
			}
		}
		return dp[m][n];
	}
	
	
	public static void main(String[] args)
	{
		int arr[][] = { {1, 2, 3},{4, 8, 2},{1, 5, 3} };
		
		//Recur
		System.out.println(minCostPathRecur(arr, arr.length-1, arr[0].length-1));
		//DP
		System.out.println(minCostPathDP(arr, arr.length-1, arr[0].length-1));
		
	}
	
}
