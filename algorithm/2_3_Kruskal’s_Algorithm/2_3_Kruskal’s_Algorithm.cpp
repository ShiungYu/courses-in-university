#include <iostream>
#include<stdlib.h>
#define MaxN 40005
using namespace std;

typedef struct node *nodePointer;

typedef struct node {
    int vertex;
    nodePointer link;
};
nodePointer object[MaxN];
int visited[MaxN];
void push_back(nodePointer* ptr, int val) {
    while (*ptr)
         ptr = &(*ptr)->link;
    *ptr = new node({ val, nullptr });
}

int find(int objectNumber, int val)
{
    visited[objectNumber]++;
    nodePointer ptr = object[objectNumber];
    while (ptr)
    {
        if (ptr->vertex == val)
        {
            return 0;
        }
        else if (visited[ptr->vertex] == 0)
        {
            if (find(ptr->vertex, val)==0)
                return 0;
        }
        ptr = ptr->link;
    }
    return 1;
}
int  compare(const void* a, const void* b)//這函式是 qsort 所需的比較函式  
{
    int c = *(int*)a;
    int d = *(int*)b;
    if (c < d) { return -1; }               //傳回 -1 代表 a < b  
    else if (c == d) { return 0; }      //傳回   0 代表 a = b  
    else return 1;                          //傳回  1 代表 a>b  
}

int main()
{
    int size = 0;
    int max = 0;
    int line[MaxN][3];
    for (int i = 0; i < MaxN; i++)
        object[i] = nullptr;
    while (cin >> line[size][1])
    {
        cin >> line[size][2] >> line[size][0];
        if (line[size][1] > max)
            max = line[size][1];
        if (line[size][2] > max)
            max = line[size][2];
        size++;
    }
    for (int i = 0; i < size; i++)
    {
        push_back(&object[line[i][1]], line[i][2]);
        push_back(&object[line[i][2]], line[i][1]);
    }
    cout << "Adjacency list:" << endl;
    for (int i = 0; i <= max; i++)
    {
        cout << i << ": ";
        nodePointer temp = object[i];
        while (temp != nullptr)
        {
            cout << temp->vertex << " -> ";
            temp = temp->link;
        }
        cout << "end" << endl;
    }
    cout << endl;
    cout << "minimum spanning tree:" << endl;
    qsort(line, size, 3 * sizeof(int), compare);
    for (int i = 0; i <= max; i++)
        object[i] = nullptr;
    int sum = 0;
    int time = 1;
    for (int i = 0; i < size; i++)
    {
        for (int i = 0; i <= max; i++)
            visited[i] = 0;
        if (find(line[i][1], line[i][2]))
        {
            push_back(&object[line[i][1]], line[i][2]);
            push_back(&object[line[i][2]], line[i][1]);
            sum += line[i][0];
            cout << time << ": <" << line[i][1] << "," << line[i][2] << ">" << endl;
            time++;
            if (time > max)
                break;
        }
    }
    cout << endl;
    cout << "The cost of minimum spanning tree: " << sum << endl;
    
}
