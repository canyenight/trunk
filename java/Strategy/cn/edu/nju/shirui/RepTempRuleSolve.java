/*
 * �������� 2006-5-3
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package cn.edu.nju.shirui;

public class RepTempRuleSolve
{
    private RepTempRule strategy;
    public RepTempRuleSolve(RepTempRule rule)
    {
        this.strategy=rule;
    }
    public void getNewContext() 
    {
       System.out.println("in getNewContext()"); 
        strategy.replace();
    }
    public void changeAlgorithm(RepTempRule newAlgorithm) 
    {
        strategy = newAlgorithm;
    }
}
