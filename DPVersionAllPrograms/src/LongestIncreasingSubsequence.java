
public class LongestIncreasingSubsequence {

	static int maxLength;
	
	public static int getLengthRec(int arr[],int n)
	{
		if(n<=1)
			return n;
		int currSeqLength=1;
		for(int i=0;i<n-1;i++)
		{
			int subProblemLength=getLengthRec(arr, i+1);
			if(arr[i]<arr[n-1]&&currSeqLength<(1+subProblemLength))
				currSeqLength=1+subProblemLength;
		}
		if(maxLength<currSeqLength)
			maxLength=currSeqLength;
		return currSeqLength;
	}
	
	public static int getLength(int arr[],int n)
	{
		int dp[]=new int[n];
		for(int i=0;i<n;i++)
			dp[i]=1;
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j]&&dp[i]<dp[j]+1)
					dp[i]=dp[j]+1;
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
		int arr[]={10, 22, 9, 33, 21, 50, 41,60,70,80};
		System.out.println(getLengthRec(arr, arr.length));
		System.out.println(getLength(arr, arr.length));
	}
	
}
