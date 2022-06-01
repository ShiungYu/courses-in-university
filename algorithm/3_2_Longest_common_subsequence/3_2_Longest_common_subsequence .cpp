#include<iostream>
#include<string>
#define maxlen 20005
using namespace std;

int main()
{
	string x, y;
	cin >> x >> y;
	int ans;
	int m = x.length();
	int n = y.length();
	int c[2][maxlen] = { 0 };
	for (int i = 1; i <= m; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			if (x[i - 1] == y[j - 1])
			{
				c[(i+1)%2][j] = c[i%2][j - 1] + 1;
			}
			else if (c[i%2][j] > c[(i + 1) % 2][j-1])
			{
				c[(i + 1) % 2][j] = c[i % 2][j];
			}
			else
			{
				c[(i + 1) % 2][j] = c[(i + 1) % 2][j - 1];
			}
		}
	}
	cout << c[(m+1)%2][n] << endl;
}
