import java.io.*;
import java.util.*;
public class e166{
public static int sol=0;
//public static int mod=1000000007;
//public static int[][] arr = new int[10000006][4];
public static int mod=1000000007;
public static int  dfs(int num,int ind)
{
int d=1,a=0,b=0,c=0;
for(int i=2;i<=num+1;i++)
{
int v1=d%mod,v2=a%mod,v3=b%mod,v4=c%mod;
d=a+b+c;
d=d%mod;
a=(v1+v3+v4);
a=a%mod;
b=(v1+v2+v4);
b=b%mod;
c=(v1+v3+v2);
c=c%mod;
}
return d;
}
public static void main(String arg[])
{
//for(int i=0;i<=10000004;i++)
//for(int j=0;j<4;j++)
//arr[i][j]=-1;
int num;
Scanner sc = new Scanner(System.in);
num = sc.nextInt();  
//Integer sol=0;
long d=1,a=0,b=0,c=0;
for(int i=2;i<=num+1;i++)
{
long  v1=d%mod,v2=a%mod,v3=b%mod,v4=c%mod;
d=a+b+c;
d=d%mod;
a=(v1+v3+v4);
a=a%mod;
b=(v1+v2+v4);
b=b%mod;
c=(v1+v3+v2);
c=c%mod;
}
System.out.println(d);
}
}
