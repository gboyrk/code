#include<iostream>
using namespace std;
main()
{
long long int n,k,a,b;
cin>>n>>k>>a>>b;
string str;
int k=0;
int minm,maxm;
if(a<b){
minm=a;
t=true;
maxm=b;
}
else
{
minm=b;
t=false;
maxm=a;
}
int x=k;
bool flag=false;
int i=0;
while(i!=n+1)
{
if(flag){
if(maxm==0)
{
cout<<"NO"<<endl;
error=false;
}
str.push_back('m');
maxm--;
x--;
if(x==0){
flag=false;
x=k;}
}
else{
if(minm==0)
{
cout<<"NO"<<endl;
error=false;
}
str.push_back('c');
minm--;
x--;
if(x==0){
flag=false;
x=k;}
}
i++;
}
if(error==false)
return;
for(int q=0;q<n;q++)
{
if(t==true){
if(str[i]=='m')
str[i]=='B';
else
str[i]=='G';
}
else
{
if(str[i]=='m')
str[i]=='G';
else
str[i]=='B';
}
}
}
}
