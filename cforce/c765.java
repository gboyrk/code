import java.util.*;
import java.io.*;
public class c765{
	 

 boolean check(String ar,int[] arr)
{
int con[]=new int[26];
int l= ar.length();
	for(int i=0;i<ar.length();i++)
		con[(char)ar.charAt(i)-'a']=1;
	for(int i=0;i<26;i++)
	if(con[i]==1 && arr[i]<l)
    return false;
return true;
}







public  static void main(String args[]){


c765 obj = new c765();
Scanner sc = new Scanner(System.in);
	 	int n= sc.nextInt();
sc.nextLine();
	 	String str = "*";
	 	str+=sc.nextLine();
	 	int arr[] = new int[26];
	 	for(int i=0;i<26;i++)
	 	arr[i]= sc.nextInt();
	 int dp[]=new int[n+1];
	 dp[1]=1;
	 dp[0]=1;
       int longest[]=new int[n+1];
       int substr[] = new int[n+1];
       int cont[]=new int[26];
       for(int i=2;i<=n;i++)
       {int value=0;
       	for(int j=0;j<i;j++)
       	 {String ch = str.substring(j+1,i+1); 
       	 	boolean flag=obj.check(ch,arr);
System.out.println(ch + " "+flag);
if(flag)
value+=dp[j];

       	 }
       	 dp[i]=value;
       }
for(int i=0;i<=n;i++)
       System.out.println(dp[i]);
	 }
}
