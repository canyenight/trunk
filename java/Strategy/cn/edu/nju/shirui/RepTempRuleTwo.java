/*
 * �������� 2006-5-3
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package cn.edu.nju.shirui;

public class RepTempRuleTwo extends RepTempRule
{

    @Override
    public void replace()
    {
        // TODO �Զ����ɷ������
        newString=oldString.replaceFirst("aaa", "ccc");
        System.out.println("this is replace Two");
    }

}
