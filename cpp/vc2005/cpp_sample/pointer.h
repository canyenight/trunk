#include <iostream>
using namespace std;

class A 
{	
public:
	void Func(void){ cout << "Func of class A" << endl; }
};

void main(void)
{
	A  *p;
		{
			A  a;
			p = &a;	// ע�� a ��������
		}
		p->Func();		// p��"Ұָ��",VC6��������������;��δ���޸�
}