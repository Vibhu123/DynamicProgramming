
public class LongestPalindromicSubseq {

	public static int getLengthRec(String a,int i,int j)
	{
		if(i==j)
			return 1;
		if(a.charAt(i)==a.charAt(j)&&i+1==j)
			return 2;
		else if(a.charAt(i)==a.charAt(j))
			return getLengthRec(a, i+1, j-1)+2;
		else
			return Math.max(getLengthRec(a, i+1, j), getLengthRec(a, i, j-1));
	}
	public static int getLength(String a,int n)
	{
		int dp[][]=new int[n][n];
		for(int i=0;i<n;i++)
		{
			dp[i][i]=1;
		}
		for(int l=2;l<=n;l++)
		{
			for(int i=0;i<n-l+1;i++)
			{
				int j=i+l-1;
				if(a.charAt(i)==a.charAt(j)&&l==2)
					dp[i][j]=2;
				else if(a.charAt(i)==a.charAt(j))
					dp[i][j]=dp[i+1][j-1]+2;
				else
					dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
			}
		}
		return dp[0][n-1];
	}
	
	
	public static void main(String[] args)
	{
		String seq="BBABCBCAB";
		System.out.println(getLengthRec(seq, 0, seq.length()-1));
		System.out.println(getLength(seq, seq.length()));
	}
	
}
