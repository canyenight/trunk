/*
 * �������� 2006-3-8
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package MyOwnObject;
import java.io.Serializable;

/**
 * @author mike
 *
 * TODO Ҫ���Ĵ����ɵ�����ע�͵�ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
public class testClass implements Serializable{
	public String str="this is my  OBJECT!";
	public transient String str2="this is my OBJECT'S transient String";
	public void test1(){
		System.out.println("the method:   testClass::test1()!");
	}
	public void test2(int int0){
		System.out.println("the method:   testClass::test2("+int0+")!");
		
	}
	public String getStr(){
		System.out.println("method:   testClass::getStr()");
		return this.str;
	}
}
