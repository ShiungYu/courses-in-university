#include<iostream>
#include<limits.h>
#define MAX_Number 50005
using namespace std;

int A[MAX_Number];

typedef struct subarray
{
	int maxLeft;
	int maxRight;
	int sum;
};

subarray FindMaxCrossingSubarray(int low, int mid, int high)
{
	int leftSum = INT_MIN;
	int sum = 0;
	int rightSum, maxLeft, maxRight;
	for (int i = mid; i >= low; i--)
	{
		sum = sum + A[i];
		if (sum > leftSum)
		{
			leftSum = sum;
			maxLeft = i;
		}
	}
	rightSum = INT_MIN;
	sum = 0;
	for (int j = mid + 1; j <= high; j++)
	{
		sum = sum + A[j];
		if (sum > rightSum)
		{
			rightSum = sum;
			maxRight = j;
		}
	}
	subarray a = {maxLeft, maxRight, leftSum + rightSum};
	return a;
}

subarray FindMaximumSubarray(int low, int high)
{
	subarray ans1;
	subarray left;
	subarray right;
	subarray cross;
	if (high == low)
	{
		ans1 = { low,high,A[low] };
		return ans1;
	}
	else
	{
		int mid = (low + high) / 2;
		left = FindMaximumSubarray(low, mid);
		right = FindMaximumSubarray(mid + 1, high);
		cross = FindMaxCrossingSubarray(low, mid, high);
	}
	if (left.sum >= right.sum && left.sum >= cross.sum)
		return left;
	else if (right.sum >= cross.sum)
		return right;
	else
		return cross;
}

int main()
{
	subarray ans;
	int n = 0;
	int input;
	while (cin >> input)
	{
		A[++n] = input;
	}
	ans = FindMaximumSubarray(1, n);
	cout<<ans.sum<< endl;
}
