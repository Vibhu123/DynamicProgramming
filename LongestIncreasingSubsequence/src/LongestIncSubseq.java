import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*Given an array find the longest increasing subsequence 
 * Here LIS means that arr[i]>arr[j] for 0<j<i
 * L(i)=1+max(L(j)) for o<j<i where L(i) represents the LIS ending at index i
 * A classic DP version both recursive and tabulated versions are discussed below
*/

public class LongestIncSubseq {

	static int maxIncSeq;
	//Recursive Approach
	public static int longestIncSubseqRec(int arr[],int n)
	{
		if(n<=1)
			return n;
		int currSeqLen=1;
		for(int i=0;i<n-1;i++)
		{
			int subSeqLen=longestIncSubseqRec(arr, i+1);
			//Append arr[n-1] to the LIS lisr as it follows the LIS property
			if(arr[i]<arr[n-1]&&currSeqLen<(1+subSeqLen))
				currSeqLen=1+subSeqLen;
			
		}
		if(maxIncSeq<currSeqLen)
			maxIncSeq=currSeqLen;
		return currSeqLen;
	}
	
	//Tabulated Approach DP
	public static int getLIS(int arr[])
	{
		int[] lis=new int[arr.length];
		for(int i=0;i<lis.length;i++)
			lis[i]=1;//Initialize all to 1 as all by themselves are LIS
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j]&&lis[i]<lis[j]+1)//Check that it follows LIS property
				{	
					lis[i]=lis[j]+1;
				}
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<lis.length;i++)
		{
			if(max<lis[i])
				max=lis[i];
		}
		
		return max;
	}
	
	public static void main(String[] args)
	{
		int arr[]={10, 22, 9, 33, 21, 50, 41,60,70,80};
		//Recursive Approach
		longestIncSubseqRec(arr,arr.length);
		System.out.println(maxIncSeq);
		//DP Approach
		System.out.println(getLIS(arr));
		
		
	}
}
