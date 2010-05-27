//String.h

class String
{
public:
	String(const char* str);
	String(const String &other);
	~String();
	String & operator=(const String &other);	
	// ���ڸ�ֵ������Ӧ����"���ô���"�ķ�ʽ����String����
	friend String operator+(const String &s1, const String &s);
	// ������Ӻ�����Ӧ����"ֵ����"�ķ�ʽ����String����
private:
	char *m_data;
};
