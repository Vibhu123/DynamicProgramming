
public class CalcBinomialCoeff {

	public static int getBinCoeffRec(int n,int k)
	{
		if(k==0||k==n)
			return 1;
		else
			return getBinCoeffRec(n-1, k)+getBinCoeffRec(n-1, k-1);
	}
	public static int getBinoCoeff(int n,int k)
	{
		int dp[]=new int[k+1];
		dp[0]=1;
		for(int i=1;i<=n;i++)
		{
			for(int j=Math.min(i, k);j>0;j--)
				dp[j]=dp[j]+dp[j-1];
		}
		return dp[k];
	}
	public static int getCoeff(int n,int k)
	{
		if(k>n-k)
			k=n-k;
		int res=1;
		for(int i=0;i<k;i++)
		{
			res=res*(n-i);
			res=res/(i+1);
		}
		return res;
	}
	
	public static void main(String[] args)
	{
		System.out.println(getBinCoeffRec(5, 2));
		System.out.println(getBinoCoeff(5, 2));
		System.out.println(getCoeff(5, 2));
	}
}
