//0-1�������⣺������������m��n��������1-n����ȡ��������ʹ��͵���m��Ҫ�����п��ܵ�����г�����
//0_1_bag.cpp

#include <iostream.h>
#include <cstdlib>
#include <cstdio>


int out[100+1]; // n=100, m = 100
int m=100, n=100;
int count = 0;
FILE *fp;

void calc(int m, int n)
{
	if (m<1 || n<1 || (n==1 && m!=1))
		return;
	if (m==n)
	{
		out[n] = 1;
		for (int i=1; i<=100; i++)
		{
			if (out[i])
			{
				cout<<i<<" ";
				fprintf(fp,"%d ",i);
			}
		}
		cout<<endl;
        fprintf(fp,"\n");
		count++;
		out[n] = 0;
	}
	
	calc(m, n-1);		// not including n

	out[n] = 1;			// including n
	calc(m-n, n-1);
	out[n] = 0;
}

void main()
{
	calc(m, n);
	cout<<"over..."<<endl;
	cout<<count<<endl;
	fclose(fp);
}












