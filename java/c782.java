import java.util.*;

public class c782{
	void dfs(ArrayList<ArrayList<Integer> > mat,boolean[] visited,int[] color,int ind,int n,int col,int global,int par)
	{
		visited[ind]=true;
		color[ind]=col;
		int x=col;
		for(int i=0;i<mat.get(ind).size();i++)
		{
			int l= mat.get(ind).get(i);
			 if(!visited[l])
			{

              x=(x+1)%global;
              if(x==par)
              	 x=(x+1)%global;
              dfs(mat,visited,color,l,n,x,global,col); 
			}
		}

	}
	

	FastScanner in;
	PrintWriter out;

	void run() {
		in = new FastScanner();
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public String nextToken() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(nextToken());
		}

		public long nextLong() {
			return Long.parseLong(nextToken());
		}

		public double nextDouble() {
			return Double.parseDouble(nextToken());
		}
	}
	public static void main(String arg[])
{	Scanner sc = new Scanner(System.in);
	int n= sc.nextInt();
	//int[][] mat = new int[n][n];
	List<Integer>  mat =  new  
	for(int i=0;i<n;i++)
		mat.add(new ArrayList<Integer>());
	for(int i=0;i<n-1;i++)
	{
		int a = sc.nextInt();
		int b= sc.nextInt();
		a=a-1;
		b=b-1;
        mat.get(a).add(b);
        mat.get(b).add(a);
		boolean[] visited = new boolean[n];
		//Integer temp = 0;
		//dfs(mat,) 
	}
	if(n==1)
		{System.out.println("1");
	System.out.println("1");
	               return;}
	else if(n==2)
		{System.out.println("2");
	System.out.println("1");
	System.out.println("2");return;}
    int global=0;
	for(int i=0;i<n;i++)
		{
			if((int)mat.get(i).size() + 1>global)
            global= (int)mat.get(i).size() + 1;
		}
	c782  obj = new c782();
	int[] color = new int[n];
	boolean[] visited = new boolean[n];
	obj.dfs(mat,visited,color,0,n,0,global,-1);
		System.out.println(global);
		for(int i=0;i<n;i++){
			System.out.print(color[i]+1);
		System.out.print(" ");}

   }
}