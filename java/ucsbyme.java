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

public class ucsbyme{
private int num;
private Queue<node> pq;
ucsbyme(int n)
{
num = n;
pq = new PriorityQueue<>(n,new node());
}
void print(int[] parent,int source,int i)
{
if(i==source)
{
System.out.println("path is " + source);
return;
}
print(parent,source,parent[i]);
System.out.println(i);
}
void search(int[][] adj,int source,int dest)
{
boolean flag=false;
int[] parent= new int[num];
int[] distance= new int[num];
for(int i=0;i<num;i++)
distance[i]=12345678;
distance[source]=0;
pq.add(new node(source,0));
while(!pq.isEmpty())
{
node ret =  pq.poll();
if(ret.first==dest)
{
System.out.println("cost is" + distance[ret.first]);
print(parent,source,dest);
flag=true;
break;
}
for(int i=0;i<num;i++)
{
if(adj[ret.first][i]!=0 && distance[i]>distance[ret.first] + adj[ret.first][i] )
{
distance[i]=distance[ret.first] + adj[ret.first][i];
pq.add(new node(i,distance[i]));
parent[i]=ret.first;
}
}
}
if(flag==false )
System.out.println("no path exist");
}
public static void main(String args[])
{
int [][] adj= new int[][]{
{0,3,0},
{3,0,0},
{0,0,0}
};
ucsbyme obj= new ucsbyme(3);
obj.search(adj,0,1);
}
}
