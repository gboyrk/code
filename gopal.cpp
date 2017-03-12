#include<iostream>
using namespace std;
#include<bits/stdc++.h>
int main(){
freopen("lazy_loading.txt","rt",stdin);
freopen("gopaloutput.out","wt",stdout);
	int t,n;
	cin>>t;
	int x=1;
	while(x<=t){
		cin>>n;
		int Array[n];
		for(int i=0;i<n;i++)
			cin>>Array[i];
		sort(Array,Array+n);
		int i=0,ans=0;
		for(int j=n-1;j>=i;j--){
			int k=(50/Array[j]);
			if(50%Array[j]==0)
				k--;
                      i+=max(0,k);
			if(i<=j)
			ans++;
		}
		cout<<"Case #"<<x<<": "<<ans<<endl;
		
		x++;
	}
return 0;
}


