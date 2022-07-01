#include<iostream>
#include<queue>
#include<stack>
#define maxSize 22
using namespace std;

typedef struct node
{
	int data;
	int orgx;
	int orgy;
};

int main()
{
	node maze[maxSize][maxSize];
	queue<int>qx;
	queue<int>qy;
	int row, col,startX,startY,endX,endY;
	cin >> row >> col >> startX >> startY >> endX >> endY;
	for (int i = 1; i <= row; i++)
	{
		string temp;
		cin >> temp;
		for (int j = 1; j <= col ; j++)
		{
			if (temp[j-1] == '1')
			{
				maze[i][j].data = -1;
			}
			else
			{
				maze[i][j].data = 0;
			}
		}
	}
	maze[startX][startY].data = -2;
	qx.push(startX);
	qy.push(startY);
	int ii[8] = { -1,-1,0,1,1,1,0,-1 };//順時鐘的i座標
	int jj[8] = { 0,1,1,1,0,-1,-1,-1 };//順時鐘的J座標
	while (qx.size()!=0)
	{
		if (maze[endX][endY].data != 0)
			break;
		for (int i = 0; i < 8; i++)
		{
			int j = i;
			if (qx.front() + ii[i] > 0 && qx.front() + ii[i] <= row && qy.front() + jj[j] > 0 && qy.front() + jj[j] <= col && maze[qx.front() + ii[i]][qy.front() + jj[j]].data == 0)
			{
				if (maze[qx.front()][qy.front()].data == -2)
				{
					maze[qx.front() + ii[i]][qy.front() + jj[j]].data = 1;
					maze[qx.front() + ii[i]][qy.front() + jj[j]].orgx = startX;
					maze[qx.front() + ii[i]][qy.front() + jj[j]].orgy = startY;
				}
				else
				{
					maze[qx.front() + ii[i]][qy.front() + jj[j]].data = maze[qx.front()][qy.front()].data + 1;
					maze[qx.front() + ii[i]][qy.front() + jj[j]].orgx = qx.front();
					maze[qx.front() + ii[i]][qy.front() + jj[j]].orgy = qy.front();
				}
				qx.push(qx.front() + ii[i]);
				qy.push(qy.front() + jj[j]);
			}
			//for (int j = 0; j <8 ; j++)
			//{
				
			//}
		}
		qx.pop();
		qy.pop();
	}
	stack<int>ansX;
	stack<int>ansY;
	/*int iii[8] = { -1,0,1,1,1,0,-1,-1 };
	int jjj[8] = { -1,-1,-1,0,1,1,1,0 };
	int tempx = endX;
	int tempy=endY;
	ansX.push(tempx);
	ansY.push(tempy);
	while (true)
	{
		if (tempx == startX && tempy == startY)
		{
			break;
		}
		int i, j;
		for (i = 0; i < 8; i++)
		{
			for (j = 0; j < 8; j++)
			{
				if (tempx+iii[i]> 0 &&  tempx+iii[i] <= row && tempy+jjj[j]>0 &&tempy+jjj[j] <= col)
				{
					if (maze[tempx + iii[i]][tempy + jjj[j]] == maze[tempx][tempy] - 1|| maze[tempx + iii[i]][tempy + jjj[j]]==-2)
					{
						tempx = tempx + iii[i];
						tempy = tempy + jjj[j];
						ansX.push(tempx);
						ansY.push(tempy);
						break;
					}
				}
			}
			if (j != 8)
				break;
		}
	}
	*/
	cout << maze[endX][endY].data+1 << endl;


	int tempX = endX;
	int tempY = endY;
	while (tempX != startX || tempY != startY)
	{
		ansX.push(tempX);
		ansY.push(tempY);
		int temppX = maze[tempX][tempY].orgx;
		int temppY = maze[tempX][tempY].orgy;
		tempX = temppX;
		tempY = temppY;
	}
	ansX.push(tempX);
	ansY.push(tempY);
	while (!ansX.empty())
	{
		cout << "("<< ansX.top()<<"," << ansY.top()<<")"<<endl;
		ansX.pop();
		ansY.pop();
	}
}
