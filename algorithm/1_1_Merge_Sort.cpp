#include<iostream>
#include<limits.h>

#define MAX_NUMBER 50005
using namespace std;
int sequences[MAX_NUMBER];

void Merge(int p, int q, int r)
{
	int n1 = q-p + 1;
	int n2 = r - q;
	int L[MAX_NUMBER];
	int R[MAX_NUMBER];
	int i, j;
	for (i = 1; i <= n1; i++)
		L[i] = sequences[p + i - 1];
	for (j = 1; j <= n2; j++)
		R[j] = sequences[q + j];
	L[i] = INT_MAX;
	R[j] = INT_MAX;
	i = 1;
	j = 1;
	for (int k = p; k <= r; k++)
	{
		if (L[i] <= R[j])
			sequences[k] = L[i++];
		else
			sequences[k] = R[j++];
	}
}

void Merge_Sort(int p,int r)
{
	if (p < r)
	{
		int q = (int)(p + r) / 2;
		Merge_Sort(p, q);
		Merge_Sort(q+1, r);
		Merge(p, q, r);
	}
}

int main()
{
	int input;
	int times=1;
	while (cin >> input)
	{
		sequences[times++] = input;
	}
	sequences[times] = INT_MAX;
	Merge_Sort(1,times-1);
	for (int i = 1; i < times; i++)
	{
		cout << sequences[i] << ' ';
	}
	cout << endl;
}
