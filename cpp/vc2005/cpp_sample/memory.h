//memory.cpp

#include <stdlib.h>
#include <string.h>
#include <iostream.h>

void GetMemory(char *p, int num)
{
	p = (char *)malloc(sizeof(char) * num);
}

void GetMemory2(char **p, int num)
{
	*p = (char *)malloc(sizeof(char) * num);
}

char *GetMemory3(int num)
{
	char *p = (char *)malloc(sizeof(char) * num);
	return p;
}

char *GetString(void)
{
	char p[] = "hello world";
	return p;	// ���������������
}

char *GetString2(void)
{
	char *p = "hello world";
	return p;
}

void main(void)
{
	char *str = NULL;

//	GetMemory(str, 100);	// str ��ȻΪ NULL	
//	strcpy(str, "hello");	// ���д���
	//����������ҪΪ������ÿ������������ʱ������ָ�����p�ĸ����� _p��
	//������ʹ _p = p������������ڵĳ����޸���_p�����ݣ�
	//�͵��²���p����������Ӧ���޸ġ������ָ������������������ԭ��
	//�ڱ����У�_p�������µ��ڴ棬ֻ�ǰ�_p��ָ���ڴ��ַ�ı��ˣ�����p˿��δ�䡣

/*	GetMemory2(&str, 100);	// ע������� &str��������str���ɹ�!
	strcpy(str, "hello");	
	cout<<str<<endl;
	free(str);	
*/

/*	str = GetMemory3(100);		//�ú�������ֵ�����ݶ�̬�ڴ�,�ɹ�!
	strcpy(str, "hello");
	cout<< str << endl;
	free(str);	
*/

//	str = GetString();			// str ������������, error!
//	cout<< str << endl;

	str = GetString2();
	cout<< str << endl;		//����Test5������Ȼ�����������Ƹ���ȴ�Ǵ���ġ�
	//��ΪGetString2�ڵ�"hello world"�ǳ����ַ�����λ�ھ�̬�洢����
	//���ڳ����������ں㶨���䡣����ʲôʱ�����GetString2��
	//�����ص�ʼ����ͬһ��"ֻ��"���ڴ�顣
}