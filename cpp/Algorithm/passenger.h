/*
��������:��һ���ù���ס��������ͬ�������ˣ����Ƿֱ������������¹���Ӣ��������������˹������������ǵ����ֽ�A��B��C��D��E��F�����ֵ�˳��������Ĺ�����һ�����໥��Ӧ�ġ�������֪��
1)A��������ҽ����
2)E�Ͷ���˹���Ǽ�ʦ��
3)C�͵¹����Ǽ�ʦ��
4)B��F���������������¹��˴�δ�ι�����
5)�����˱�A�����������˱�C�����
6)Bͬ����������Ҫȥ�������У���Cͬ����������Ҫȥ���ݶȼ١�
������������֪������A��B��C��D��E��F�����Ĺ��ˣ�

���磺
A,B,C,D,E,F���ܹ����ֱ�Ϊ:
A���������
B�Ƕ���˹��
C��Ӣ����
D�Ƿ�����
E�ǵ¹���
F��������
63
*/

#include<iostream>
using namespace std;

int Nation[6];				//A--F�Ĺ�����0--5�ֱ��������---�����
int count=0;				//��¼�ж��������
int main()
{
	void Passenger(int num);
	Passenger(0);
	cout<<count<<endl;
	return 0;
}

void Passenger(int num)
{
	 if(num==6)
	 {
		  bool temp;
		  for(int j=0;j<=5;j++)
		  {
			   temp=false;
			   for(int k=j+1;k<=5;k++)
			   {
					if(Nation[j]==Nation[k])
					{
						 temp++;
						 break;
					}
			   }
			   if(temp)
				   break;
		  }

		  if(temp)
			  return;											/*��ȷ����ͬ����*/
  
			  else
			  {
				   if(Nation[0]!=0 && Nation[4]!=4 && Nation[2]!=1		/*������֪����1,2,3*/
					&& Nation[1]!=1 && Nation[5]!=1						/*����4*/
					&& Nation[0]!=3 && Nation[2]!=5						/*����5*/
					&& Nation[1]!=0 && Nation[2]!=3						/*����6*/
					&& Nation[2]!=0 )
				   {
						count++;
						cout<<"A,B,C,D,E,F���ܹ����ֱ�Ϊ:"<<endl;
						for(int k=0;k<=5;k++)
						{
							 cout<<char('A'+k)<<"��";
							 switch(Nation[k]){
							 case 0:cout<<"������"<<endl;break;
							 case 1:cout<<"�¹���"<<endl;break;
							 case 2:cout<<"Ӣ����"<<endl;break;
							 case 3:cout<<"������"<<endl;break;
							 case 4:cout<<"����˹��"<<endl;break;
							 case 5:cout<<"�������"<<endl;break;
							 default:break;
						 }
					}
			   }
		  }
		  return;
	 }
	 else
	 {
		  for(int i=0;i<=5;i++)
		  {
			   Nation[num]=i;
			   num++;
			   Passenger(num);
			   num--;
		  }
	 }
}
