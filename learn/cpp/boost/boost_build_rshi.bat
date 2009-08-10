REM # run bootstrap.bat to generate bjam.exe with your platform

REM # build params
REM bjam���� --build-dir=<builddir> �������ʱ�ļ������builddir��(�����ȽϺù���������Ϳ��԰���ɾ����)
REM --stagedir=<stagedir> ��ű������ļ���·����Ĭ����stage
REM --build-type=complete �������а汾����Ȼֻ�����һС���ְ汾��ȷ�е�˵���൱��:variant=release, threading=multi; link=shared|static; runtime-link=shared��
REM variant=debug|release ��������ʲô�汾(Debug or Release?)
REM link=static|shared ����ʹ�þ�̬�⻹�Ƕ�̬�⡣
REM threading=single|multi ����ʹ�õ��̻߳��Ƕ��߳̿⡣
REM runtime-link=static|shared �����Ǿ�̬���Ƕ�̬����C/C++��׼�⡣
REM --with-<library> ֻ����ָ���Ŀ⣬������--with-regex��ֻ����regex���ˡ�
REM --show-libraries ��ʾ��Ҫ����Ŀ�����

REM bjam stage --toolset=msvc-9.0 --without-python --stagedir="E:SDKboost_1_39_0vc9" link=shared runtime-link=shared threading=multi debug release
REM  --with-date_time --with-thread error: both --with-<library> and --without-<library> specified
bjam --toolset=msvc-8.0 --without-python --link=static --threading=multi --runtime-link=shared debug stage

REM # wait your input to terminate
pause