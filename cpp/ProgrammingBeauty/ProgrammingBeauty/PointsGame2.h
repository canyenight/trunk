#include <iostream>
#include <string>
#include <cmath>
using namespace std;

const double Threshold = 1E-6;
const int CardsNumber = 4;

const int ResultValue = 24;
double number[CardsNumber] = {1, 8, 3, 5};
string result[CardsNumber];
int ComparedCount = 0;
const int SetNumber = 16;


struct Node {
	string exp;
	double value;
	Node() {
		value = 0;
	}
	Node(const string& str, double v) {
		exp = str;
		value = v;
	}
	bool operator<(const Node& n) const {
		return value < n.value;
	}
} cards[CardsNumber];

set<Node> S[16];

// f(i)�����������i������Ǹ������е�����Ԫ�ؽ������������
// �����������������S[i]��
void f(int i) {
	if(!S[i].empty()) return;

	for(int x = 1; x <= (i-x); x++) {
		if((x & i) == x) { // �ҵ�һ�����Ӽ�
			f(x); //���㼯��x�����������ŵ�S[x]��
			f(i-x);	//���㼯��i-x�����������ŵ�S[i-x]��

			set<Node>::iterator it1, it2;
			for(it1 = S[x].begin(); it1 != S[x].end(); it1++) {
				for(it2 = S[i-x].begin(); it2 != S[i-x].end(); it2++) {
					const Node& a = *it1, b = *it2;

					COUNT();
					S[i].insert(
						Node("("+a.exp+"+"+b.exp+")", a.value+b.value));

					COUNT();
					S[i].insert(
						Node("("+a.exp+"-"+b.exp+")", a.value-b.value));

					COUNT();
					S[i].insert(
						Node("("+b.exp+"-"+a.exp+")", b.value-a.value));

					COUNT();
					S[i].insert(
						Node("("+a.exp+"*"+b.exp+")", a.value*b.value));

					if(b.value != 0) {
						COUNT();
						S[i].insert(
							Node("("+a.exp+"/"+b.exp+")", a.value/b.value));
					}

					if(a.value != 0) {
						COUNT();
						S[i].insert(
							Node("("+b.exp+"/"+a.exp+")", b.value/a.value));
					}
				}
			}
		}
	}
}


bool PointsGame2(int n)
{

	return false;
}

void TestPointsGame2()
{
	char buffer[20];
	for(int i=0; i<CardsNumber; i++)
	{
		itoa(number[i], buffer, 10);
		result[i] = buffer;
	}

	for(int i=1; i<SetNumber; i++)
	{
		S[i] = 0;
	}



	PointsGame2(4);
	cout << "Compared Count: " << ComparedCount << endl;
}