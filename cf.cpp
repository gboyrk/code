
 
ll exponent(ll base, ll p, ll m)
{
    ll res=1;
    while(p>0) 
	{
        if(p&1) res=(res*base)%m;
        p=p>>1;
        base=(base*base)%m;
    }
    return res;
}


 
ll GP(ll n,ll power2,ll r,ll m)
{
    if(n==1) return 1;   
    ll res;   
    if(n&1) 
	{
        res=exponent(r,(n-1)*power2,m);    
    }
	else res=0; 
    res=res+((1+exponent(r,power2,m))*GP(n/2,power2*2,r,m))%m; 
    return res;
}
 
 

 
ll t,a,n,m,k,res,ans,d,x,num;
 
int main() 
{

    cin>>t;
    while(t--)
	{
        cin>>a>>n>>m;
        num=a;
        d=0;
        while(num>0) 
		{
            d++;
            num=num/10;
        }
        x=1;
        for(int i=1;i<=d;i++)
		{
            x=x*10;
        }
        res=0;
        res=(a*GP(n,1,x,m))%m;
        cout<<res<<endl;
    }
    return 0;
}
