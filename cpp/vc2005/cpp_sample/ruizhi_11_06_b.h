#include <iostream>
using namespace std;


/*
���ж�һ�������������λ���Ƿ�Ϊ4λ�����ֱ��������λ�ϵ����֡�
��������Ч����
C:\>������һ����λ����1234
         ��λ�ǣ�4��
         ʮλ�ǣ�3��
         ��λ�ǣ�2��
         ǧλ�ǣ�1��
		 ,quotient,residue
*/
void main()
{
	int num;
	cout<<"������һ����λ����";
	cin>>num;
	if(num<1000||num>9999)
	{
		cout<<"�����������λ������4λ!"<<endl;
		return;
	}
	
	cout<<"��λ�ǣ�"<<num%10<<endl;
	cout<<"ʮλ�ǣ�"<<num/10%10<<endl;
	cout<<"��λ�ǣ�"<<num/100%10<<endl;
	cout<<"ǧλ�ǣ�"<<num/1000<<endl;
}