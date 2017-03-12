#include <iostream>
using namespace std;

int main() {
	long long int a,b,c;
	cin>>a>>b>>c;
	a=a*4;
	b=b*2;
	long long int minm=a;
	if(minm>b)
	minm=b;
	if(minm>c)
	minm=c;
	minm=minm-(minm%4);
	long long int total=minm/4+minm/2+minm;
	cout<<total;
}
