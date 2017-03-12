import java.io.*;
public class quicksort{
static void swap(int[] arr,int ind1,int ind2)
{
int temp=arr[ind1];
arr[ind1]=arr[ind2];
arr[ind2]=temp;
}

static int partition(int[] arr,int ft,int sc,int value)
{
int point=ft-1;
for(int i=ft;i<sc;i++)
{
if(arr[i]<value)
{
swap(arr,i,++point);
}
}
swap(arr,++point,sc);
return point;
}
 static void  quicksort(int[] arr,int ft,int sc)
{
if(ft==sc || ft>sc )
return;
int pivot = arr[sc];
int value = partition(arr,ft,sc,pivot);
quicksort(arr,ft,value-1);
quicksort(arr,value+1,sc);
}
public static void main(String arg[])
{
int[] arr={5,6,7,4,4,9,1,11};
int sz = 8;
quicksort(arr,0,sz-1);
for(int i=0;i<sz;i++)
System.out.print(arr[i]+"  ");
}
}
