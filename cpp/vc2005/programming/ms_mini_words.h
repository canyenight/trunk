#include <stdio.h>
#include <string.h>
#include <stdlib.h>

//���ݽṹ˵����һ���ļ�����ĵ��ʱ��浽һ������ṹ����
//������ĸ�������ʾһ�ֵ������ͣ������ʵ�bitset����ͬ��
//���������������еģ�����ÿ����㻹����һ�����������
//������������Ƿ��ϸ����͵ĵ���
struct WordNode
{
	char *str;
	struct WordNode *next;
};

struct WordTypeNode
{
	int bit_set;
	struct WordNode *right;
	struct WordTypeNode *down;
};


int bitset(const char *str)
{
	unsigned int i, result=0;
	for (i=0; i<strlen(str); i++)
	{
		if (str[i]>='a' && str[i]<='z')
		{
			result |= (1<<(str[i]-'a'));
		}
		else if (str[i]>='A' && str[i]<='Z')
		{
			result |= (1<<(str[i]-'A'));
		}
		else
		{
			printf("not a word, including a space or other char...\n");
			return -1;
		}
	}
	return result;
}

int typeExist(struct WordTypeNode *list, int bit)
{
	int result = 0;
	for (; list!=NULL; list=list->down)
	{
		if (bit == list->bit_set)
		{
			result = 1;
		}
	}
	return result;
}

struct WordTypeNode* insertType(struct WordTypeNode *first, int type)  // type means bit_sets
{
	struct WordTypeNode *p = (struct WordTypeNode *)malloc(sizeof(struct WordTypeNode));
	p->bit_set = type;
	p->right = NULL;
	p->down = first;
	first = p;
	return first;
}

struct WordTypeNode* insertWord(struct WordTypeNode *first, char *word)	//�����в���һ������
{
	int bit = bitset(word);
	struct WordTypeNode *find;
	struct WordNode *p = (struct WordNode *)malloc(sizeof(struct WordNode));
	p->str = word;
	if (!typeExist(first,bit))			// �������Ͳ����ڣ�����������ͽڵ�
	{
		first = insertType(first, bit);
	}
	find = first;
	while (find->bit_set != bit)
	{
		find = find->down;
	}
	p->next = find->right;
	find->right = p;					// ע������λ��
	return first;
}

void printAllWords(struct WordTypeNode *list)
{
	struct WordTypeNode *pc;			//pcolumn
	struct WordNode *pl;				//pline
	for (pc=list; pc!=NULL; pc=pc->down)
	{
		printf("pc %d ", pc->bit_set);
		for (pl=pc->right; pl!=NULL; pl=pl->next)
		{
			printf("%s ", pl->str);
		}
		printf("\n");
	}
}


void main()
{
	struct WordTypeNode *first = NULL;
	printf("main start...\n");							///
	first = insertWord(first, "shirui");
	first = insertWord(first, "rudong");
	first = insertWord(first, "SHIRUI");
	first = insertWord(first, "RUDONG");
	printAllWords(first);
}
	