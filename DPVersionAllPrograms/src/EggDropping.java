
public class EggDropping {

	public static int getMinFloorRec(int n,int k)
	{
		if(k==0||k==1)
			return k;
		if(n==1)
			return k;
		int min=Integer.MAX_VALUE;
		for(int x=1;x<=k;x++)
		{
			int val=Math.max(getMinFloorRec(n-1, x-1), getMinFloorRec(n, k-x));
			if(val<min)
				min=val;
		}
		return min+1;
	}
	
	public static int getMinFloor(int n,int k)
	{
		int dp[][]=new int[n+1][k+1];
		
		for(int i=1;i<=n;i++)
		{
			dp[i][0]=0;
			dp[i][1]=1;
		}
		for(int j=1;j<=k;j++)
		{
			dp[1][j]=j;
		}
		for(int i=2;i<=n;i++)
		{
			for(int j=2;j<=k;j++)
			{
				dp[i][j]=Integer.MAX_VALUE;
				for(int x=1;x<=j;x++)
				{
					int val=Math.max(dp[i-1][x-1], dp[i][j-x])+1;
					if(val<dp[i][j])
						dp[i][j]=val;
				}
			}
		}
		return dp[n][k];
	}
	
	public static void main(String[] args)
	{
		//System.out.println(getMinFloorRec(2, 100));
		System.out.println(getMinFloor(2, 100));
	}
}
