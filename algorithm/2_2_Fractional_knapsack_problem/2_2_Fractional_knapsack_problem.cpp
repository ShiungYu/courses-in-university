#include<iostream>
#include<iomanip>
#include<stdlib.h>
#define Max_size 40000
using namespace std;

int  compare(const void* a, const void* b)//這函式是 qsort 所需的比較函式
{
	double c = *(double *)a;
	double d = *(double*)b;
	if (c < d) { return 1; }               //傳回 1 代表 a < b
	else if (c == d) { return 0; }      //傳回   0 代表 a = b
	else return -1;                          //傳回  -1 代表 a>b
}

int main()
{
	int capacity;
	double object[Max_size][3];
	cin >> capacity;
	int  size = 0;
	/*for (int i = 0; i < Max_size; i++)
	{
		object[size][0] = 0;
		object[size][1] = 0;
	}
	*/
	while (cin >> object[size][1])
	{
		cin >> object[size][2];
		size++;
	}
	for (int i = 0; i < size; i++)
	{
		object[i][0] = object[i][1] / object[i][2];
	}
	qsort(object, size, 3*sizeof(double), compare);
	/*for (int i = 0; i < size; i++)
	{
		for (int j = 0; j < size - 1 - i; j++)
		{
			if (object[j][0] / object[j][1] < object[j + 1][0] / object[j + 1][1])
			{
				for (int k = 0; k <= 1; k++)
				{
					double temp1 = object[j][k];
					object[j][k] = object[j + 1][k];
					object[j + 1][k] = temp1;
				}
			}
		}
	}
	*/
	int i = 0;
	double sum = 0.0;
	while (1)
	{
		if (object[i][2] < capacity)
		{
			capacity -= object[i][2];
			sum += object[i][1];
			i++;
		}
		else
		{
			sum += object[i][1] * capacity / object[i][2];
			break;
		}
	}
	cout <<fixed<<setprecision(6)<<sum << endl;
}
