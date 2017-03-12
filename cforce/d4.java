import java.util.*;
import java.io.*;

public class d4{
	static class node implements Comparator<node>{
     public  int x;
	 public int y;
	 public int z;
      node(){

	}
	 node(int a,int b,int c)
	{
		x=a;
		y=b;
		z=c;
	}
	public int compare(node a,node b)
	{
		if(a.x<b.x)
			return -1;
		else if(a.x==b.x)
		{
			if(a.y<b.y)
				return -1;
		}
		return 1;

	}
}
	public static node[] arr;
	public static void main(String arg[]) 
	{
		
		int env,he,we;
		Scanner sc= new Scanner(System.in);
		env = sc.nextInt();
        he = sc.nextInt();
        we=  sc.nextInt();
        int n= env;
        //System.out.println(we);
        arr = new node[n+1];
        for(int i=0;i<env;i++)
        {
           int a = sc.nextInt();
           int b = sc.nextInt();
           arr[i]= new node(a,b,i);
        }
       // int temp = he*we;
        arr[n]= new node(he,we,n);
        ArrayList<node> temp = new ArrayList<node>();
        Arrays.sort(arr,new node());
        HashSet<Integer> has = new HashSet<Integer>();
        int i=0;
        while(arr[i].z!=n)
        {
        //System.out.println(arr[i].x);	
        	i++;
        }
        i++;
        for(int j=i;j<=n;j++)
        {
        	if(arr[j].x>he && arr[j].y>we)
        		temp.add(arr[j]);
        }
        int [] dp = new int[temp.size()];
        int[] parent = new int[temp.size()];
        for(int x=0;x<temp.size();x++)
        	{parent[x]=-1;
        		}
        int l= temp.size();
        if(l==0)
        {
        	System.out.println("0");
        	return;
        }
        int maxm = l-1;
        //System.out.println(l+"l");
        for(int j=l-1;j>=0;j--)
        {
        	for(int  k=j+1;k<l;k++)
        	{
                if(temp.get(k).x!=temp.get(j).x && temp.get(k).y>temp.get(j).y && dp[k]+1>dp[j])
                {
                	dp[j]=dp[k]+1;
                	parent[j]=k;
                	if(dp[j]>dp[maxm])
                		maxm=j;
//System.out.println(arr[k].y+" "+arr[j].y+" "+k+" "+j);
                }
        	}
        	// System.out.println(j+" "+dp[j]);
        }
       // if(l==0)
        System.out.println((dp[maxm]+1));
        while(parent[maxm]!=-1)
        {
        	System.out.print((temp.get(maxm).z+1)+" ");
        	maxm=parent[maxm];
        }
        System.out.println(temp.get(maxm).z+1);
	}
}