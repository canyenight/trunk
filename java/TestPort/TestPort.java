/*
 * �������� 2006-2-16
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */

/**
 * @author shirui
 *
 * TODO Ҫ���Ĵ����ɵ�����ע�͵�ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
import java.net.*;

public class TestPort {
	private static ServerSocket serverSkt;
	public static void main(String args[])
	{
		try
		{
			int port =1433;
			serverSkt=new ServerSocket(port);
			System.out.println("Open server "+port+" success!");
			new server().start();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static class server extends Thread
	{
		public server()
		{
			super("server");
			this.run();
		}
		public void run()
		{
			while(true)
			{
				try
				{
					Socket skt=serverSkt.accept();
					skt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
}
