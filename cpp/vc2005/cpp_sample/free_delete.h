#include <iostream>
using namespace std;

void main()
{
	char *p = (char *) malloc(100);
	strcpy(p, "hello");
	free(p);	    // p ��ָ���ڴ汻�ͷţ�����p��ָ�ĵ�ַ��Ȼ����

//	p = NULL;

	if(p != NULL)	// û���𵽷�������,��VC6ȴ�����˴˾�
	{
	   strcpy(p, "world");	// ����
	}
	cout<<p<<endl;
}
