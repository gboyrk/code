#include <iostream>
#include<math.h>
#include<deque>
using namespace std;
string fun(long long  int maxm,long long int minm,long long int n,long long int k,char mxch,char mnch)
{
	long long int num=(maxm/k);
	if(maxm%k!=0)
	num+=1;
	if(num-1>minm)
	return "error";

long long int n1=num;
if(num-1==minm || num==minm)
{
n1=num;
}
else
{
long long int k2=minm-num;
long long  int p=k2/(k-1);
if(k2%(k-1)!=0)
p++;
n1=num-p;
}
	bool flag=true;
	long long int x=k;
	string result;
	for(int i=0;i<n;i++)
	{
		if(flag)
		{
			if(maxm)
			{
				result.push_back(mxch);
				maxm--;
			    x--;	
			}
			if(x==0 || maxm==0)
			{
				flag=false;
					if(n1>0)
				x=1;
                                else
                                x=k;
			}
		}
		else
		{
			if(minm)
			{
			    result.push_back(mnch);
				minm--;
			    x--;
			}
			if(x==0 || minm==0)
			{
				flag=true;
                                n1--;
				x=k;
			}
		}
	}
	return result;
}
int main() {
	long long int a,b,c,d;
	cin>>a>>b>>c>>d;
	string ans;
	if(c<d)
	{
		ans=fun(d,c,a,b,'B','G');
	}
	else
	{
		ans=fun(c,d,a,b,'G','B');
	}
	if(ans=="error")
	cout<<"NO";
	else
	cout<<ans;
}
