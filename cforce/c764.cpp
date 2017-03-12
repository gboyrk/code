
#include<iostream>
#include<vector>
#include<stdio.h>
int fin;
using namespace std;
pair<bool,int> check(int val,vector<int>* adj,bool* visited,int* color)
{
visited[val]=true;
int defcolor=color[val];
for(int t=0;t<adj[val].size();t++)
{
int x=adj[val][t];
pair<bool,int> des = check(x,adj,visited,color);
if(defcolor!=des.second || des.first!=true )
return make_pair(false,defcolor);
}
return make_pair(true,defcolor);
}
int dfs(int i,vector<int>* adj,bool* visited,int* color)
{cout<<"dfs "<<i<<" "<<endl;
visited[i]=true;
int defcolor=color[i];
cout<<i<<" defcolor"<<defcolor<<endl;
for(int t=0;t<adj[i].size();t++)
{
int val=adj[i][t];
if(!visited[val])
{
int col = dfs(val,adj,visited,color);
if(col!=defcolor && fin==-1)
{cout<<defcolor<<" "<<col;
fin=i;
cout<<fin<<"dsf"<<endl;
//fin=val;
}
} 
}
return defcolor;
}
main()
{
freopen("input.txt","r",stdin);
int n;
cin>>n;
fin=-1;
vector<int> adj[n];
for(int i=0;i<n-1;i++)
{int x,y;
cin>>x>>y;
x=x-1;
y=y-1;

adj[x].push_back(y);
adj[y].push_back(x);
cout<<"sdds";
}
//cout<<"ddff";
int color[n];
for(int i=0;i<n;i++)
{cin>>color[i];
//cout<<color[i]<<" "; 
}
cout<<endl;
for(int i=0;i<n;i++)
cout<<color[i]<<" ";
for(int i=0;i<n;i++)
{
for(int j=0;j<adj[i].size();j++)
cout<<adj[i][j]<<" ";
cout<<endl;
}

bool* visited=(bool*)calloc(sizeof(bool),n);
//int fin=-1;
int res = dfs(0,adj,visited,color);
if(fin==-1)
{cout<<"1";return 0;}
/*bool* visited2=(bool*) calloc(sizeof(bool),n);
for(int t=0;t<adj[fin].size();t++)
{
if(!check(adj[fin][t],adj,visited2,color).first)
cout<<"-1";
}
*/
cout<<"fin"<<fin;
}
