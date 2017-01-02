
public class EditDistance {

	public static int getEditDistRec(String a,String b,int m,int n)
	{
		if(m==0)
			return n;
		if(n==0)
			return m;
		if(a.charAt(m-1)==b.charAt(n-1))
			return getEditDistRec(a, b, m-1, n-1);
		else
			return 1+Math.min(getEditDistRec(a, b, m, n-1), //Insert
					Math.min(getEditDistRec(a, b, m-1, n), //Remove
							getEditDistRec(a, b, m-1, n-1)));//Replace
	}
	
	public static int getEditDistDP(String a,String b,int m,int n)
	{
		int dp[][]=new int[m+1][n+1];
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0)
					dp[i][j]=j;
				else if(j==0)
					dp[i][j]=i;
				else if(a.charAt(i-1)==b.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				else
					dp[i][j]=1+Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args)
	{
		String a="sisterhood";
		String b="brotherhood";
		System.out.println(getEditDistRec(a, b, a.length(), b.length()));
		System.out.println(getEditDistDP(a, b, a.length(), b.length()));
	}
	
}
