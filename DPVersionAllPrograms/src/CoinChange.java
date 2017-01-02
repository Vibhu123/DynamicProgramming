
public class CoinChange {

	public static int getChangeRec(int arr[],int m,int n)
	{
		if(n==0)
			return 1;
		if(n<0)
			return 0;
		if(m<=0&&n>=1)
			return 0;
		else
			return getChangeRec(arr, m-1, n)+getChangeRec(arr, m, n-arr[m-1]);
	}
	
	public static int getChange(int arr[],int m,int n)
	{
		int dp[]=new int[n+1];
		dp[0]=1;
		
		for(int i=0;i<m;i++)
		{
			for(int j=arr[i];j<=n;j++)
			{
				dp[j]=dp[j]+dp[j-arr[i]];
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args)
	{
		int arr[]={1,2,3};
		System.out.println(getChangeRec(arr, arr.length, 4));
		System.out.println(getChange(arr, arr.length, 4));
	}
}
