#include<vector>
#include<iostream>
#define maxN 1000005
using namespace std;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	vector<int>L;
	int a[maxN];
	int n;
	cin >> n;
	cin >> a[0];
	L.push_back(a[0]);
	int maxx = 0;
	for (int i = 1; i < n; i++)
	{
		cin >> a[i];
		if (a[i] > L.back())
		{
			L.push_back(a[i]);
			continue;
		}
		else if (a[i] < L.back())
		{
			for (int j = 0; j < L.size(); j++)
			{
				if (a[i] < L[j] && a[i]>L[j - 1])
				{
					L[j] = a[i];
					break;
				}
			}
		}
	}
	cout << L.size() << endl;
}
