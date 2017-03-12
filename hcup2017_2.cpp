#include <iostream>
#include<algorithm>
using namespace std;
int main() {
freopen("lazy_loading _input.txt","rt",stdin);
freopen("lazy_loading_output.out","wt",stdout);
int test;
cin>>test;
for(int x=1;x<=test;x++)
{
int num;
cin>>num;
int arr[num];
for(int i=0;i<num;i++)
cin>>arr[i];
sort(arr,arr+num);
int k=0;
int last=num-1;
int global=0;
while(last>=k)
{
	int check = 50/arr[last];
	if(50%arr[last])
	check++;
	check--;
        check = max(0,check); 
	k=k+check;
	if(k<=last)
	{
		global++;
	}
	else
	break;
	last--;
}
/*
int i=0,j=n-1;
for(;j>i;j--){
ans+=1;
i+=max(0,
*/
cout<<"Case #"<<x<<":"<<" "<<global<<endl;
}
}
