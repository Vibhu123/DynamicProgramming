/*
 * Given an array return the length of the longest sequence which may not be continuous which is first
 * increasing and then decreasing. This is also a variation of the LIS problem. Here in addition of having
 * an array which stores the increasing sequence we will have an array which stores the decreasing sequence.
 * lis[i] stores the LIS ending at indexi. lds[i] has the Longest Decreasing Subsequence starting at index i.
 * Finally return max(lis[i]+lds[i]-1) as arr[i] is counted twice.
 */

public class LongestBitonicSubseq {

	public static int getLength(int arr[],int n)
	{
		int lis[]=new int[n];
		for(int i=0;i<n;i++)
			lis[i]=1;
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j]&&lis[i]<lis[j]+1)
					lis[i]=lis[j]+1;
			}
		}
		int lds[]=new int[n];
		for(int i=0;i<n;i++)
			lds[i]=1;
		
		for(int i=n-2;i>=0;i--)
		{
			for(int j=n-1;j>i;j--)
			{
				if(arr[i]>arr[j]&&lds[i]<lds[j]+1)
					lds[i]=lds[j]+1;
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			if(max<(lis[i]+lds[i]-1))
				max=lis[i]+lds[i]-1;
		}
		return max;
	}
	
	public static void main(String[] args)
	{
		 int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
	              13, 3, 11, 7, 15};
		 System.out.println(getLength(arr, arr.length));
	}
	
}
