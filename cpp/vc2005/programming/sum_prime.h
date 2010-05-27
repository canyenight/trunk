//	����C��C++���Ա�дһ�����������m��n֮�������֮�͡���m��nΪ����, m<n��
#include <iostream.h>
#include <math.h>
#include <assert.h>

int sum_prime(int m, int n)
{
	assert((m>1)&&(n>m));			// ������2��ʼ,��m<n
	int i, j, root, sum=0;
	bool isprime = true;

	for(i=m; i<=n; i++)				// �ж�i�Ƿ�������,��m��n
	{
		isprime = true;
		root = (int)sqrt(i);
		for(j=2; j<=root; j++)		// �ж�j�Ƿ���i������,��2��sqrt(i)
		{
			if((i%j)==0)			// i��������
			{
				isprime = false;
				break;
			}
		}
		if(isprime)					//	iΪ����
		{
			sum += i;
			cout<<i<<endl;
		}
	}
	return sum;
}

void main()
{
	cout<<sum_prime(2,100)<<endl;
}
