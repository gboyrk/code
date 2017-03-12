import java.util.*;
import java.io.*;
public class c104{
	static List<Integer>[] adj;
	static boolean []visited;
	static int vertex;
	static int pare;
	static boolean cycle;
	public static void dfs(int ind,int par)
	{
		visited[ind]=true;
		for(int i=0;i<adj[ind].size();i++)
		{
			int j = adj[ind].get(i);
			if(visited[j] && j!=par && !cycle)
			{
            vertex=j;
            pare=ind;
            cycle=true;
            adj[ind].remove(i);
            for(int x=0;x<adj[j].size();x++)
            {
            	if(adj[j].get(x)==ind)
            	{
            		adj[j].remove(x);
            		break;
            	}
            }
           // System.out.println(adj[ind]);
            //System.out.println(adj[j]);
             }
			else if(!visited[j])
			{
               dfs(j,ind);
			}
		}
	}
	public static void main(String arg[])
	{
		int n,m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m= sc.nextInt();
		adj = (List<Integer>[]) new List[n];
		for(int i=0;i<n;i++)
			adj[i]= new ArrayList<Integer>();
		for(int i=0;i<m;i++)
		{
			int a=sc.nextInt();
			int b=sc.nextInt();
			a=a-1;
			b=b-1;
			adj[a].add(b);
			adj[b].add(a);
		}
		 visited= new boolean[n];
		cycle=true;
		dfs(0,-1);
        for(int i=0;i<n;i++)
         {
         	if(visited[i]==false)
         		{
		System.out.println("NO");return;}
         	visited[i]=false;
         }
cycle=false;
		// visited= new boolean[n];
		dfs(0,-1);
		if(cycle==false){
		System.out.println("NO");return;}
         cycle=false;
         //System.out.println(vertex+" "+pare);
         for(int i=0;i<n;i++)
         {
         	visited[i]=false;
         }
         dfs(0,-1);
         if(cycle==true)
         	System.out.println("NO");
         else
         	System.out.println("FHTAGN!");
         //System.out.println(vertex+" "+pare);

	}
}