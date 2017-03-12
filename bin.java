public class bin{
static int  bin(int[] arr,int low,int high,int val)
{
if(high<low)
return -1;
int mid=(high)-(high-low)/2;
if(arr[mid]<val)
return bin(arr,mid+1,high,val);
else if(arr[mid]>val)
return bin(arr,low,mid-1,val);
else
return mid;
}
public static void main(String arg[])
{
int[] arr = {2,4,5,6,8,13};
int c= bin(arr,0,5,13);
System.out.println(c);
}
}
