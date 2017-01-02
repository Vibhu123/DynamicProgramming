/*
 * Given two strings get the minimum cost to convert one string to another, given
 * the following three operations could be performed where for each of them the cost is 1.
 * : Inseert a character
 * : Remove a character
 * : Replace a character
 * Below the three operations are performed with respect to first string i.e. convert first
 * string to second string
 */
public class ConvertOneStrToAnother {

	
	//Recursive version m length of string a, n length of string b
	public static int convertRec(String a,String b,int m,int n)
	{
		if(m==0)//If first string empty then length of second string insert n characters
			return n;
		if(n==0)//Similarly if second is empty then cost is length of first string
			return m;
		if(a.charAt(m-1)==b.charAt(n-1))//If the last characters match recur for remaining
			return convertRec(a, b, m-1, n-1);
		else
			return 1+Math.min(convertRec(a, b, m, n-1),//Insert a character 
							Math.min(convertRec(a, b, m-1, n),//Remove a character 
									convertRec(a, b, m-1, n-1)));//Replace a character
	}
	
	
	//DP version same subproblems are solved again and again and it has OPSubstructure
	public static int convertDP(String a,String b,int m,int n)
	{
		int[][] dp=new int[m+1][n+1];//dp[m][n] will hold the result
		
		//Table is filled in bottom up manner
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
					dp[i][j]=1+Math.min(dp[i][j-1], //Insert
							Math.min(dp[i-1][j],//Remove 
									dp[i-1][j-1]));//Replace
			}
		}
		return dp[m][n];
	}
	
	
	
	public static void main(String[] args)
	{
		String a="sisterhood";
		String b="brotherhood";
		
		//Recur
		System.out.println(convertRec(a, b, a.length(), b.length()));
		//DP
		System.out.println(convertDP(a, b, a.length(), b.length()));
		
		
	}
	
}
