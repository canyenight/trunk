import java.io.*;
import java.util.*;


public class ClassInfo
{
	// read classroom.dat to construct a array 
	public ClassInfo()
	{
		readData("classroom.dat");
	}
	
	public void readData(String filename)
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String s = in.readLine();
			StringTokenizer t = new StringTokenizer(s);
			
			year = Integer.parseInt(t.nextToken());
			half = Integer.parseInt(t.nextToken());
			lines = Integer.parseInt(t.nextToken());
			infoArray = new int[lines][12];
			
			
			for (int i=0; i<lines; i++)
			{
				s = in.readLine();
				t = new StringTokenizer(s);
				for (int j=0; j<12; j++)
				{
					if (t.hasMoreTokens())
					{
						infoArray[i][j] = Integer.parseInt(t.nextToken());
					}
				}
			}
			in.close();
		}
		catch (IOException ie)
		{
			ie.printStackTrace();
		}	
	}
	
	// ��Щ�������Ǵӽ���ֱ�ӷ��أ��±��0��ʼ��תΪ��ʵ����ʱ��1
	public int[] searchRoom(int zone, int week, int single, boolean[] orders)
	{
		//������֤
		if (zone<0 || zone>5)
		{
			System.out.println("��ѧ����Ϣ����");
			return null;
		}
		if (week<0 || week>4)
		{
			System.out.println("������Ϣ����");
			return null;
		}	
		if (single<0 || single>2)
		{
			System.out.println("��˫����Ϣ����");
			return null;
		}
		if (orders.length!=10)
		{
			System.out.println("�ڴ���Ϣ����");
			return null;
		}
		
		boolean orderEmpty = true;
		for (int i=0; i<10; i++)
		{
			if (orders[i]==true)
			{
				orderEmpty = false;
			}
		}
		if (orderEmpty)
		{
			System.out.println("��ѯ�ڴ�Ϊ�գ�");
			return null;
		}
		
		
		
		int numRoom = (int)(lines-1)/5 + 1;
		System.out.println("numRoom:"+numRoom);
		boolean[] roomValid = new boolean[numRoom];  // �������±��һ���嵽infoArrayȡ���Һ�
		for(int i=0; i<numRoom; i++)
		{
			roomValid[i] = true;						//Ĭ�������еĽ���ȫ������Ҫ��
		}
		
		//������֤
		int begin = week;								//ÿ���������찴˳������һ�𣬸������
		
		//��ѧ����֤
		for (int i=0; i<numRoom; i++)
		{
			if (infoArray[i*5+begin][0]/10000 != (zone+1))
			{
				roomValid[i] = false;
			}
		}
		
		//�͵�˫�ܺͽڴμ���
		switch(single)
		{
		case 0:  // Ҫ��˫�ܶ�û�пΣ��α�öα���Ϊ0
			for (int i=0; i<numRoom; i++)
			{
				for(int j=1; j<11; j++)
				{
					if (roomValid[i] && orders[j-1] && infoArray[i*5+begin][j]!=0)
					{
						roomValid[i] = false;
					}
				}
			}
			break;
		case 1:		//Ҫ����û��
			for (int i=0; i<numRoom; i++)
			{
				for(int j=1; j<11; j++)
				{
					if (roomValid[i] && orders[j-1] && (infoArray[i*5+begin][j]==1 || infoArray[i*5+begin][j]==2))
					{
						roomValid[i] = false;
					}
				}
			}			
			break;
		case 2:
			for (int i=0; i<numRoom; i++)
			{
				for(int j=1; j<11; j++)
				{
					if (roomValid[i] && orders[j-1] && (infoArray[i*5+begin][j]==1 || infoArray[i*5+begin][j]==3))
					{
						roomValid[i] = false;
					}
				}
			}				
			break;
		default:
			return null;	
		}
		
		int numValid = 0;
		for (int i=0; i<numRoom; i++)
		{
			if (roomValid[i])
			{
				numValid ++;
			}
		}
		int[] res = new int[numValid];
		
		int j = 0;
		for (int i=0; i<numRoom; i++)			// ���еĽ��ҺŸ��Ƶ����������
		{
			if (roomValid[i])
			{
				res[j++] = infoArray[i*5+begin][0];
			}
		} 
		
		return res;
	}

	public void geneArray() //��classroom.dat�ļ�д������ĸ�ʽ�����Ƶ�J2ME������
	{
		try
		{
			PrintWriter out = new PrintWriter(new FileWriter("array.dat"));
			for (int i=0; i<lines; i++)
			{
				out.print("{");
				for (int j=0; j<11; j++)
				{
					out.print(infoArray[i][j]+",");
				}
				out.println(infoArray[i][11]+"},");
			}
			out.close();
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
		System.out.println("Array has been copied into array.dat!");
	}
	
	public void showInfoArray()
	{
		for (int i=0; i<lines; i++)
		{
			for (int j=0; j<12; j++)
			{
				System.out.print(infoArray[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public String displayInfo()
	{
		String info = " �������Ͼ���ѧ�ֿ�У��\n" + year;
		String isFirst = half==1?"�ϰ�ѧ��":"�°�ѧ��";
		info += isFirst;
		info += ("��"+lines+"����¼\n");
		info += "Copyright��С�ٺϹ�����";
		
		return info;
	}
	
	private int[][] infoArray;
	private int year;
	private int half;
	private int lines;
}


/********************************************************************************
			//************************************************
			//��ʾʣ�µĽ��֮��
			System.out.println("after case 0:");
			for (int i=0; i<numRoom; i++)
			{

				if (roomValid[i])
				{
					for (int j=0; j<12; j++)
					{
						System.out.print(infoArray[i*5+begin][j]+" ");
					}
					System.out.println();
//					System.out.println("----------------------------");					
				}
			}
			//************************************************
//����ʾ
for (int j=0; j<12; j++)
{
	System.out.print(infoArray[i*5+begin][j]+" ");
}
System.out.println();



//*****************************************************
int numValid = 0;
for (int i=0; i<numRoom; i++)
{
	if (roomValid[i])
	{
		numValid ++;
	}
}
int[] res = new int[numValid];

int k = 0;
for (int i=0; i<numRoom; i++)			// ���еĽ��ҺŸ��Ƶ����������
{
	if (roomValid[i])
	{
		res[k++] = infoArray[i*5+begin][0];
	}
} 
System.out.println("**Total:"+res.length);
for (int i=0; i<res.length; i++)
{
	System.out.println(res[i]);
}		

//*****************************************************/
