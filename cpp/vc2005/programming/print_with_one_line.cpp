// programming.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <stdio.h>
#include <cmath>

int p(int x, int y){
    return printf("%d ", x)
        && (x<y && p(x+1, y))
        || (x<y && p(x, x));
}

// && (x<y && (p(x+1, y)) || p(x, x));

int _tmain_pwol(int argc, _TCHAR* argv[])
{
	p(5, 10);
	return 0;
}

/*==================================================
��Ŀ��

дһ������ int p(int x, int y)�����x��y�ٵ�x (����x<y)

Ҫ��ֻ��һ�������ɣ���������?:�ȶ�Ԫ�������͹ؼ��֡�ֻ����һ��printf�⺯����

��˵��Ŀ����EMC����

���

�����ѵ���Ȼ�ں�����ЩҪ���ϡ�ֻ��һ�������ɵ�Ҫ��������������뵽�����ݹ顣���

int p(int x, int y){
    return printf("%d ", x)
        && (x<y && p(x+1, y));
}

������ɴ�x��ӡ��y������

��һ������

int p(int x, int y){
    return printf("%d ", x)
        && (x<y && p(x+1, y))
        || printf("%d ", x);
}

���ǣ�ֵ��ע�������ĿҪ��ֻʹ��һ��printf��������ˣ�����Ǹ�printfҲ�����Ϊ�ݹ���䣬��

int p(int x, int y){
    return printf("%d ", x)
        && (x<y && p(x+1, y))
        || (x<y && p(x, x));
}

�������x>y��������޸������ж�<Ϊ!=���޸�p(x+1, y)Ϊp(x+(y-x)/abs(y-x), y)����

int p(int x, int y){
    return printf("%d ", x)
        && (x!=y && p(x+(y-x)/abs(y-x), y))
        || (x!=y && p(x, x));
}

����������Ĺؼ����ڵݹ顢�߼�����Ķ�·ԭ�������Ǻ��߱�ǰ�߸����뵽��

*/