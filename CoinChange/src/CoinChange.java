/*
 * Given a set of coins C1...CM and a change of N find the number of ways in which a change
 * can be made. A classic DP problem. Both recursive and DP solutions are discussed.
 */
public class CoinChange {

	//Recursive Sol
	public static int noOfWaysRec(int arr[],int m,int n)
	{
		if(n==0)//If there is no change to be made then there is 1 soultion i.e. empty
			return 1;
		//If the change to be made is negative or if there is still some change to be made
		//but we have no coins left then.
		if(n<0||(m<=0&&n>=1))
			return 0;
		else//Include the mth coin+Exclude the mth Coin
			return noOfWaysRec(arr, m-1, n)+noOfWaysRec(arr, m, n-arr[m-1]);
	}
	//DP Sol
	public static int noOfWaysDP(int arr[],int m,int n)
	{
		int []dp=new int[n+1];//N+1 rows as the first will contain 1 as the answer
		dp[0]=1;//If there is no change then one solution empty.
		for(int i=0;i<m;i++)
		{
			for(int j=arr[i];j<=n;j++)
			{
				//Include the mth coin+Exclude the mth coin
				dp[j]=dp[j]+dp[j-arr[i]];
			}
		}
		return dp[n];
	}
	
	
	public static void main(String[] args)
	{
		int arr[]={1,2,3};
		//Recur
		System.out.println(noOfWaysRec(arr, arr.length, 4));
		//DP
		System.out.println(noOfWaysDP(arr, arr.length, 4));
	}
	
}

