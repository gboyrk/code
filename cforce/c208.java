import java.util.*;
public class node{
	int a;
	int b;
	node()
	{

	}
	node(int x,int y)
	{
     a=x;
     b=y;
	}
}
public class c208{
	List<Integer> [] adj;
	List<Integer>[] parent;
	public static void bfs(int start,int end,int n)
	{
	 	boolean visited[] = new boolean[n]; 
	 	Queue<Integer> que = new Queue<Integer>();
		que.add(new node(start,0));
		while(!que.isEmpty())
		{
			node rm = que.remove();
			visited[rm.x]=true;
			if(rm.x==end)
			{
				flag=1;
				break;
			}
			for(int i=0;i<adj[rm.x].size();i++)
			{
			    int j = adj[rm.x].get(i);
			    if(!visited[j])
			    {
			    	que.add(j,rm.y+1);
			    	parent[j].add(rm.x);
			    }

			}
		}

	}
	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in); 
		int n,m;
		n=sc.nextInt();
		m=sc.nextInt();
		adj =(List<Integer>[]) new List[n];
		for(int i=0;i<n;i++)
		{
        adj[i]= new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++)
		{
			int a=sc.nextInt();
			int b=sc.nextInt();
			a=a-1;b=b-1;
			adj[a].add(b);
			adj[b].add(a); 
		}
		bfs(0,n-1);


	}
}