#include<iostream>
#include<limits.h>
#define MaxNode 50005
using namespace std;

int price[MaxNode];
int r[MaxNode];

int main() {
	int n,a,b;
	cin >> n;
	r[0] = 0;
	while (cin >> a >> b)
	{
		if (a == 0)
			break;
		price[a] = b;
	}
	for (int j = 1; j <= n; j++)
	{
		int q = INT_MIN;
		for (int i = 1; i <= j; i++)
		{
			q = max(q, price[i] + r[j-i]);
		}
		r[j] = q;
	}
	cout << r[n] << endl;
}
