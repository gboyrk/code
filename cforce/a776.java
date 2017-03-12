import java.util.*;
import java.io.*;
public class a776{
	public static void main(String args[])
	{ try{
    // File file = new File("input1.txt");
      Scanner sc = new Scanner(System.in);
      HashSet<String> has= new HashSet<String>();
      String p12 = sc.next();
      //StringTokenizer st= new StringTokenizer();
      String p22 = sc.next();
      System.out.println(p12 +" "+p22); 
      has.add(p12);
      has.add(p22);
      int num= sc.nextInt();
      for(int i=0;i<num;i++)
      {
      	String p1 = sc.next();
      	has.remove(p1);
      	String p2 = sc.next();
      	has.add(p2);
        Iterator<String> it = has.iterator();
        while(it.hasNext())
        	System.out.print(it.next()+" ");
        System.out.println();
      }
  }catch(Exception e){}
	}
}