/*
 * �������� 2006-3-8
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package OriginalObject;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 * @author mike
 *
 * TODO Ҫ���Ĵ����ɵ�����ע�͵�ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
public class readObject {
	public static void main(String args[]){
		try{
			FileInputStream fis=new FileInputStream("..\\StringOBJ");
			ObjectInputStream ois=new ObjectInputStream(fis);
			String strOBJ=(String)ois.readObject();
			System.out.println(strOBJ);
		}catch(FileNotFoundException e){e.printStackTrace();}
		catch(IOException ioe){ioe.printStackTrace();}
		catch(ClassNotFoundException cnfe){cnfe.printStackTrace();}
	}
}
