/*
 * �������� 2006-3-8
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author hanliang
 *
 * TODO Ҫ���Ĵ����ɵ�����ע�͵�ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
public class Client {
	public static void main(String args[]){
		
	  	try
	  	  {
	  		Socket socket= new Socket("127.0.0.1", Server.port);
	  		OutputStream os=socket.getOutputStream();
	    	ObjectOutputStream oos = new ObjectOutputStream(os);// ��	
			oos.writeObject("socket test");
			oos.flush();
			oos.close();
			socket.close();
		  }catch(Exception e)
		  {
		  	e.printStackTrace();
		  }
	}
}
