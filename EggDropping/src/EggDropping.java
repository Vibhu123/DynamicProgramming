/*
 * Given n eggs and k floors find the minimum number of trials such that we find the exact floor
 * from which the egg will break and below which it will not.
 * So here suppose we drop the egg from xth floor there are 2 possibilities:
 * 1. The egg breaks. So now we have x-1 floors and n-1 eggs.
 * 2. The egg does not breaks. We have k-x floors and n eggs.
 * In order to find the minimum number of trials, we take the maximum of the above 2 cases for every
 * floor and return the one with the min num of trials
 * eggDropp(n,k)= 1+min(max(eggDrop(n-1,x-1),eggDrop(n,k-x)))
 */
public class EggDropping {

	//Recursive version
	public static int getMinTrials(int n,int k)
	{
		//If there is one floor then we need one trial if there is 0 then we need 0 trial
		if(k==1||k==0)
			return k;
		//If there is only one egg then we need k (no of floors) trials
		if(n==1)
			return k;
		int min=Integer.MAX_VALUE,res;
		for(int x=1;x<=k;x++)
		{
			res=Math.max(getMinTrials(n-1, x-1), //Egg breaks
					getMinTrials(n, k-x));//Egg does not breaks
			if(res<min)
				min=res;
		}
		return min+1;
	}
	//DP version
	//table dp[i][j] indicates min no of trials needed for i eggs and j floors
	public static int getMinTrialsDP(int n,int k)
	{
		int dp[][]=new int[n+1][k+1];
		//For one floor we need 1 trial, for 0 floor we need 0 trial
		for(int i=1;i<=n;i++)
		{
			dp[i][1]=1;
			dp[i][0]=0;
		}
		//If there is only one egg we need k trials
		for(int j=1;j<=k;j++)
			dp[1][j]=j;
		
		for(int i=2;i<=n;i++)
		{
			for(int j=2;j<=k;j++)
			{
				dp[i][j]=Integer.MAX_VALUE;
				for(int x=1;x<=j;x++)
				{
					int res=Math.max(dp[i-1][x-1], dp[i][j-x])+1;
					if(res<dp[i][j])
						dp[i][j]=res;
				}
			}
		}
		return dp[n][k];
		
	}
	
	
	public static void main(String[] args)
	{
		//DP
		System.out.println(getMinTrialsDP(2, 100));
	}
}
