#include <iostream>
#include <stdlib.h>
#include <iomanip>
using namespace std;

void main()
{
	int i=2, j=3;
	double x=2.601, y=1.8;
	cout<< setw(6) << i << setw(10) << j << endl;
	cout<< setw(10) << i*j << endl;
	cout<< "_ _ _ _ _ _"<<endl;
	cout<< setw(8) << x << setw(8) << y << endl;
}

/*
	int i, j, k, l;
	cout<<"Input i(oct), j(hex), k(hex), l(dec):"<<endl;
	cin>> oct>> i; //����Ϊ�˽�����
	cin>> hex>> j; //����Ϊʮ��������
	cin>> k; //������Ϊʮ��������
	cin>> dec>> l; //����Ϊʮ������
	cout<<" hex:"<<" i="<< hex<< i<< endl;
	cout<<" dec:"<<" j="<< dec<< j<<'\t';
	cout<<" k="<< k<< endl;
	cout<<" oct:"<<" l="<< oct<< l;
	cout<< dec << endl; //�ָ�ʮ�������״̬


032 0x3f 0xa0 17 <CR>
��������Ϊ��
hex:i=1a
dec:j=63 k=160
oct:l=21
ע�⣺ʹ�ò���.h ��ͷ�ļ�<iostream> ʱ��������cin
��ָ�����ƣ�����Ӽ�������ʱ�����ϰ˽��ƺ�ʮ��������
��ͷ��0��0x ��־��ָ�����ʡ��0��0x ��־��
ע�⣺��cin��cout��ָ�����ƺ󣬸����ƽ�һֱ��Ч��
ֱ������ָ�����������ơ�
�ر�ע�⣺�������ݵĸ�ʽ�����������ͱ�����cin �е�
����һһ��Ӧ�����򲻽�ʹ�������ݴ��󣬶���Ӱ�������
�����ݵ���ȷ���롣
*/