#include <iostream.h>
#include <math.h>
#include <assert.h>

int bisearch(int a[], int n, int e)
{
	int start=0, end=n-1, mid;
	while(start!=end)
	{
		mid = (start+end)/2;
		if(e<a[mid])
			end = mid - 1;
		else if(e>a[mid])
			start = mid + 1;
		else
			return mid;
	}
	if(e==a[start])
		return start;
	return -1;
}

void main()
{
	int a[] = {1,2,3,4,5,7,8,9};
	cout<<bisearch(a, sizeof(a)/sizeof(int), 9)<<endl;
}


//**************************************************


#include <iostream.h>
#include <math.h>
#include <assert.h>
#include <string.h>

// �赥�ʵ���󳤶�Ϊ20���ַ����ֵ乲��n�����ʣ������ҵ���e
int bisearch(char a[][20], int n, const char* e)
{
	assert(n>0);
	int start=0, end=n-1, mid;
	while(start!=end)					// ��������
	{
		mid = (start+end)/2;
		if(strcmp(e, a[mid])==-1)		// e���м�Ԫ��С,����ǰ��
			end = mid - 1;
		else if(strcmp(e, a[mid])==1)	// e���м�Ԫ�ش�,�������
			start = mid + 1;
		else							// e���м�Ԫ��С,�����±�
			return mid;
	}
	if(strcmp(e, a[start])==0)			// ��ʱstart==end,�����˶�����������Ҷ�ڵ�					
		return start;
	return -1;
}

void main()
{
	char a[][30] = {"abc", "jiangsu", "shirui"};
	cout<<bisearch(a, 3, "shirui")<<endl;
}
