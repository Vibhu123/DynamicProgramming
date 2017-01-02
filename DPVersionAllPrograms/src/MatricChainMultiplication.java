
public class MatricChainMultiplication {

	public static int getMinMultsRec(int arr[],int i,int j)
	{
		if(i==j)
			return 0;
		int minCost=Integer.MAX_VALUE;
		for(int k=i;k<j;k++)
		{
			int count=getMinMultsRec(arr, i, k)+getMinMultsRec(arr, k+1, j)+
					arr[i-1]*arr[k]*arr[j];
			if(count<minCost)
				minCost=count;
		}
		return minCost;
	}
	
	public static int getMinMults(int arr[],int n)
	{
		int dp[][]=new int[n][n];
		for(int i=1;i<n;i++)
			dp[i][i]=0;
		
		for(int l=2;l<n;l++)
		{
			for(int i=1;i<n-l+1;i++)
			{
				int j=i+l-1;
				dp[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<j;k++)
				{
					int count=dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j];
					if(count<dp[i][j])
						dp[i][j]=count;
				}
			}
		}
		return dp[1][n-1];
	}
	
	
	public static void main(String[] args)
	{
		 int arr[] = {1, 2, 3, 4};
		 System.out.println(getMinMultsRec(arr, 1, arr.length-1));
		 System.out.println(getMinMults(arr, arr.length));
	}
	
}
