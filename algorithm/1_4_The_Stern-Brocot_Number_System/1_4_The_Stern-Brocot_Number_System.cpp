#include<iostream>
using namespace std;

typedef struct fraction {
	int numerator;
	int denominator;
};

int main()
{
	fraction F;
	long double Fd,Md;
	while (1)
	{
		fraction L = { 0,1 };
		fraction M = { 1,1 };
		fraction R = { 1.0 };
		cin  >> F.numerator >> F.denominator;
		if (F.denominator == 1 && F.numerator == 1)
			break;
		Fd = F.numerator / (long double)F.denominator;
		Md = M.numerator / (long double)M.denominator;
		while (!(M.denominator == F.denominator && M.numerator == F.numerator))
		{
			if (Fd > Md) {
				L.numerator = M.numerator;
				L.denominator = M.denominator;
				M.numerator = M.numerator + R.numerator;
				M.denominator = M.denominator + R.denominator;
				cout << "R";
			}
			else
			{
				R.numerator = M.numerator;
				R.denominator = M.denominator;
				M.numerator = M.numerator + L.numerator;
				M.denominator = M.denominator + L.denominator;
				cout << "L";
			}
			Md = M.numerator / (long double)M.denominator;
		}
		cout << endl;
	}
}
