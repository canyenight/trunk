#include <iostream>
using namespace std;

void heapadjust(int data[], int s, int m)
{
	// data[s..m]�����ɵ�һ��Ԫ�������У�����data[s]�⣬����Ԫ�ؾ�����ѵĶ���
	// ����data[s]��λ�ã�ʹdata[s..m]��Ϊһ�������
	int t,j;
	t = data[s];				// backup
	for(j=s*2+1; j<m; j=j*2+1)	// ��ֵ�ϴ����Ů�ڵ�����ɸѡ
	{
		if(j<m && data[j]<data[j+1])
			j++;				// j��ֵ�ϴ��Ԫ�ص��±�
		if(!(t<data[j]))
			break;
		data[s] = data[j];
		s = j;					// ��s��¼������Ԫ�ص�λ��
	}
	data[s] = t;
}

void heapsort(int data[], int n)
{
	register int i;
	int t;
	for(i=n/2-1; i>=0; i--)
		heapadjust(data,i,n-1);
	for(i=n-1; i>0; i--)
	{
		t = data[0];
		data[0] = data[i];
		data[i] = t;
		heapadjust(data,0,i-1);
	}
}




void main()
{
	int data[] = {5,9,8,6,7,1,3,2,4,0};
	heapsort(data,10);

	for (int i=0; i<10; i++)
		cout<<data[i]<<" ";
	cout<<endl;
}	
