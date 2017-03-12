import java.util.*;

public class a782{
	public static void main(String arg[])
{	Scanner sc = new Scanner(System.in);
	int n= sc.nextInt();
	int[] check = new int[n+1];
   // int[] arr = new int[2*n];
    int maxm=Integer.MIN_VALUE;
    int cur=0;
    for(int i=0;i<2*n;i++)
    	{
    		int val = sc.nextInt();
             if(check[val]==0)
             {
             	cur++;
             	check[val]=1;
             }
             else
             {
             	cur--;
             }
             if(cur>maxm)
             	maxm = cur;
             
        }
        System.out.println(maxm);
   }
}