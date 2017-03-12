#include<iostream>
using namespace std;
main()
{
int test;
cin>>test;
while(test--)
{
deque<int> usb;
deque<int> ps2;
int a,b,c;
cin>>a>>b>>c;
int m;
cin>>m;
string str;
int val;
for(int i=0;i<m;i++)
{
cin>>val>>str;
if(str=="USB")
usb.push_back(val);
else
ps2.push_back(val);
}
sort(usb.begin(),usb.end());
sort(ps2.begin(),ps2.end());
int total=0;
for(int i=0;i<a;i++)
{
total+=usb.front();

}
}
}
