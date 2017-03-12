#include<iostream>
#include<vector>
using namespace std;
int maxx(int a, int b){
    return (a>b)?a:b;
}
int minn(int a, int b){
    return (a<b)?a:b;
}

int main(){
    int N,T;
    cin>>N>>T;
    char str[N+3];
    cin>>str;
    int maxH = -1;
    vector<int> houses, shops;
    for (int i=0;i<N;i++){
        if (str[i]=='H'){
            maxH = i+1;
            houses.push_back(i+1);
        }
        if (str[i]=='S'){
            shops.push_back(i+1);
        }
    }
    int numS = shops.size();
    int numH = houses.size();
    houses.push_back(1000000000);
    if (T<maxH) {cout<<-1; return 0;}
    int min = 0, max = numH;
    if (numH>numS) min = numH-numS;
    int k;
    while(min<max){
        int mid = (min+max)/2;
        int needed = 0;
        int min_needed = 2*N;
        
        for (int i=mid;i<numH;i++){
            if (min_needed>needed+maxx(0,2*(shops[numH-1-mid]-maxH))+2*maxH-houses[i]) min_needed = needed+maxx(0,2*(shops[numH-1-mid]-maxH))+2*maxH-houses[i];
            needed+= 2*maxx(0,minn(houses[i+1]-houses[i],shops[i-mid]-houses[i]));
        }
        
        if (min_needed>needed+maxH) min_needed = needed+maxH;
        if (min_needed<=T){
            max = mid;
        }
        else{
            min = mid+1;
        }
    }
    cout<<min;
}
 