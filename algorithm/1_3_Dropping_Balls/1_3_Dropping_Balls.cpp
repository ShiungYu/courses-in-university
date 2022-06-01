#include<iostream>
using namespace std;

int main()
{
	int time;
	cin >> time;
	for (int i = 0; i < time; i++)
	{
		int nball, dep, pos, j;
		cin >> dep >> nball;
		pos = 1;
		j = 1;
		while (j < dep)
		{
			if (nball % 2 == 0)
			{
				pos = pos * 2 + 1;
			}
			else
				pos *= 2;
			if (nball > 1)
			{
				if (nball % 2 == 0)
					nball /= 2;
				else
					nball = nball / 2 + 1;
			}
			j++;
		}
		cout << pos << endl;
	}
}
