
public class LongestCommonSubseq {

	//Recursive Approach
	public static int lcsRec(String a,String b,int m,int n)
	{
		if(m==0||n==0)//Nothing left to compare in both or in either
			return 0;
		if(a.charAt(m-1)==b.charAt(n-1))//If last character match go back in both from the end
			return 1+lcsRec(a, b, m-1, n-1);
		else//Return max of both the scenarios one char for each string from the end
			return Math.max(lcsRec(a, b, m-1, n), lcsRec(a, b, m, n-1));
	}
	//DP Approach
	public static int lcsDP(String a,String b,int m,int n)
	{
		int[][] LCS=new int[m+1][n+1];
		
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0||j==0)
					LCS[i][j]=0;
				else if(a.charAt(i-1)==b.charAt(j-1))
					LCS[i][j]=LCS[i-1][j-1]+1;
				else
					LCS[i][j]=Math.max(LCS[i-1][j], LCS[i][j-1]);
			}
		}
		return LCS[m][n];
	}
	
	
	public static void main(String[] args)
	{
		 String a="AGGTAB";
		 String b="GXTXAYB";
		 //Rec Approach
		 System.out.println("Rec Length is "+lcsRec(a, b, a.length(), b.length()));
		 //DP Approach
		 System.out.println("DP Length is "+lcsDP(a, b, a.length(), b.length()));
		 
	}
	
}
