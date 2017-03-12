import java.util.*;
import java.io.*;

public class c782_2{

	List<Integer>[] graph;
	//boolean[] vis;

	void dfs(List<Integer>[] graph,boolean[] visited,int[] color,int ind,int n,int col,int global,int par)
	{
		visited[ind]=true;
		color[ind]=col;
		int x=col;
		for(int i=0;i<graph[ind].size();i++)
		{
			int l= graph[ind].get(i);
			 if(!visited[l])
			{

              x=(x+1)%global;
              if(x==par)
              	 x=(x+1)%global;
              dfs(graph,visited,color,l,n,x,global,col); 
			}
		}

	}
	
	//List<Integer>[] result;
	
	void solve() {
		int n = in.nextInt();
		graph = new List[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		//int m = in.nextInt();
		//int k = in.nextInt();
		for (int i = 0; i < n-1; i++) {
			int from = in.nextInt() - 1, to = in.nextInt() - 1;
			graph[from].add(to);
			graph[to].add(from);
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
			if((int)graph[i].size() + 1>global)
            global= (int)graph[i].size() + 1;
		}
			int[] color = new int[n];
      	boolean[] visited = new boolean[n];
	    dfs(graph,visited,color,0,n,0,global,-1);
		System.out.println(global);
		for(int i=0;i<n;i++){
			System.out.print(color[i]+1);
		System.out.print(" ");}

		
	}

	FastScanner in;
	//PrintWriter out;

	void run() {
		in = new FastScanner();
	//	out = new PrintWriter(System.out);
		solve();
	//	out.close();
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

	public static void main(String[] args) {
		new c782_2().run();
	}
}