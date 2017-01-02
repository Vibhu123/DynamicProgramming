/*
 * A cubic, O(V^3) algorithm to find the shortest distances between all pairs of vertices in a graph.
 */
public class FloydWarshall {

	public static void getAllPairShortestPaths(int graph[][],int V)
	{
		int dist[][]=new int[V][V];
		
		for(int i=0;i<V;i++)
		{
			for(int j=0;j<V;j++)
				dist[i][j]=graph[i][j];
		}
		//For all the cases where k is an intermediate vertex
		for(int k=0;k<V;k++)
		{
			//For all the cases where i is a source
			for(int i=0;i<V;i++)
			{
				//For all the cases where j is a destination
				for(int j=0;j<V;j++)
				{
					if(dist[i][k]!=Integer.MAX_VALUE&&dist[k][j]!=Integer.MAX_VALUE
							&&(dist[i][k]+dist[k][j]<dist[i][j]))
						dist[i][j]=dist[i][k]+dist[k][j];
				}
			}
		}
		//Print the shortest distance matrix
		for(int i=0;i<V;i++)
		{
			for(int j=0;j<V;j++)
			{
				if(dist[i][j]==Integer.MAX_VALUE)
					System.out.print(" INF ");
				else
					System.out.print(" "+dist[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		  int graph[][] = { {0,   5,  Integer.MAX_VALUE, 10},
                  {Integer.MAX_VALUE, 0,   3, Integer.MAX_VALUE},
                  {Integer.MAX_VALUE, Integer.MAX_VALUE, 0,   1},
                  {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
                };
		  getAllPairShortestPaths(graph, graph.length);
	}
	
}
