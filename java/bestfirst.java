import java.util.*;
import java.io.*;
class node implements Comparator<node>{
int first;
int second;
public node(){
}

public node(int a,int b){
this.first=a;
this.second=b;
}
@Override
public int compare(node node1,node node2)
{
if(node1.second<node2.second)
return -1;
else if(node1.second>node2.second)
return 1;
else if(node1.first<node2.first)
return -1;
return 0;
}
@Override
public boolean equals(Object obj)
{
if(obj instanceof node)
{
node n1=(node)obj;
if(this.first==n1.first)
{
return true;
}
}
return false;
}
}

public class bestfirst{
private int num;
private Queue<node> pq;
bestfirst(int n)
{
num = n;
pq = new PriorityQueue<>(n,new node());
}
void print(int[] parent,int[][] heur,int source,int i,int cost)
{
if(i==source)
{
System.out.println("total cost is"+ cost);
System.out.println("path is " + source);
return;
}
print(parent,heur,source,parent[i],cost+heur[i][parent[i]] );
System.out.println(i);
}
void search(int[][] adj,int[][] heur,int source,int dest)
{
boolean flag=false;
int[] parent= new int[num];
boolean[] visited= new boolean[num];
pq.add(new node(source,heur[source][source]));
visited[source]=true;
while(!pq.isEmpty())
{
node ret =  pq.poll();
visited[ret.first]=true;
if(ret.first==dest)
{
print(parent,heur,source,dest,heur[dest][dest]);
flag=true;
break;
}
for(int i=0;i<num;i++)
{
if(adj[ret.first][i]!=0 && visited[i]==false)
{
pq.add(new node(i,heur[ret.first][i]));
parent[i]=ret.first;
}
}
}
if(flag==false )
System.out.println("no path exist");
}
public static void main(String args[])
{

try{
Scanner n1 = new Scanner(new File("input2.txt"));
String temp=n1.nextLine();
StringTokenizer obj = new StringTokenizer(temp);
int n=0;
while(obj.hasMoreTokens())
{
obj.nextToken();
n++;
}
n1.close();
int[][] adj= new int[n][n];
Scanner n2= new Scanner(new File("input2.txt"));
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
adj[i][j]=n2.nextInt();
}
n2.close();




Scanner sc= new Scanner(System.in);
System.out.println("Enter source node ");
int src=sc.nextInt();
System.out.println("Enter destination node");
int dest=sc.nextInt();
String fname="";
System.out.println("enter the heuristic file no. as 1 for taxi fare 2. for train fare 3. bullcar fare");
int opt=sc.nextInt();
sc.close();
if(opt==1)
fname="input3.txt";
else if(opt==2)
fname="input4.txt";
else
fname="input5.txt";
Scanner n3= new Scanner(new File(fname));
int[][] heur = new int[n][n];
for(int i=0;i<n;i++)
for(int j=0;j<n;j++)
heur[i][j]=n3.nextInt();
bestfirst bst= new bestfirst(n);
bst.search(adj,heur,src,dest);
}catch(Exception e){}
}
}
