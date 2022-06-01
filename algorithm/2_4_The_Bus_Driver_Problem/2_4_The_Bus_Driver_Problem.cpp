#include<iostream>
#include<stdlib.h>
using namespace std;
#define MaxRoute 105

int compare(const void* a, const void* b)//this function is the comare function of qsort
{
	int c = *(int*)a;
	int d = *(int*)b;
	if (c < d)
		return 1;
	else if (c == d)
		return 0;
	else
		return -1;
}
int main()
{
	int n=0, d=0, r=0, sum;
	int M[MaxRoute];
	int E[MaxRoute];
	while (1)
	{
		cin >> n >> d >> r;
		if (n == 0 && d == 0 && r == 0)
			break;
		sum = 0;
		for (int i = 0; i < n; i++)
			cin >> M[i];
		for (int i = 0; i < n; i++)
			cin >> E[i];
		qsort(M, n, sizeof(int), compare);
		qsort(E, n, sizeof(int), compare);
		for(int i=0;i<n;i++)
		{
			if (M[i] + E[n - 1 - i] > d)
				sum += (M[i] + E[n - 1 - i] - d) * r;
		}
		cout << sum << endl;
	}
}
