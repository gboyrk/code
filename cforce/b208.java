import java.util.*;
import java.io.*;

public class b208{
  public static  boolean  valid(String[] arr,int i,int j)
  {
    if(arr[i].charAt(0)==arr[j].charAt(0) || arr[i].charAt(1)==arr[j].charAt(1))
      return true;
    return false;
  }
  public  static void  main(String arg[]){
  Queue<String[] >  allcards = new LinkedList<String[]>();
  HashSet<String> has = new HashSet<String>();
   Scanner sc = new Scanner(System.in);
   int n = Integer.parseInt(sc.nextLine());
    String l=  sc.nextLine();
    has.add(l);
    int x=0;
    allcards.add(l.split(" "));
    while(!allcards.isEmpty())
    {
      String[] temp = allcards.poll();
       x = temp.length;
      x=x-1;
      if(x==0)
        break;
      if(x-1>=0 && valid(temp,x,x-1) )
      {
        String ext = temp[x];
        String[] ar = Arrays.copyOf(temp,temp.length-1);
        ar[x-1]=ext;
        l = Arrays.toString(ar);
        if(!has.contains(l))
        {
          has.add(l);
          allcards.add(ar);
        }
      }
      if(x-3>=0 && valid(temp,x,x-3) )
      {
        String ext = temp[x];
        String[] ar = Arrays.copyOf(temp,temp.length-1);
        ar[x-3]=ext;
        l = Arrays.toString(ar);
        if(!has.contains(l))
        {
          has.add(l);
          allcards.add(ar);
        }
      }

    }
    if(x==0)
      System.out.println("YES");
    else
       System.out.println("NO");
   }
}