#include <cmath>
#include <iostream>
using namespace std;

// shift operation, log(2, v)
int count_1(int v) {
	int num = 0;
	while(v) {
		num += v & 0x01;
		v >>= 1;
	}
	return num;
}

// tricky, O(M), M is the count of 1
int count_2(int v) {
	int num = 0;
	while(v) {
		v &= v - 1;
		num ++;
	}
	return num;
}

/*
1. HAKMEM�㷨��
˵���������ǽ������Ƹ�λ����һ�飬���ÿ����1�ĸ�����
Ȼ����������鲢���õ�����һ���1�ĸ���������������ó�63ȡ��õ��˽����
��Ϊ2^6 = 64��Ҳ����˵ x_0 + x_1 * 64 + x_2 * 64 * 64 = x_0 + x_1 + x_2 (mod 63)������ĵȺű�ʾͬ�ࡣ
�������ֻ��Ҫʮ������ָ����Ҳ��ô棬�ٶȺܿ졣
*/
int count_3(unsigned x)
{
    unsigned n;    

    n = (x >> 1) & 033333333333;    
    x = x - n;   
    n = (n >> 1) & 033333333333;   
    x = x - n;    
    x = (x + (x >> 3)) & 030707070707;   
	// x = x - int(x/63); 
	x = (int)fmod((double)x, 63);  // modu(x, 63);  
    return x;   
}  



/*
˵���� �����õ��Ƕ��ַ�������һ����ӣ�֮���ĸ��ĸ�һ����ӣ����Ű˸��˸������͵õ���λ֮����
x = 342144321, 
x = 0x1464B541, 10100011001001011010101000001

x = 10111101
x >> 1 => 01011110 & 0x55 => 01010100
x - ((x >> 1) & 0x55) = > 01101001 (1, 2, 2, 1)

<--
x & 0x55 => 00010101
(x >> 1) & 0x55 => 01010100
(x & 0x55) + ((x >> 1) & 0x55) => 01101001 (1, 2, 2, 1)
<--

x & 0x33 => 00100001
((x >> 2) & 0x33) => 00010010
(x & 0x33) + ((x >> 2) & 0x33) => 00110011 (3, 3)

(x + (x >> 4)) = 00000100 => 6

*/
int count_4(unsigned x)
{
	x = x - ((x >> 1) & 0x55555555);
	x = (x & 0x33333333) + ((x >> 2) & 0x33333333);
	x = (x + (x >> 4)) & 0x0F0F0F0F;
	x = x + (x >> 8);
	x = x + (x >> 16);
	return x & 0x0000003F;
}

// simple format of count_4
int count_4_0(unsigned x)
{
	x = (x & 0x55555555) + ((x >> 1) & 0x55555555);
	x = (x & 0x33333333) + ((x >> 2) & 0x33333333);
	x = (x & 0x0F0F0F0F) + ((x >> 4) & 0x0F0F0F0F);
	x = (x & 0x00FF00FF) + ((x >> 8) & 0x00FF00FF);
	x = (x & 0x0000FFFF) + ((x >> 16) & 0x0000FFFF);

	return x;
}

void main() {
	int v = 342144321;
	cout << count_1(v) << endl;
	cout << count_2(v) << endl;
	cout << count_3(v) << endl;
	cout << count_4(v) << endl;
	cout << count_4_0(v) << endl;

	cout << "end..." << endl;
}