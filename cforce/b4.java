import java.util.*;
public class b4{
	public static void main(String arg[]){
	int d,hr;
	Scanner sc = new Scanner(System.in);
	d = sc.nextInt();
	hr = sc.nextInt();
	int [] minm = new int[d];
	int[] maxm= new int[d];
	int[] dur = new int[d];
	int[] need = new int[d];
	int minm_val =0,maxm_val=0;
	for(int i=0;i<d;i++)
	{
		minm[i]=sc.nextInt();
		minm_val+=minm[i];
		maxm[i]=sc.nextInt();
		maxm_val+=maxm[i];
		dur[i]=maxm[i]-minm[i];
	}
	if(hr>maxm_val || hr<minm_val)
		{System.out.println("NO");return;}
	hr=hr-minm_val;
    //Arrays.sort(dur);
    int i=0;
    while(i<d)
    {
    	 if(hr==0)
      	break;
      int c =Integer.min(dur[i],hr);
      hr-=c;
      need[i]=c;
      if(hr==0)
      	break;
      i++;
    }
    System.out.println("YES");
    for( i=0;i<d;i++)
    {
    	System.out.print((minm[i]+need[i])+" ");
    }
}
}
