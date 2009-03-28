//String.cpp
#include <iostream.h>		//Ҫ��NULL�������������ļ�
#include "String.h"
#include <string.h>

String::String(const char *str)
{
	if(str == NULL)
	{
		m_data = new char[1];
		*m_data = '\0';
	}	
	else
	{
		int length = strlen(str);
		m_data = new char[length+1];
		strcpy(m_data, str);
	}
}	


// String����������
String::~String(void)
{
	delete [] m_data;	
	// ����m_data���ڲ��������ͣ�Ҳ����д�� delete m_data;
}


String& String::operator=(const String &other)
{
	if (this == &other)
	{
		return *this;
	}

	delete m_data;

	m_data = new char[strlen(other.m_data)+1];
	strcpy(m_data, other.m_data);
	return *this;	// ���ص��� *this�����ã����追������
}

String::String(const String &other)
{	
	// �������other��˽�г�Աm_data
	int length = strlen(other.m_data);	
	m_data = new char[length+1];
	strcpy(m_data, other.m_data);
}


String  operator+(const String &s1, const String &s2)  
{
	String temp("");	//��ô����	String(const String &other)�ˣ�shirui
	delete temp.m_data;	// temp.data�ǽ���'\0'���ַ���
	temp.m_data = new char[strlen(s1.m_data) + strlen(s2.m_data) +1];
	strcpy(temp.m_data, s1.m_data);
	strcat(temp.m_data, s2.m_data);
	return temp;
}
/*
*/