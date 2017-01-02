/*
 * Given an array that contains the dimensions of n matrices, where arr[i]
 * represents a matrix of dimenstion arr[i-1]arr[i], compute the min cost required to 
 * compute the product for all the matrices.
 */
public class MatrixChainMult {

	//Compute Matrix Prod Rec
	public static int computeProdRec(int arr[],int i,int j)
	{
		if(i==j)
			return 0;//If only one matrix then cost is ofcourse 0.
		int min=Integer.MAX_VALUE;
		//To get the optimal solution for arr[i...j] which represents the soultion to compute
		//the cost for all the matrices a[i]a[i+1]....a[j] we are placing the parenthesis at k
		//position and calculating recursively for arr[i..k] and arr[k+1...j] which is then added
		//to the corresponding cost needed to multiply those three matrices.
		for(int k=i;k<j;k++)
		{
			int count=computeProdRec(arr, i, k)+computeProdRec(arr, k+1, j)+
					arr[i-1]*arr[k]*arr[j];
			if(count<min)
				min=count;
		}
		return min;
	}
	//DP Solution
	public static int computeProdDP(int arr[],int n)
	{
		int [][] dp=new int[n][n];
		//Leaving the first row 0 and first column 0 as it is which will be 0 by default here
		for(int i=1;i<n;i++)//If only one matrix then cost is 0
			dp[i][i]=0;
		
		for(int l=2;l<n;l++)
		{
			for(int i=1;i<n-l+1;i++)
			{
				int j=i+l-1;
				dp[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<j;k++)
				{
					int count=dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j];
					if(count<dp[i][j])
						dp[i][j]=count;
				}
			}
		}
		//Return this value as it holds to compute the optimal product for all the matrices
		//A[1...n-1] where each matrix has size of i-1,i for each i in 1...n-1.
		return dp[1][n-1];
	}
	
	public static void main(String[]args)
	{
		 int arr[] = {1, 2, 3, 4};
		 //Recur
		 System.out.println(computeProdRec(arr, 1, arr.length-1));
		 //DP
		 System.out.println(computeProdDP(arr, arr.length));
	}
}
