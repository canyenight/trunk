/*
 * �������� 2006-3-8
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package OriginalObject;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * @author mike
 *
 * TODO Ҫ���Ĵ����ɵ�����ע�͵�ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
public class writeObject {
		
	public static void main(String args[]){
		try{
		
			FileOutputStream fos=new FileOutputStream("..\\StringOBJ");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			String strObj="this is a String Object For testing!";
			oos.writeObject(strObj);
			oos.flush();
			oos.close();
			fos.close();
		}catch(FileNotFoundException e){e.printStackTrace();}
		catch(IOException ioe){ioe.printStackTrace();}
	}
}
