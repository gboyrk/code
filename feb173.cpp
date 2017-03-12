#include<iostream>
#include<math.h>
using namespace std;
long long int  modexp(long long int x,long long int n,long long int m)
{
long long int res=1;
x=x%m;
while(n>0)
{
if(n&1)
res=res*x;
res=res%m;
x=x*x;
x=x%m;
n=n/2;
}
return res;
}
long long int revmod(long long int a,long long int m )
{
/*    
  long long   int m0 = m, t, q;
   long long  int x0 = 0, x1 = 1;
 
    if (m == 1)
      return 0;
 
    while (a > 1)
    {
        // q is quotient
        q = a / m;
 
        t = m;
 
        // m is remainder now, process same as
        // Euclid's algo
        m = a % m, a = t;
 
        t = x0;
 
        x0 = x1 - q * x0;
 
        x1 = t;
    }
 
    // Make x1 positive
    if (x1 < 0)
       x1 += m0;
 
    return x1;
*/
 a = a%m;
    for (long long int x=1; x<m; x++)
       if ((a*x) % m == 1)
          return x;
}
long long int exp(long long int a,long long int b,long long int m)
{
long long int res=1;
while(b>0)
{
if(b&1)
res=res*a;
res=res%m;
a=(a*a)%m;
b=b/2;
}
return res;
}
long long int gp(long long int cd,long long int n,long long int m)
{
if(n==0)
return (long long int )0;
if(n==1)
return (long long int )1;
long long int res=1;
if(n&1)
res=exp(cd,n/2,m);
res%=m;
res=(1 + exp(cd,(n+1)/2,m))*gp(cd,n/2,m);
res=res%m;
return res;
}

main()
{
int test;
cin>>test;
while(test--)
{
long long int a,n,m;
cin>>a>>n>>m;
string str= to_string(a);
long long int cd=str.length();
long long int x=pow(10,cd);
long long int res=gp(x,n,m);
res=res%m;
res=res*(a%m);
res=res%m;
cout<<res<<endl;
}
}
