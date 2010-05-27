#include <iostream>
using namespace std;

static char Queen[8][8];
static int a[8];
static int b[15];
static int c[15];
static int iQueenNum = 0;	//��¼�ܵ�����״̬��

void qu(int i);		// line i

void main()
{
	int iLine,iColumn;

	// initialization, * means blank, @ means a queen
	for (iLine=0; iLine<8; iLine++)
	{
		a[iLine] = 0;	//�б�ǳ�ʼ������ʾû���г�ͻ
		for (iColumn=0; iColumn<8; iColumn++)
			Queen[iLine][iColumn] = '*';
	}

	// ���ӶԽ��߱�ǳ�ʼ������ʾû�г�ͻ
	for (iLine=0; iLine<15; iLine++)
		b[iLine] = c[iLine] = 0;

	qu(0);
}

void qu(int i)
{
	int iColumn;
	for (iColumn=0; iColumn<8; iColumn++)
	{
		if (a[iColumn]==0 && b[i-iColumn+7]==0 && c[i+iColumn]==0)
		{
			Queen[i][iColumn] = '@';
			a[iColumn] = 1;				//a[0]-a[7]
			b[i-iColumn+7] = 1;			//b[0]-b[14]
			c[i+iColumn] = 1;			//c[0]-c[14]
			
			if(i<7)
				qu(i+1);
			else
			{
				// output result
				int iLine,iColumn;
				cout<<"��"<<++iQueenNum<<"��״̬Ϊ:"<<endl;
				for (iLine=0; iLine<8; iLine++)
				{
					for (iColumn=0; iColumn<8; iColumn++)
						cout<<Queen[iLine][iColumn]<<" ";
					cout<<endl;
				}
				cout<<endl;
			}

			// ���ǰ�εĻʺ���õ��º���ķ���������ζ���������Ҫ������ݣ�����
			Queen[i][iColumn] = '*';
			a[iColumn] = 0;
			b[i-iColumn+7] = 0;
			c[i+iColumn] =0;
		}
	}
}