#include <iostream.h>

class Base
{
  public: 
	virtual ~Base() { cout<< "~Base" << endl ; }		// Ϊʲô�����ᱻ�Զ�����
};

class Derived : public Base
{
  public: 
	virtual ~Derived() { cout<< "~Derived" << endl ; }
};

void main(void)
{
	Base * pB = new Derived;  // upcast
	delete pB;
}
