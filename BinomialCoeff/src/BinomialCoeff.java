/*
 * Calculate nCk given two parameters n and k. Using the pascal's triangle formula here we get,
 * nCk= (n-1)Ck+(n-1)C(k-1).
 * Further nC0=nCn=1.
 */
public class BinomialCoeff {

	//Recursive version, exponential version
	public static int getBinomialCoeffRec(int n,int k)
	{
		if(k==0||k==n)
			return 1;
		return getBinomialCoeffRec(n-1, k)+getBinomialCoeffRec(n-1, k-1);
	}
	//DP version O(n*k) quadratic version
	public static int getBinomialCoeffsDP(int n,int k)
	{
		int dp[]=new int[k+1];
		dp[0]=1;
		
		for(int i=1;i<=n;i++)
		{
			for(int j=Math.min(i, k);j>0;j--)
			{
				dp[j]=dp[j]+dp[j-1];//Computing the next row of pascal's triangle from previous
			}
		}
		return dp[k];
	}
	
	//Better version linear one
	public static int getBinomialCoeff(int n,int k)
	{
		int result=1;
		//nCk=nCn-k if k>n-k
		if(k>n-k)
			k=n-k;
		for(int i=0;i<k;i++)
		{
			result=result*(n-i);
			result=result/(i+1);
		}
		return result;
	}
	
	
	public static void main(String[] args)
	{
		//Recur
		System.out.println(getBinomialCoeffRec(5, 2));
		//DP
		System.out.println(getBinomialCoeffsDP(5, 2));
		//Linear version
		System.out.println(getBinomialCoeff(5, 2));
	}
	
}
