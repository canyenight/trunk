/*
 * �������� 2006-5-3
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package cn.edu.nju.shirui;

public class Test
{
    public static void main(String[] args)
    {
        Test test = new Test();
        test.testReplace();
    }
    public void testReplace()
    {
      // ʹ�õ�һ���������
      RepTempRuleSolve solver = new RepTempRuleSolve(new RepTempRuleOne());
      solver.getNewContext();
      
      // ʹ�õڶ���
      solver=new RepTempRuleSolve(new RepTempRuleTwo());
      solver.getNewContext();
    }
}
