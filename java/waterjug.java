import java.util.*;
import java.io.*;
class node implements Comparator<node>
{
int x;
int y;
int cost;
int heur;
int total;
public node(){}
public node(int x1,int y1,int c,int h,int f)
{
this.x=x1;
this.y=y1;
this.cost=c;
this.heur=h;
this.total=f;
}
public int compare(node n1,node n2)
{
 if(n1.total<n2.total)
 return -1;
 else if(n1.cost<n2.cost)
  return -1;
return 1;

}
}
public class waterjug{
public static	int last_x;
int print(node parent[][],node dest,int x){
    node z=parent[dest.x][dest.y];
    if(z.x==-2 && z.y==-2)
    {
      System.out.println("The Shortest path length is " +  x);
      System.out.print("water level in first and second jug    ");
      System.out.println(dest.x+" and  "+dest.y + " respectively");
      return 0;
    }
    print(parent,parent[dest.x][dest.y],x+1);
    System.out.print("water level in first and second jug    ");
      System.out.println(dest.x+" and  "+dest.y + " respectively");
    return 0;
  }
   int heur(int x ,int y)
   {
          return Math.abs(y-last_x);
   }
  void search(int x,int y,int last_x,int last_y)
	{
		//int[][] mat = new int[x+1][y+1];
    //System.out.println(last_x);
    int flag=0;
    node[][] parent = new node[1000][1000];
     for(int i=0;i<x+1;i++)
      for(int j=0;j<y+1;j++){
        parent[i][j]=new node(-1,-1,0,0,0);
      }
		PriorityQueue<node> pq=new PriorityQueue<node>(last_x,new node());
		boolean visited[][] = new boolean[x+1][y+1]; 
		//node parent[][] = new node[x+1][y+1];
		int h = heur(x,y);
		int cost=0;
    parent[0][0]=new node(-2,-2,0,0,0);
		pq.add(new node(0,0,0,h,h));
    node rm=new node();
        while(!pq.isEmpty())
        {
        	 rm=pq.remove();
      
        if(visited[rm.x][rm.y]==false)
        {
            visited[rm.x][rm.y]=true;
        if(rm.x==last_x)
        {
            flag=1;
        break;
        }
        if(rm.x==0)
        {
            node temp1=new node(x,rm.y,cost+1,heur(x,rm.y),(cost+1+heur(x,rm.y)));
            pq.add(temp1);
            node w=parent[temp1.x][temp1.y];
          if(w.x==-1 && w.y==-1)
            parent[temp1.x][temp1.y]=rm;
        }
        if(rm.y==0)
        {
            node temp1=new node(rm.x,y,cost+1,heur(rm.x,y),(cost+1+heur(rm.x,y)));
            pq.add(temp1);
            node w=parent[temp1.x][temp1.y];
            if(w.x==-1 && w.y==-1)
            parent[temp1.x][temp1.y]=rm;
        }
        if(rm.x>0)
        {
             node temp1=new node(0,rm.y,cost+1,heur(0,rm.y),(cost+1+heur(0,rm.y)));
            pq.add(temp1);
             node w=parent[temp1.x][temp1.y];
            if(w.x==-1 && w.y==-1)
           parent[temp1.x][temp1.y]=rm;
        }
        if(rm.y>0)
        {
             node temp1=new node(rm.x,0,cost+1,heur(rm.x,0),(cost+1+heur(rm.x,0)));
            pq.add(temp1);
             node w=parent[temp1.x][temp1.y];
           if(w.x==-1 && w.y==-1)
           parent[temp1.x][temp1.y]=rm;
        }
        if(rm.y<y && rm.x>0)
        {
            int z=Math.min(y-rm.y,rm.x);
             node temp1=new node(rm.x-z,rm.y+z,cost+1,heur(rm.x-z,rm.y+z),(cost+1+heur(rm.x-z,rm.y+z)));
            pq.add(temp1);
            node w=parent[temp1.x][temp1.y];
        if(w.x==-1 && w.y==-1)
            parent[temp1.x][temp1.y]=rm;
        }
        if(rm.y>0 && rm.x<x)
        {
            int z=Math.min(x-rm.x,rm.y);
             node temp1=new node(rm.x+z,rm.y-z,cost+1,heur(rm.x+z,rm.y-z),(cost+1+heur(rm.x+z,rm.y-z)));
             pq.add(temp1);
            node w=parent[temp1.x][temp1.y];
           if(w.x==-1 && w.y==-1)
            parent[temp1.x][temp1.y]=rm;
        }
        }

        }
    if(flag==0)
    System.out.println("Cannot measure the given quantity");
    else
    print(parent,rm,0);


	}
	public static void main(String arg[])
	{
       waterjug obj = new waterjug();
       Scanner sc = new Scanner(System.in);
       System.out.println("enter the water capactiy for first jug");
       int x = sc.nextInt();
       System.out.println("enter the water capactiy for first jug");
       int y = sc.nextInt();
       System.out.println("enter the final capacity of first jug");
        last_x = sc.nextInt();
       obj.search(x,y,last_x,0); 
	}
}