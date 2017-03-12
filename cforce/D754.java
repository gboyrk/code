import java.util.*;
import javafx.util.Pair;
import java.lang.Integer ;
class D754{

public static void main(String args[])
{
Scanner in = new Scanner(System.in);
int n,k;
n= in.nextInt();
k= in.nextInt();
ArrayList <Pair <Integer,Integer> > l = new ArrayList <Pair <Integer,Integer> > ();
for(int i=0;i<n;i++)
{
Integer a= new Integer(in.nextInt());
Integer b= new Integer(in.nextInt());
l.add(new Pair<Integer,Integer>(a,b));
}
Collections.sort(l, new Comparator<Pair <Integer,Integer> >() {
  @Override public int compare( Pair <Integer,Integer> x, Pair <Integer,Integer>  y) {
    Integer a = x.getKey();
   Integer b= y.getKey();
    return a.intValue() - b.intValue();
  }
});
//Iterator itr = l.iterator();
//while(!itr.hasNext()){
//Pair<Integer,Integer> p1= itr.next();
for (int i=0;i<2;i++)
System.out.println(l[i].getKey()+"  "+l[i].getValue());
}
};
