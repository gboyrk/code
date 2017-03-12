import java.util.*;
import java.io.*;
//#define sys(str) System.out.println(str);
public class bfs{
public void print(String str)
{
System.out.println(str);
}
public void rec(int[] parent,int source,int dest)
{
//print("rrr");
//for(int i=1;i<=3;i++)
//System.out.println(parent[i]);
int[] result = new int[500];
int itr=dest,i=0;
while(itr!=source)
{//print("temp");
result[i]=itr;
itr=parent[itr];
i++;
}
result[i]=source;
print("path is");
for(int j=i;j>=0;j--)
System.out.print(result[j]+"  ");
System.out.println();
}
public void bfsutil(int[][] adj,int start,int dest,int n)
{
Queue<Integer> qe= new LinkedList<>();
int[] parent= new int[n+1];
int[] cost=new int[n+1];
boolean[] visited= new boolean[n+1];
cost[start]=0;
parent[start]=0;
qe.add(start);
while(qe.size()!=0)
{
int p=qe.remove();
for(int i=1;i<=n;i++)
{
if(adj[p][i]==1 && visited[i]==false)
{
if(i==dest)
{
System.out.println("cost at dest" + (cost[p]+1));
visited[i]=true;
parent[i]=p;
rec(parent,start,dest);
return;
}
qe.add(i);visited[i]=true;
parent[i]=p;
cost[i]=cost[p]+1;
}
}
}
System.out.println("dest is not reachable");
}
public static void main(String args[])
{
try{
Scanner in= new Scanner(new File("input.txt"));
int n= in.nextInt();
int[][] adj= new int[n+1][n+1];
for(int i=1;i<=n;i++)
{
for(int j=1;j<=n;j++)
{int c= in.nextInt();adj[i][j]=c;}
}
int start=in.nextInt();
int end=in.nextInt();
 
//catch(FileNotfoundException e){}
bfs bfsobj= new bfs();
bfsobj.bfsutil(adj,start,end,n);
}
catch(Exception e){}

}

}
