/*
 * �������� 2006-3-8
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import MyOwnObject.testClass;
/**
 * @author mike
 *
 * TODO Ҫ���Ĵ����ɵ�����ע�͵�ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
public class runObjectMethod {
	public static void main(String args[]){
		try{
			FileInputStream fis=new FileInputStream("..\\testClassOBJ");
			ObjectInputStream ois=new ObjectInputStream(fis);
			testClass myObj=(testClass)ois.readObject();
			myObj.test1();
			myObj.test2(3);
			String str=myObj.getStr();
			System.out.println("get the String: \""+str+"\"");
		}catch(FileNotFoundException e){e.printStackTrace();}
		catch(IOException ioe){ioe.printStackTrace();}
		catch(ClassNotFoundException cnfe){cnfe.printStackTrace();}
	}
}
