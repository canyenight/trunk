/*
 * �������� 2006-5-3
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package cn.edu.nju.shirui;

public abstract class RepTempRule
{
    protected String oldString = "";
    public void setOldString(String oldString)
    {
        this.oldString=oldString;
    }
    protected String newString="";

    public String getNewString()
    {
        return newString;
    }
    public abstract void replace();
}
