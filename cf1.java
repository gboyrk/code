import java.io.*;
import java.util.*;

public class cf1{
	
	public static void main(String args[]){
	Scanner sc= new Scanner(System.in);
	int k = sc.nextInt();
	int a = sc.nextInt();
	int b = sc.nextInt();
    int first = a/k;
    int second = b/k;
    if(first+second==0||a+b<k)
    	System.out.println("-1");
    else if(a<k && b%k!=0)
    System.out.println("-1");
    else if(b<k && a%k!=0)
    System.out.println("-1");
    else
    	System.out.println(first+second);
}
}
