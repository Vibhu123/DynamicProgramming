/*
 * A variation of LIS problem here the problem is to find the "sum" of the max inc subseq
 * in an array. So here instead of using the "length" as the criteria as was done in LIS
 * we will make the "sum" as criteria.
 */
public class MaxSumIncreasingSubseq {

	//A variation of LIS DP solution. Just use "sum" as criteria instead of "length"
	public static int getMaxSumIncSubseq(int arr[],int n)
	{
		int dp[]=new int[n];
		
		for(int i=0;i<n;i++)
			dp[i]=arr[i];
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j]&&dp[i]<dp[j]+arr[i])
					dp[i]=dp[j]+arr[i];
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			if(max<dp[i])
				max=dp[i];
		}
		return max;
	}
	
	public static void main(String[] args)
	{
		  int arr[] = {1, 101, 2, 3, 100, 4, 5};
		  System.out.println(getMaxSumIncSubseq(arr, arr.length));
	}
}
