#include <iostream>
using namespace std;

void main()
{
//  P37:�����Ҫ����һ����main�˳���ִ�еĴ��룬����ʹ��atexit()����ע��һ������
	atexit(fn);
	cout<<"end main()..."<<endl;
}

void fn()
{
	cout<<"in function fn()..."<<endl;
}
