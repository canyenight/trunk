#ifdef MAIN

#include <iostream.h>


void swap(int *&a,int *&b)
{
 int *temp=b;
 b=a;
 a=temp;
}
void main()
{
 int i=10,j=20;
 int *p=&i;
 int *q=&j;
 swap(p,q);
 //case1��
 cout<<i<<","<<j<<endl;//���Ϊ10��20
 //case2��
 cout<<*p<<","<<*q<<endl;//���Ϊ20��10
}

#endif