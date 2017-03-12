#include<iostream>
using namespace std;
bool run(int* first,int* sec,int t,int br,int l)
{
int i=0,j=t;
for(int i=0;i<br;)
{
int x=first[(i+1)%br]-first[i%br];
x=(x+l)%l;
int y=sec[(j+1)%br]-sec[j%br];
y=(y+l)%l;
//cout<<x<<"sdf "<<y;
if(x!=y)
return false;
i++;j++;
}
return true;
}
int main()
{
int br,l;
cin>>br>>l;
int first[br];
int sec[br];
for(int i=0;i<br;i++)
cin>>first[i];
for(int i=0;i<br;i++)
cin>>sec[i];
if(br==1)
{
//if(first[0]==sec[0])
cout<<"YES";
return 0;
}
int pr=l-first[br-1]+first[0];
//cout<<pr<<endl;
for(int i=0;i<br;i++)
{//cout<<abs(sec[i]-sec[]);
int pw=(i-1+br)%br;
//cout<<i<<" "<<abs(sec[i]-sec[pw])<<endl;
if(((sec[i]-sec[pw])+l)%l==pr)
{//cout<<"in"<<"df";
if(run(first,sec,i,br,l))
{cout<<"YES";
return 0;}
}
}
cout<<"NO";
}
