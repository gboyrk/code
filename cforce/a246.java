import java.util.*;
import java.io.*;
public class a246{
	public static void main(String args[])
	{ 
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		if(num==1 || num == 2)
		System.out.println("-1");
		else 
		{
			for(int i=num;i>=1;i--)
				System.out.print(i+" ");
		} 
	}
}