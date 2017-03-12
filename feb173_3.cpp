#include<iostream>
#include<vector>
#include<algorithm>
#include<limits.h>
#include<bits/stdc++.h>
using namespace std;
long long int deq_arr[300000];
class deq{
	public:
		long long int fr,ba;
		deq()
		{
			fr=0;
			ba=-1;
		}
		void pop_front()
		{
			fr++;
		}
		void pop_back()
		{
			ba--;
		}
		void push_back(long long int we)
		{
			deq_arr[++ba]=we;
		}
		long long int  front()
		{
			return deq_arr[fr];
		}
		long long int  back()
		{
			return deq_arr[ba];
		}
		bool empty()
		{
			if(fr>ba)
				return true;
			return false;
		}
};
int main()
{freopen("testcase.txt","rt",stdin);
	long long int test;
	scanf("%lld",&test);
	while(test--)
	{
		long long int n;
		long long int m;
		scanf("%lld %lld",&n,&m);
		long long int  arr[n];
		long long int  sum[n+1];
		long long int temp=0;
		sum[0]=0;
		for(long long int i=0; i<n; i++)
		{
			scanf("%lld",&arr[i]);
			temp+=arr[i];
			sum[i+1]=temp;
		}
		long long int seq[m];
		for(long long int i=0; i<m; i++)
			scanf("%lld",&seq[i]);
		//cout<<"rgrfg";
		long long int mat[n][m];
		for(long long int i=0; i<n; i++)
		{
			for(long long int j=0; j<m; j++)
			{
				mat[i][j]=-1;
			}
		}
		long long int maxm=INT_MIN;
		for(long long int i=m-1; i>=0; i--)
		{
			long long int val=seq[i];
			if(i==m-1)
			{
				for(long long int j=0; j<n+1-val;j++)
				{
					long long int k=j+val-1;
					long long int term=sum[k+1]-sum[j];
					mat[j][i]=term;
					if(i==0)
					{

						if(mat[j][i]>maxm)
							maxm=mat[j][i];
					}
				}
			}
			else
			{
				deq st ;
				long long int len = seq[i+1];
				long long int siz = val-len-1;
				long long int res=0;
				for(long long int j=1; j<n-len; j++)
				{
					long long int k=j+len-1;
					long long int temp=mat[j][i+1];
					if(j<=siz)
					{
						while(!st.empty() && st.back()<temp)
							st.pop_back();
						st.push_back(temp);
						if(j==siz)
						{    long long int term =sum[res+val]-sum[res]-st.front();
							mat[res][i]=term;
							if(i==0 && mat[res][i]>maxm)
								maxm=mat[res][i];


						}

					}
					else
					{
						long long int mal = mat[res+1][i+1];
						//   cout<<"mal"<<mal<<endl;
						if(st.front()==mal)
							st.pop_front();
						while(!st.empty() && st.back()<temp)
							st.pop_back();
						st.push_back(temp);
						res++;
						long long int term=sum[res+val]-sum[res]-st.front();
						mat[res][i]=term;
						if(i==0 && mat[res][0]>maxm)
							maxm=mat[res][0];

					}

				}


			}
		}

		printf("%lld\n",maxm);
	}
	return 0;
}
