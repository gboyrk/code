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
class ucs
{
int print(int parent[],int dest,int x){
		if(parent[dest]==dest)
		{
			System.out.println("The length of the shortest path is "+x);
			System.out.println("The shortest path from source node to destination node is "); 
		System.out.println(dest);
			return 0;
		}
		print(parent,parent[dest],x+1);
		System.out.println(dest);
		return 0;
	}
void search(int mat[][],int src,int dest,int n)
{
int rm;
PriorityQueue pq=new PriorityQueue<>(n,new node());
int distance[]=new int[n+1];
int parent[]=new int[n+1];

for(int i=0;i<=n;i++)
{
distance[i]=10000000;
parent[i]=i;
}
pq.add(new node(src,0));
distance[src]=0;
while(!pq.isEmpty())
{
node nd=(node)pq.remove();
rm=nd.source;
for(int i=0;i<n;i++)
{
if(mat[rm][i]!=0)
{
if(distance[i]>mat[rm][i]+distance[rm])
{
distance[i]=mat[rm][i]+distance[rm];
parent[i]=rm;
pq.add(new node(i,distance[rm]));
}
}
}
}
print(parent,dest,0);
System.out.println("THE COST IS: "+distance[dest]);
}
public static void main(String []args)
{
	ucs ob=new ucs();
		int src,dest,n;
Scanner sc=new Scanner(System.in);
System.out.println("Enter source node ");
src=sc.nextInt();
System.out.println("Enter destination node");
dest=sc.nextInt();
		File file = new File("input1.txt");

		try {

Scanner ob1 = new Scanner(file);
Scanner ob2 = new Scanner(file);
String x=ob1.nextLine();
StringTokenizer st=new StringTokenizer(x);
n=0;
while(st.hasMoreElements())
{
n++;
String i=st.nextToken();
//System.out.println("yo" + i);
}
int mat[][]=new int[n][n];
for(int i=0;i<n;i++)
for(int j=0;j<n;j++)
mat[i][j]=ob2.nextInt();		
                ob.search(mat,src,dest,n);
		} 
		catch (FileNotFoundException e) {}
		}

}
