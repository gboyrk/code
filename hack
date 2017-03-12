#include <cmath>
#include <cstdio>
#include <vector>
#include<unordered_map>
#include<cstring>
#include <iostream>
#include<list>
#include <algorithm>
using namespace std;

void dfs(bool* visited,int i,int n,list<int> * vec,vector<int>& result)
    {cout<<"cfds";
    visited[i]=true;
    list<int>::iterator t;
    for (t = vec[i].begin(); t != vec[i].end(); ++t)
    {
        
        if(!visited[*t])
        dfs(visited,*t,n,vec,result);
    }
    result.push_back(i);
    }
int main() {
    int test;
    cin>>test;
    while(test--)
        {
        int n,install;
        cin>>n>>install;
        cout<<"sdffds"<<n;
         list<int> *vec;
        vec = new list<int>[n];
        for(int i=0;i<n;i++)
            {
            int right;
            cin>>right;
            cout<<right<<" ";
            for(int j=0;j<right;j++)
                {int val;
                cin>>val;
                val=val-1;
                vec[i].push_back(val);
                cout<<val<<" ";
                }
                cout<<"fdf";
            }
        cout<<"sddsdasfsd";
        bool*  visited=(bool*)calloc(sizeof(bool),n);
        vector<int> result;
       // memset(visited,false,sizeof(visited));
        for(int i=0;i<n;i++)
            {
            if(!visited[i])
                dfs(visited,i,n,vec,result);
        }
        unordered_map<int,int> hash;
        for(int k=0;k<install;k++)
        {
             int v;
            cin>>v;
            v=v-1;
            hash[v]=1;
        }
        int start=0,end=0;
        for(int i=0;i<result.size();i++)
            {
            if(hash.find(result[i])!=hash.end())
                start=i;
        }
        for(int i=result.size()-1;i>=0;i--)
            {
              if(hash.find(result[i])!=hash.end())
                end=i;
        }
        int ans=end-start;
        if(ans<0)
            ans=0;
        else
            ans=ans+1;
        cout<<ans<<endl;
        for(int i=start;i<=end;i++)
            cout<<result[i]<<" ";
        cout<<endl;
    }
}

