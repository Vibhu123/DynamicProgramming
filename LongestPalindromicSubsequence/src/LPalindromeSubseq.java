
public class LPalindromeSubseq {

	//Recursive version
	public static int getLength(String seq,int i,int j)
	{
		// If there is only one character then length is 1
		if(i==j)
			return 1;
		//If the first and last are same and only 2 characters
		if(seq.charAt(i)==seq.charAt(j)&&i+1==j)
			return 2;
		//If the first and last char same
		if(seq.charAt(i)==seq.charAt(j))
			return getLength(seq, i+1, j-1)+2;
		//Else return max of the two possible remaining sequences
		else
			return Math.max(getLength(seq, i, j-1), getLength(seq, i+1, j));
	}
	//DP version
	public static int getLengthDP(String seq,int n)
	{
		int dp[][]=new int[n][n];
		for(int i=0;i<n;i++)
		{
			dp[i][i]=1;//Length is 1 for same character
		}
		for(int l=2;l<=n;l++)
		{
			for(int i=0;i<n-l+1;i++)
			{
				int j=i+l-1;
				if(l==2&&seq.charAt(i)==seq.charAt(j))
					dp[i][j]=2;
				else if(seq.charAt(i)==seq.charAt(j))
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
		//recur
		System.out.println(getLength(seq, 0, seq.length()-1));
		//dp
		System.out.println(getLengthDP(seq, seq.length()));
	}
}
