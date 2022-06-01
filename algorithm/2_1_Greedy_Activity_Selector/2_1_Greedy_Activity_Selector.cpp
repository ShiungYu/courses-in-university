#include<iostream>
#define MAX_Number 30005
using namespace std;


int main()
{
	int index;
	int startTime[MAX_Number];
	int endTime[MAX_Number];
	int lastIndex;
	while (cin >> index)
	{
		cin >> startTime[index];
		cin >> endTime[index];
	}
	lastIndex = 1;
	cout << '1' << ' ';
	for (int i = 2; i <= index; i++)
	{
		if (endTime[lastIndex] <= startTime[i])
		{
			lastIndex = i;
			cout << i << ' ';
		}
	}
	cout << endl;
}
