#include<iostream>
#include<vector>
#include<stdio.h>
#include<algorithm>
#include<deque>
using namespace std;
typedef struct fact{
int a;
int b;
int c;
}fact;
bool comp(const fact& lhs, const fact& rhs)
{
  return lhs.a < rhs.a;
}
main()
{
//freopen("input.txt","r",stdin);
//freopen("output.txt","w",stdout);
int n,k;
cin>>n>>k;
vector<fact> arr(n);
deque<int> st;
for(int i=0;i<n;i++)
{
int a,b;
cin>>a>>b;
arr[i].a=a;
arr[i].b=b;
arr[i].c=i+1;
}
int i=0;
int maxi = k-1; 
sort(arr.begin(),arr.end(),comp);
for(int i=0;i<n;i++)
{
cout<<arr[i].a<<"  "<<arr[i].b<<endl;
}
cout<<endl;
int maxm=0;
for(i=0;i<n;i++)
{
int cab=arr[i].b;
while(!st.empty() && (int)st.front()>=cab)
{cout<<st.front()<<cab<<endl;
st.pop_back();
}
st.push_back(cab);
cout<<st.front()<<endl;
if(i>=k-1){
int value = st.front()-arr[i].a+1;
if(value>maxm)
{maxm=value;
maxi = i;
}
if(!st.empty() && (int)st.front()==arr[i-k+1].b)
st.pop_front();
}
}
cout<<maxm<<maxi<<endl;
for(int j=maxi-k+1;j<=maxi;j++)
cout<<arr[j].c<<" ";
}
