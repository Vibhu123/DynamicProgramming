
public class LongestCommonSubsequence {

	public static int getLengthRec(String a,String b,int m,int n)
	{
		if(m==0||n==0)
			return 0;
		if(a.charAt(m-1)==b.charAt(n-1))
			return 1+getLengthRec(a, b, m-1, n-1);
		else
			return Math.max(getLengthRec(a, b, m-1, n), getLengthRec(a, b, m, n-1));
	}
	
	public static int getLength(String a,String b,int m,int n)
	{
		int dp[][]=new int[m+1][n+1];
		
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0||j==0)
					dp[i][j]=0;
				else if(a.charAt(i-1)==b.charAt(j-1))
					dp[i][j]=1+dp[i-1][j-1];
				else
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args)
	{
		 String a="AGGTAB";
		 String b="GXTXAYB";
		 System.out.println(getLengthRec(a, b, a.length(), b.length()));
		 System.out.println(getLength(a, b, a.length(), b.length()));
	}
	
}
