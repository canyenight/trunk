/*
 * �������� 2006-3-8
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package MyOwnObject;
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
		
			FileOutputStream fos=new FileOutputStream("..\\testClassOBJ");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			testClass myObj=new testClass();
			oos.writeObject(myObj);
			oos.flush();
			oos.close();
			fos.close();
		}catch(FileNotFoundException e){e.printStackTrace();}
		catch(IOException ioe){ioe.printStackTrace();}
	}
}
