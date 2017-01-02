
public class RodCutting {

	public static int getLengthRec(int price[],int n)
	{
		if(n<=0)
			return 0;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
			max=Math.max(max, price[i]+getLengthRec(price, n-i-1));
		return max;
	}
	public static int getLength(int price[],int n)
	{
		int dp[]=new int[n+1];
		dp[0]=0;
		
		for(int i=1;i<=n;i++)
		{
			int maxVal=Integer.MIN_VALUE;
			for(int j=0;j<i;j++)
			{
				maxVal=Math.max(maxVal, price[j]+getLength(price, i-j-1));
			}
			dp[i]=maxVal;
		}
		return dp[n];
	}
	
	public static void main(String[] args)
	{
		 int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
		 System.out.println(getLengthRec(arr, arr.length));
		 System.out.println(getLength(arr, arr.length));
	}
}
