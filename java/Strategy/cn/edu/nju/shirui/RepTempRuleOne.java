/*
 * �������� 2006-5-3
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package cn.edu.nju.shirui;

public class RepTempRuleOne extends RepTempRule
{

    @Override
    public void replace()
    {
        // TODO �Զ����ɷ������
        // replaceFirst ��jdk1.4 ������
        newString = oldString.replaceFirst("aaa", "bbbb");
        System.out.println("this is replace one");
    }

}
