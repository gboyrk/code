import java.io.*;
import java.util.*;
class node implements Comparator<node>
{
	int source;
	int cost;
	public node(){}
	public node(int source,int cost)
	{
		this.source=source;
		this.cost=cost;
	}
	public int compare(node n1,node n2)
	{
		if(n1.cost<n2.cost)
			return -1;
		if(n1.cost>n2.cost)
			return 1;
		if(n1.source<n2.source)
			return -1;
		return 0;
	}
}

class bestfirst
{
	int print(int parent[],int dest,int x,int h[][],int cost){
		if(parent[dest]==dest)
		{
			System.out.println("The length of the shortest path is "+x);
			System.out.println("The total sum of heuristic is "+cost);
			System.out.println("The shortest path from source node to destination node ");
			System.out.println(dest);
			return 0;
		}
System.out.println(h[dest][parent[dest]]);
		print(parent,parent[dest],x+1,h,cost+h[dest][parent[dest]]);
		System.out.println(dest);
		return 0;
	}

	void search(int src,int dest,int n,int heuristic[][],int mat[][])
	{
		PriorityQueue<node> pq=new PriorityQueue<node>(n,new node());
		int []visited=new int[n];
		int []parent=new int[n];
		int flag=0;
		for(int i=0;i<n;i++)
			parent[i]=i;
		pq.add(new node(src,heuristic[src][src]));
		visited[src]=1;
		while(!pq.isEmpty())
		{
			node nd=pq.remove();
			int cur=nd.source;
			visited[cur]=1;
			if(cur==dest)
			{
				flag=1;
				break;
			}
			for(int i=0;i<n;i++)
			{
				if(mat[cur][i]==1 && visited[i]==0)
				{
					pq.add(new node(i,heuristic[cur][i]));
					parent[i]=cur;
				}
			}
		}
		if(flag==1)
			print(parent,dest,0,heuristic,heuristic[dest][dest]);
		else
			System.out.println("Path do not exist");
	}
	public static void main(String []args)
	{
		bestfirst ob=new bestfirst();
		int src,dest,n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter source node ");
		src=sc.nextInt();
		System.out.println("Enter destination node");
		dest=sc.nextInt();
		System.out.println("Enter the file for heuristic:\n1.Bus fare\n2.Taxi fare\n3.Flight fare");
	        int fn=sc.nextInt();
String fname=" ";
	if(fn==1)
fname="input3.txt";
else if(fn==2)
fname="input4.txt";
else if(fn==3)
fname="input5.txt";
		File file = new File("input2.txt");
		File file1 = new File(fname);
		try {

			Scanner ob1 = new Scanner(file);
			Scanner ob2 = new Scanner(file);
			Scanner ob3=new Scanner(file1);
			String x=ob1.nextLine();
			StringTokenizer st=new StringTokenizer(x);
			n=0;
			while(st.hasMoreElements())
			{
				n++;
				st.nextToken();
			}
			int mat[][]=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					mat[i][j]=ob2.nextInt();
			int heuristic[][]=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
				heuristic[i][j]=ob3.nextInt();
			ob.search(src,dest,n,heuristic,mat);
		}
		catch (FileNotFoundException e) {}
	}
}
