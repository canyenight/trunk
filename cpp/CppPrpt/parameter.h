#include <iostream.h>

void Foo(int x=0, int y=0);	// ��ȷ��ȱʡֵ�����ں�����������

void Foo(int x=0, int y=0)		// ����ȱʡֵ�����ں����Ķ�������, but vc6 passed
{
}

void fn(const char *a)
{
	cout<<"const"<<endl;
	cout<<a<<endl;
}

void fn(char *a)				// vc6 ƥ��������
{
	cout<<"null"<<endl;
	cout<<a<<endl;
}


void main()
{
	fn("shirui");
}
