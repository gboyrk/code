#include <iostream>
#include <cstring>
#include <algorithm>
#define pb push_back
#define MAXN 100100
#include <cstdio>
typedef long long ll;
using namespace std;

int n;
ll a[3][MAXN];
ll dp[3][MAXN];

int main()
{
	 scanf("%d", &n);
//	n=3;
	for (int i = 0; i < 3; i++)
		for (int j = 0; j < n; j++) {
			 scanf("%I64d", &a[i][j]);
			//a[i][j]=1;
		}
	dp[0][0] = a[0][0];
	dp[1][0] = a[1][0] + a[0][0];
	dp[2][0] = a[2][0] + a[1][0] + a[0][0];
//	cout<<dp[2][-1]<<" ";
	for (int i = 1; i < n; i++) {
                cout<<i<<endl;
		dp[0][i] = a[0][i] + max(max(dp[0][i - 1], dp[2][i - 2] + a[0][i - 1] + a[1][i - 1] + a[2][i - 1] + a[1][i] + a[2][i]), max(dp[1][i - 1] + a[1][i], dp[2][i - 1] + a[2][i] + a[1][i]));
		dp[1][i] = a[1][i] + max(max(dp[0][i - 1] + a[0][i], dp[2][i - 1] + a[2][i]), dp[1][i - 1]);
		dp[2][i] = a[2][i];

		long long int bc=    dp[2][i - 1];
		cout<<bc<<endl;
                if(bc<(dp[0][i - 1] + a[0][i] + a[1][i]))
                {
                        cout<<"thhird one"<<endl;
                   bc =dp[0][i - 1] + a[0][i] + a[1][i];
                }
                if(bc<(dp[1][i - 1] + a[1][i]))
		{cout<<"second one"<<endl;
			bc=dp[1][i - 1] + a[1][i];
		}
                if(bc< (dp[0][i - 2] + a[2][i - 1] + a[1][i - 1] + a[0][i - 1] + a[1][i] + a[0][i]))
                {
                        cout<<"ya hyper one";
                        bc= dp[0][i - 2] + a[2][i - 1] + a[1][i - 1] + a[0][i - 1] + a[1][i] + a[0][i];
                }
		dp[2][i]+=bc;
	}

	cout << dp[2][n - 1] << endl;
	return 0;
}
