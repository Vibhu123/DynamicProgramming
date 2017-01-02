/*
 * Given a string find the minimum number of cuts required to cut the string into substrings
 * such that every substring is a palindrome. If the string is itself palindrome the cuts required
 * 0 and if the entire string is not then n-1 cuts are required for string of length n as then every
 * character is a palindrome.
 */
public class PalindromePartition {

	public static int getMinCuts(String a,int n)
	{
		int C[]=new int[n];//Array that holds the cut required. C[i] indicates cut required for string[0...i]. Its value is 0 if string is palindrome
		boolean P[][]=new boolean[n][n];//Arrqy that indicates whether the string [i...j] is palindrome in which case its value is true
		
		for(int i=0;i<n;i++)
		{
			P[i][i]=true;//String with the only character is a palindrome;
		}
		//Get all the possible palindromes in a string
		for(int l=2;l<=n;l++)
		{
			for(int i=0;i<n-l+1;i++)
			{
				int j=i+l-1;
				if(l==2)
					P[i][j]=(a.charAt(i)==a.charAt(j));//If length is 2 just compare the two characters
				else
					P[i][j]=(a.charAt(i)==a.charAt(j))&&P[i+1][j-1];//Else compare the current first and last chars and make sure the previous first and last chars also make palindrome
			}
		}
		for(int i=0;i<n;i++)
		{
			if(P[0][i]==true)
				C[i]=0;
			else
			{
				C[i]=Integer.MAX_VALUE;
				for(int j=0;j<i;j++)
				{
					if(P[j+1][i]==true&&C[i]>1+C[j])
						C[i]=1+C[j];
				}
			}
		}
		return C[n-1];
	}
	
	public static void main(String[] args)
	{
		String a = "ababbbabbababa";
		System.out.println("Min cuts required are "+getMinCuts(a, a.length()));
	}
}
