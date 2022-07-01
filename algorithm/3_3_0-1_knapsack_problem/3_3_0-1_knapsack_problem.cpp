#include<iostream>
#include<vector>
#include<cstdlib>

#define bagMax 201
#define objectMax 8001
using namespace std;
int main()
{
	int bagWeight,objectLength;
	int c[bagMax] = { 0 };
	bool items[objectMax][bagMax] = { 0 };
	int g[objectMax] = { 0 };
	int v[objectMax] = { 0 };
	cin >> bagWeight;
	objectLength = 0;
	
	while (true)
	{
		int i,a,b;
		cin >> i>>a>>b;
		if (i == -1&&a == -1 && b == -1)
			break;
		g[i] = a;
		v[i] = b;
		objectLength++;
	}
	for (int i = 0; i < objectLength; i++)
	{
		for (int j = bagWeight; j >= g[i]; --j)
			if (c[j - g[i]] + v[i] > c[j])
			{
				c[j] = c[j - g[i]] + v[i];
				items[i][j] = true; // 有放
			}
	}
	int i, j;
	j = bagWeight;
	for (i = objectLength; i >= 0; i--)
	{
		if (items[i][j] == 1)
		{
			cout << i << " ";
			j -= g[i];
		}
	}
	cout << endl;
	cout << c[bagWeight] << endl;
}
