
public class SimpleClassInfo
{
	// read classroom.dat to construct a array 
	public SimpleClassInfo()
	{
		//����J2ME�汾��ClassInfo,�ֻ���֧���ļ�ϵͳ���ʲ������ļ�����
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
		case 0:  // Ҫ��˫�ܶ�û�пΣ��α��öα���Ϊ0
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
	
	private int year = 2006;
	private int half = 1;
	private int lines = 675;
	private int[][] infoArray = 
		{
			{40101,1,1,1,1,1,1,0,0,1,1,1},
			{40101,1,1,1,1,1,1,1,1,1,1,2},
			{40101,1,1,1,1,1,1,1,1,1,1,3},
			{40101,0,0,1,1,1,1,1,0,1,1,4},
			{40101,1,1,1,1,1,1,1,1,0,0,5},
			{10301,1,1,1,1,0,0,0,0,0,0,1},
			{10301,1,1,1,1,0,0,0,0,0,0,2},
			{10301,1,1,1,1,0,0,0,0,0,0,3},
			{10301,1,1,1,1,1,1,0,0,0,0,4},
			{10301,1,1,1,1,0,0,0,0,0,0,5},
			{10302,1,1,1,1,0,0,0,0,0,0,1},
			{10302,1,1,1,1,0,0,0,0,0,0,2},
			{10302,1,1,1,1,0,0,0,0,0,0,3},
			{10302,1,1,1,1,1,1,0,0,0,0,4},
			{10302,1,1,1,1,1,1,0,0,0,0,5},
			{11303,1,1,1,1,1,1,0,0,0,0,1},
			{11303,1,1,1,1,1,1,0,0,0,0,2},
			{11303,1,1,1,1,1,1,0,0,0,0,3},
			{11303,1,1,1,1,1,1,0,0,0,0,4},
			{11303,1,1,1,1,1,1,0,0,0,0,5},
			{12303,1,1,1,1,1,1,0,0,0,0,1},
			{12303,1,1,1,1,1,1,0,0,0,0,2},
			{12303,1,1,1,1,1,1,0,0,0,0,3},
			{12303,1,1,1,1,1,1,0,0,0,0,4},
			{12303,1,1,0,0,1,1,0,0,0,0,5},
			{11304,1,1,1,1,1,1,0,0,0,0,1},
			{11304,1,1,1,1,1,1,0,0,0,0,2},
			{11304,1,1,1,1,1,1,0,0,0,0,3},
			{11304,1,1,1,1,1,1,0,0,0,0,4},
			{11304,0,0,0,0,0,0,0,0,0,0,5},
			{12304,1,1,1,1,1,1,0,0,0,0,1},
			{12304,1,1,1,1,1,1,0,0,0,0,2},
			{12304,1,1,1,1,1,1,1,0,0,0,3},
			{12304,1,1,1,1,1,1,0,0,0,0,4},
			{12304,0,0,0,0,0,0,0,0,0,0,5},
			{11305,0,1,1,1,1,1,0,0,0,0,1},
			{11305,1,1,1,1,1,1,0,0,0,0,2},
			{11305,1,1,1,1,1,1,0,0,0,0,3},
			{11305,1,1,1,1,1,1,0,0,0,0,4},
			{11305,0,0,0,0,0,0,0,0,0,0,5},
			{12305,0,1,1,1,0,0,0,0,0,0,1},
			{12305,1,1,1,1,0,0,0,0,0,0,2},
			{12305,1,1,1,1,0,0,0,0,0,0,3},
			{12305,1,1,1,1,1,1,0,0,0,0,4},
			{12305,0,0,0,0,0,0,0,0,0,0,5},
			{10308,0,0,1,1,0,0,0,0,0,0,1},
			{10308,1,1,1,1,1,1,0,0,0,0,2},
			{10308,1,1,1,1,0,0,0,0,0,0,3},
			{10308,1,1,1,1,1,1,0,0,0,0,4},
			{10308,0,0,0,0,0,0,0,0,0,0,5},
			{11309,1,1,0,0,0,0,0,0,0,0,1},
			{11309,1,1,1,1,0,0,0,0,0,0,2},
			{11309,1,1,3,3,1,1,0,0,0,0,3},
			{11309,1,1,0,0,0,0,0,0,0,0,4},
			{11309,1,1,0,0,0,0,0,0,0,0,5},
			{12309,1,1,0,0,0,0,0,0,0,0,1},
			{12309,1,1,1,1,0,0,0,0,0,0,2},
			{12309,1,1,1,1,0,0,0,0,0,0,3},
			{12309,1,1,1,1,0,0,0,0,0,0,4},
			{12309,0,0,0,0,1,1,0,0,0,0,5},
			{10403,1,1,1,1,0,0,1,1,0,0,1},
			{10403,1,1,1,1,1,1,1,1,0,0,2},
			{10403,0,1,1,1,1,1,1,0,0,0,3},
			{10403,0,0,1,1,1,1,1,1,0,0,4},
			{10403,1,1,1,1,1,1,1,0,0,0,5},
			{10404,0,0,1,1,1,1,0,0,0,0,1},
			{10404,1,1,1,1,0,0,0,0,0,0,2},
			{10404,1,1,1,1,1,1,1,0,0,0,3},
			{10404,1,1,1,1,1,1,0,0,0,0,4},
			{10404,1,1,1,1,1,1,1,0,0,0,5},
			{10405,1,1,1,1,1,1,0,0,0,0,1},
			{10405,1,1,0,0,1,1,0,0,0,0,2},
			{10405,1,1,1,1,0,0,0,0,0,0,3},
			{10405,1,1,1,1,1,1,0,0,0,0,4},
			{10405,1,1,1,1,1,1,0,0,0,0,5},
			{10406,1,1,1,1,1,1,0,0,0,0,1},
			{10406,1,1,1,1,1,1,1,0,0,0,2},
			{10406,1,1,1,1,0,0,0,0,0,0,3},
			{10406,1,1,1,1,1,1,0,0,0,0,4},
			{10406,1,1,1,1,0,0,0,0,0,0,5},
			{10407,0,0,1,1,1,1,0,0,0,0,1},
			{10407,1,1,1,1,1,1,0,0,0,0,2},
			{10407,1,1,1,1,1,1,1,1,0,0,3},
			{10407,0,1,1,1,1,1,0,0,0,0,4},
			{10407,1,1,1,1,1,1,0,0,0,0,5},
			{10408,0,0,0,0,0,0,0,0,0,0,1},
			{10408,1,1,1,1,1,1,1,0,0,0,2},
			{10408,0,0,1,1,1,1,0,0,0,0,3},
			{10408,0,0,1,1,1,1,1,1,0,0,4},
			{10408,0,0,1,1,0,0,0,0,0,0,5},
			{10420,1,1,1,1,1,1,0,0,0,0,1},
			{10420,1,1,1,1,0,0,0,0,0,0,2},
			{10420,1,1,1,1,0,0,0,0,0,0,3},
			{10420,1,1,1,1,1,1,0,0,0,0,4},
			{10420,1,1,1,1,0,0,0,0,0,0,5},
			{10422,1,1,1,1,1,1,0,0,0,0,1},
			{10422,1,1,1,1,0,0,0,0,0,0,2},
			{10422,1,1,1,1,0,0,0,0,0,0,3},
			{10422,1,1,1,1,1,1,1,1,0,0,4},
			{10422,1,1,0,0,0,0,0,0,0,0,5},
			{10424,1,1,1,1,0,0,0,0,0,0,1},
			{10424,1,1,1,1,0,0,0,0,0,0,2},
			{10424,1,1,1,1,0,0,0,0,0,0,3},
			{10424,1,1,0,0,0,0,0,0,0,0,4},
			{10424,0,0,1,1,0,0,0,0,0,0,5},
			{10426,1,1,1,1,0,0,0,0,0,0,1},
			{10426,1,1,1,1,0,0,0,0,0,0,2},
			{10426,1,1,1,1,0,0,0,0,0,0,3},
			{10426,1,1,1,1,1,1,0,0,0,0,4},
			{10426,0,0,1,1,0,0,0,0,0,0,5},
			{10501,1,1,0,0,1,1,1,0,0,0,1},
			{10501,1,1,1,1,1,1,1,0,0,0,2},
			{10501,1,1,1,1,1,1,0,0,0,0,3},
			{10501,1,1,1,1,1,1,0,0,0,0,4},
			{10501,1,1,1,1,1,1,1,1,0,0,5},
			{10502,1,1,1,1,1,1,0,0,0,0,1},
			{10502,0,0,1,1,0,0,0,0,0,0,2},
			{10502,1,1,1,1,0,0,0,0,0,0,3},
			{10502,3,3,1,1,1,1,1,0,0,0,4},
			{10502,0,0,1,1,1,1,0,0,0,0,5},
			{10503,0,0,1,1,1,1,1,0,0,0,1},
			{10503,1,1,1,1,1,1,1,0,0,0,2},
			{10503,0,0,1,1,1,1,0,0,0,0,3},
			{10503,0,0,1,1,1,1,0,0,0,0,4},
			{10503,1,1,1,1,1,1,0,0,0,0,5},
			{10504,1,1,1,1,0,0,0,0,0,0,1},
			{10504,1,1,1,1,0,0,0,0,0,0,2},
			{10504,1,1,1,1,0,0,0,0,0,0,3},
			{10504,0,0,1,1,1,1,0,0,0,0,4},
			{10504,0,1,1,1,0,0,0,0,0,0,5},
			{10505,3,3,1,1,1,1,1,0,0,0,1},
			{10505,1,1,1,1,1,1,0,0,0,0,2},
			{10505,1,1,0,0,1,1,0,0,0,0,3},
			{10505,0,0,1,1,1,1,0,0,0,0,4},
			{10505,1,1,1,1,1,1,1,1,0,0,5},
			{10506,0,0,1,1,1,1,1,1,0,0,1},
			{10506,1,1,1,1,1,1,1,0,0,0,2},
			{10506,1,1,1,1,1,1,1,1,0,0,3},
			{10506,1,1,1,1,1,1,0,0,0,0,4},
			{10506,1,1,1,1,1,1,0,0,0,0,5},
			{10507,0,0,1,1,1,1,1,0,0,0,1},
			{10507,1,1,1,1,1,1,1,1,0,0,2},
			{10507,3,3,1,1,1,1,1,1,0,0,3},
			{10507,0,0,2,2,1,1,1,1,0,0,4},
			{10507,0,0,1,1,1,1,0,0,0,0,5},
			{10508,0,0,1,1,1,1,0,0,0,0,1},
			{10508,1,1,1,1,1,1,0,0,0,0,2},
			{10508,1,1,1,1,1,1,0,0,0,0,3},
			{10508,0,0,3,3,1,1,0,0,0,0,4},
			{10508,0,0,1,1,1,1,0,0,0,0,5},
			{10510,1,1,2,2,1,1,0,0,0,0,1},
			{10510,1,1,1,1,1,1,0,0,0,0,2},
			{10510,1,1,1,1,1,1,0,0,0,0,3},
			{10510,1,1,1,1,1,1,0,0,0,0,4},
			{10510,0,0,0,0,0,0,0,0,0,0,5},
			{30301,1,1,1,1,0,0,0,0,0,0,1},
			{30301,1,1,1,1,0,0,0,0,0,0,2},
			{30301,1,1,1,1,1,1,0,0,0,0,3},
			{30301,1,1,1,1,0,0,0,0,0,0,4},
			{30301,1,1,1,1,0,0,0,0,0,0,5},
			{10419,1,1,0,0,1,1,0,0,0,0,1},
			{10419,1,1,1,1,0,0,0,0,0,0,2},
			{10419,1,1,0,0,1,1,0,0,0,0,3},
			{10419,1,1,0,0,1,1,0,0,0,0,4},
			{10419,1,1,1,1,0,0,0,0,0,0,5},
			{10423,1,1,0,0,0,0,0,0,0,0,1},
			{10423,0,0,0,0,1,1,0,0,0,0,2},
			{10423,1,1,0,0,1,1,0,0,0,0,3},
			{10423,0,0,1,1,0,0,0,0,0,0,4},
			{10423,0,0,0,0,0,0,0,0,0,0,5},
			{10509,1,1,1,1,1,1,1,1,0,0,1},
			{10509,1,1,1,1,1,1,0,0,0,0,2},
			{10509,1,1,1,1,0,0,1,1,0,0,3},
			{10509,1,1,0,0,1,1,1,1,0,0,4},
			{10509,1,1,1,1,1,1,0,0,0,0,5},
			{10511,1,1,1,1,1,1,1,1,0,0,1},
			{10511,1,1,1,1,0,0,1,1,0,0,2},
			{10511,1,1,0,0,0,0,0,0,0,0,3},
			{10511,1,1,0,0,1,1,1,1,0,0,4},
			{10511,1,1,1,1,0,0,0,0,0,0,5},
			{10512,1,1,1,1,1,1,0,0,0,0,1},
			{10512,1,1,1,1,0,0,0,0,0,0,2},
			{10512,1,1,1,1,0,0,0,0,0,0,3},
			{10512,1,1,1,1,1,1,1,1,0,0,4},
			{10512,0,0,1,1,0,0,0,0,0,0,5},
			{10513,1,1,1,1,1,1,0,0,0,0,1},
			{10513,1,1,1,1,0,0,1,1,0,0,2},
			{10513,1,1,0,0,0,0,0,0,0,0,3},
			{10513,1,1,0,0,1,1,1,1,0,0,4},
			{10513,1,1,1,1,0,0,0,0,0,0,5},
			{10514,1,1,1,1,1,1,0,0,0,0,1},
			{10514,0,0,1,1,0,0,0,0,0,0,2},
			{10514,1,1,1,1,0,0,0,0,0,0,3},
			{10514,1,1,1,1,0,0,0,0,0,0,4},
			{10514,1,1,1,1,0,0,0,0,0,0,5},
			{10517,1,1,1,1,0,0,0,0,0,0,1},
			{10517,1,1,1,1,0,0,0,0,0,0,2},
			{10517,0,0,0,0,0,0,0,0,0,0,3},
			{10517,1,1,1,1,1,1,0,0,0,0,4},
			{10517,1,1,1,1,0,0,0,0,0,0,5},
			{10519,1,1,1,1,0,0,0,0,0,0,1},
			{10519,1,1,1,1,0,0,0,0,0,0,2},
			{10519,1,1,1,1,1,1,0,0,0,0,3},
			{10519,1,1,1,1,0,0,0,0,0,0,4},
			{10519,1,1,1,1,0,0,0,0,0,0,5},
			{20101,1,1,1,1,1,1,1,0,0,0,1},
			{20101,1,1,0,0,1,1,1,1,1,1,2},
			{20101,1,1,1,1,1,1,1,1,0,0,3},
			{20101,0,0,2,2,1,1,1,1,1,1,4},
			{20101,1,1,1,1,3,3,0,0,0,0,5},
			{20102,2,2,0,0,1,1,1,0,0,0,1},
			{20102,0,0,1,1,0,0,1,1,1,1,2},
			{20102,1,1,0,0,0,0,3,3,0,0,3},
			{20102,0,0,1,1,1,1,1,1,1,1,4},
			{20102,3,3,1,1,1,1,1,0,0,0,5},
			{20103,3,3,1,1,1,1,1,0,1,1,1},
			{20103,0,0,1,1,1,1,1,1,1,1,2},
			{20103,1,1,1,1,0,0,1,1,0,0,3},
			{20103,1,1,1,1,1,1,0,0,0,0,4},
			{20103,1,1,1,1,0,0,0,0,0,0,5},
			{20106,1,1,1,1,1,1,1,0,0,0,1},
			{20106,1,1,1,1,1,1,1,0,1,1,2},
			{20106,0,0,1,1,1,1,1,0,1,1,3},
			{20106,1,1,1,1,1,1,1,0,0,0,4},
			{20106,3,3,1,1,1,1,1,1,0,0,5},
			{20109,0,1,1,1,1,1,0,0,0,0,1},
			{20109,1,1,1,1,1,1,1,1,1,1,2},
			{20109,1,1,0,0,1,1,1,1,3,3,3},
			{20109,1,1,1,1,1,1,0,0,0,0,4},
			{20109,1,1,0,0,1,1,0,0,1,1,5},
			{20111,0,0,1,1,3,3,1,1,1,1,1},
			{20111,1,1,0,0,1,1,1,1,1,1,2},
			{20111,1,1,1,1,1,1,2,2,0,0,3},
			{20111,1,1,2,2,1,1,0,0,0,0,4},
			{20111,1,1,1,1,1,1,0,0,0,0,5},
			{20201,1,1,0,0,0,0,1,1,0,0,1},
			{20201,0,0,0,0,0,0,1,1,1,1,2},
			{20201,1,1,1,1,1,1,1,1,1,1,3},
			{20201,0,0,1,1,1,1,1,1,0,0,4},
			{20201,1,1,1,1,1,1,0,0,0,0,5},
			{20202,1,1,0,0,1,1,1,1,1,1,1},
			{20202,0,0,0,0,1,1,0,0,1,1,2},
			{20202,1,1,1,1,1,1,0,0,1,1,3},
			{20202,0,0,0,0,1,1,0,0,0,0,4},
			{20202,1,1,1,1,1,0,0,0,0,0,5},
			{20203,0,0,1,1,1,1,1,0,1,1,1},
			{20203,0,0,1,1,1,1,1,1,0,0,2},
			{20203,1,1,1,1,0,0,1,1,0,0,3},
			{20203,1,1,0,0,1,1,1,1,1,1,4},
			{20203,1,1,1,1,0,0,0,0,1,1,5},
			{20206,0,0,1,1,1,1,1,1,0,0,1},
			{20206,0,0,0,0,1,1,1,1,0,0,2},
			{20206,1,1,1,1,1,1,2,2,0,0,3},
			{20206,0,0,1,1,1,1,1,0,0,0,4},
			{20206,1,1,1,1,0,0,0,0,0,0,5},
			{30104,1,1,1,1,1,1,0,0,0,0,1},
			{30104,1,1,1,1,1,1,0,0,0,0,2},
			{30104,1,1,1,1,1,1,0,0,0,0,3},
			{30104,1,1,1,1,1,1,0,0,0,0,4},
			{30104,0,0,0,0,0,0,0,0,0,0,5},
			{10510,1,1,2,2,1,1,0,0,0,0,1},
			{10510,1,1,1,1,1,1,0,0,0,0,2},
			{10510,1,1,1,1,1,1,0,0,0,0,3},
			{10510,1,1,1,1,1,1,0,0,0,0,4},
			{10510,0,0,0,0,0,0,0,0,0,0,5},
			{40101,1,1,1,1,1,1,0,0,1,1,1},
			{40101,1,1,1,1,1,1,1,1,1,1,2},
			{40101,1,1,1,1,1,1,1,1,1,1,3},
			{40101,0,0,1,1,1,1,1,0,1,1,4},
			{40101,1,1,1,1,1,1,1,1,0,0,5},
			{40102,1,1,1,1,1,1,0,0,1,1,1},
			{40102,1,1,1,1,1,1,1,0,1,1,2},
			{40102,0,0,1,1,1,1,0,0,0,0,3},
			{40102,1,1,1,1,1,1,1,1,1,1,4},
			{40102,2,2,1,1,0,0,1,1,0,0,5},
			{40201,0,0,1,1,1,1,1,1,1,1,1},
			{40201,1,1,0,0,1,1,1,1,1,1,2},
			{40201,1,1,1,1,0,0,1,1,0,0,3},
			{40201,0,1,1,1,1,1,1,0,1,1,4},
			{40201,1,1,0,0,0,0,1,1,0,0,5},
			{40202,0,0,1,1,1,1,1,1,0,0,1},
			{40202,2,2,1,1,0,0,1,1,1,1,2},
			{40202,0,0,1,1,0,0,1,1,0,0,3},
			{40202,0,0,1,1,0,0,1,1,1,1,4},
			{40202,1,1,1,1,1,1,1,0,0,1,5},
			{30101,1,1,0,0,0,0,0,0,0,0,1},
			{30101,1,1,1,1,1,1,0,0,0,0,2},
			{30101,1,1,1,1,1,1,0,0,0,0,3},
			{30101,1,1,1,1,1,1,0,0,0,0,4},
			{30101,1,1,1,1,2,2,0,0,0,0,5},
			{30103,0,0,0,0,0,0,0,0,0,0,1},
			{30103,1,1,1,1,1,1,0,0,0,0,2},
			{30103,1,1,1,1,1,1,1,1,0,0,3},
			{30103,0,0,1,1,1,1,0,0,0,0,4},
			{30103,1,1,1,1,0,0,0,0,0,0,5},
			{30105,1,1,1,1,1,1,0,0,0,0,1},
			{30105,0,0,1,1,1,1,1,0,0,0,2},
			{30105,1,1,1,1,1,1,0,0,0,0,3},
			{30105,1,1,1,1,1,1,0,0,0,0,4},
			{30105,1,1,1,1,0,0,0,0,0,0,5},
			{30107,1,1,1,1,1,1,0,0,0,0,1},
			{30107,0,0,3,3,1,1,0,0,0,0,2},
			{30107,1,1,1,1,1,1,0,0,0,0,3},
			{30107,1,1,1,1,0,0,0,0,0,0,4},
			{30107,1,1,1,1,0,0,0,0,0,0,5},
			{30109,1,1,1,1,1,1,0,0,0,0,1},
			{30109,0,0,1,1,1,1,1,1,0,0,2},
			{30109,1,1,1,1,1,1,0,0,0,0,3},
			{30109,1,1,1,1,0,0,0,0,0,0,4},
			{30109,1,1,1,1,0,0,0,0,0,0,5},
			{30111,0,0,0,0,1,1,0,0,0,0,1},
			{30111,0,0,1,1,1,1,0,0,0,0,2},
			{30111,0,0,1,1,1,1,0,0,0,0,3},
			{30111,1,1,1,1,1,1,0,0,0,0,4},
			{30111,0,0,2,2,0,0,0,0,0,0,5},
			{30112,1,1,1,1,1,1,0,0,0,0,1},
			{30112,0,0,1,1,3,3,0,0,0,0,2},
			{30112,1,1,1,1,1,1,0,0,0,0,3},
			{30112,1,1,1,1,1,1,0,0,0,0,4},
			{30112,2,2,1,1,0,0,0,0,0,0,5},
			{30113,1,1,0,0,1,1,1,1,0,0,1},
			{30113,1,1,1,1,1,1,0,0,0,0,2},
			{30113,1,1,1,1,1,1,0,0,0,0,3},
			{30113,1,1,0,0,1,1,1,1,0,0,4},
			{30113,1,1,0,0,0,0,0,0,0,0,5},
			{30114,1,1,0,0,0,0,0,0,0,0,1},
			{30114,0,0,0,0,1,1,0,0,0,0,2},
			{30114,0,0,0,0,1,1,0,0,0,0,3},
			{30114,1,1,3,3,3,3,0,0,0,0,4},
			{30114,0,0,1,1,1,1,0,0,0,0,5},
			{30116,0,0,1,1,0,0,0,0,0,0,1},
			{30116,1,1,0,0,0,0,0,0,0,0,2},
			{30116,1,1,1,1,1,1,0,0,0,0,3},
			{30116,3,3,0,0,1,1,0,0,0,0,4},
			{30116,0,0,1,1,3,3,0,0,0,0,5},
			{30202,1,1,3,3,1,1,1,0,0,0,1},
			{30202,0,0,2,2,1,1,0,0,0,0,2},
			{30202,1,1,1,1,1,1,2,2,0,0,3},
			{30202,0,0,1,1,1,1,1,0,0,0,4},
			{30202,1,1,1,1,1,1,1,0,0,0,5},
			{30204,1,1,1,1,1,1,0,0,0,0,1},
			{30204,0,0,1,1,1,1,1,0,0,0,2},
			{30204,1,1,0,0,1,1,0,0,2,2,3},
			{30204,0,0,2,2,1,1,1,0,0,0,4},
			{30204,1,1,3,3,1,1,1,0,0,0,5},
			{30206,1,1,1,1,1,1,0,0,0,0,1},
			{30206,1,1,1,1,1,1,1,0,0,0,2},
			{30206,2,2,1,1,1,1,1,1,0,0,3},
			{30206,1,1,1,1,1,1,1,0,0,0,4},
			{30206,1,1,1,1,1,1,1,0,0,0,5},
			{30209,1,1,1,1,1,1,1,0,0,0,1},
			{30209,1,1,1,1,1,1,0,0,0,0,2},
			{30209,1,1,1,1,1,1,1,1,0,0,3},
			{30209,1,1,1,1,1,1,0,0,0,0,4},
			{30209,1,1,1,1,1,1,1,0,0,0,5},
			{30210,1,1,1,1,1,1,0,0,0,0,1},
			{30210,1,1,1,1,1,1,0,0,0,0,2},
			{30210,1,1,1,1,1,1,0,0,0,0,3},
			{30210,1,1,1,1,1,1,0,0,0,0,4},
			{30210,1,1,1,1,1,1,1,0,0,0,5},
			{30211,0,1,1,1,1,1,1,0,0,0,1},
			{30211,1,1,1,1,1,1,0,0,0,0,2},
			{30211,0,0,1,1,1,1,1,0,0,0,3},
			{30211,1,1,1,1,1,1,2,2,1,1,4},
			{30211,1,1,1,1,1,1,1,0,0,0,5},
			{30212,1,1,1,1,1,1,0,0,0,0,1},
			{30212,1,1,1,1,1,1,0,0,0,0,2},
			{30212,3,3,1,1,1,1,2,2,0,0,3},
			{30212,1,1,1,1,1,1,0,0,0,0,4},
			{30212,1,1,1,1,1,1,0,0,0,0,5},
			{30213,1,1,1,1,1,1,1,1,0,0,1},
			{30213,1,1,1,1,1,1,0,0,0,0,2},
			{30213,1,1,1,1,1,1,1,1,0,0,3},
			{30213,1,1,1,1,1,1,1,0,0,0,4},
			{30213,3,3,1,1,1,1,1,0,0,0,5},
			{30214,1,1,1,1,1,1,1,0,0,0,1},
			{30214,1,1,1,1,1,1,0,0,0,0,2},
			{30214,1,1,1,1,1,1,1,1,0,0,3},
			{30214,1,1,1,1,1,1,1,1,0,0,4},
			{30214,1,1,1,1,1,1,1,1,0,0,5},
			{30217,1,1,1,1,1,1,1,0,1,1,1},
			{30217,1,1,0,0,1,1,1,1,1,1,2},
			{30217,1,1,1,1,1,1,1,1,1,1,3},
			{30217,2,2,1,1,1,1,0,0,0,0,4},
			{30217,2,2,1,1,1,1,0,0,0,0,5},
			{30218,1,1,1,1,1,1,0,0,0,0,1},
			{30218,1,1,1,1,1,1,1,1,1,1,2},
			{30218,1,1,1,1,1,1,1,0,0,0,3},
			{30218,1,1,1,1,1,1,1,1,0,0,4},
			{30218,3,3,1,1,1,1,0,0,0,0,5},
			{30219,1,1,0,0,1,1,0,0,0,0,1},
			{30219,3,3,1,1,1,1,0,0,0,0,2},
			{30219,1,1,1,1,1,1,1,0,0,0,3},
			{30219,1,1,0,0,1,1,0,0,0,0,4},
			{30219,0,1,1,1,1,1,1,0,0,0,5},
			{30221,1,1,1,1,1,1,0,0,0,0,1},
			{30221,1,1,1,1,1,1,0,0,0,0,2},
			{30221,1,1,1,1,1,1,0,0,0,0,3},
			{30221,1,1,1,1,1,0,1,1,0,0,4},
			{30221,3,3,0,0,1,1,0,0,0,0,5},
			{30223,1,1,1,1,1,1,1,1,1,1,1},
			{30223,0,0,1,1,1,1,0,0,0,0,2},
			{30223,1,1,1,1,1,1,1,1,1,1,3},
			{30223,1,1,1,1,1,1,0,0,0,0,4},
			{30223,1,1,1,1,1,1,0,0,0,0,5},
			{30302,1,1,1,1,1,1,0,0,0,0,1},
			{30302,0,0,1,1,1,1,0,0,0,0,2},
			{30302,1,1,1,1,1,1,1,0,0,0,3},
			{30302,1,1,1,1,1,1,1,0,0,0,4},
			{30302,2,2,1,1,1,1,1,0,0,0,5},
			{30304,0,1,1,1,1,1,0,0,0,0,1},
			{30304,1,1,1,1,1,1,0,0,0,0,2},
			{30304,1,1,1,1,0,0,1,1,0,0,3},
			{30304,3,3,0,0,1,1,1,0,0,0,4},
			{30304,2,2,1,1,0,0,1,1,0,0,5},
			{30306,1,1,1,1,1,1,0,0,0,0,1},
			{30306,1,1,1,1,1,1,1,0,0,0,2},
			{30306,1,0,1,1,1,1,0,0,0,0,3},
			{30306,1,1,0,1,0,0,0,0,0,0,4},
			{30306,1,1,1,1,1,1,1,0,0,0,5},
			{30310,1,1,1,1,1,1,0,0,0,0,1},
			{30310,0,0,1,1,1,1,1,1,0,0,2},
			{30310,1,1,1,1,1,1,1,0,0,0,3},
			{30310,1,1,1,1,1,1,0,0,0,0,4},
			{30310,1,1,1,1,0,0,0,0,0,0,5},
			{30311,1,1,1,1,1,1,0,0,0,0,1},
			{30311,1,1,1,1,1,1,0,0,0,0,2},
			{30311,1,1,1,1,1,1,0,0,0,0,3},
			{30311,2,2,1,1,1,1,0,0,0,0,4},
			{30311,1,1,1,1,1,1,0,0,0,0,5},
			{30312,0,0,1,1,1,1,0,0,0,0,1},
			{30312,1,1,1,1,1,1,1,0,0,0,2},
			{30312,1,1,0,0,1,1,0,0,0,0,3},
			{30312,0,0,1,1,1,1,1,1,0,0,4},
			{30312,1,1,1,1,1,1,0,0,0,0,5},
			{30314,1,1,1,1,1,1,0,0,0,0,1},
			{30314,1,1,1,1,1,1,0,0,0,0,2},
			{30314,3,3,0,0,1,1,0,0,0,0,3},
			{30314,1,1,1,1,1,1,0,0,0,0,4},
			{30314,0,1,1,1,1,1,0,0,0,0,5},
			{30315,1,1,1,1,1,1,0,0,0,0,1},
			{30315,1,1,1,1,1,1,1,1,0,0,2},
			{30315,0,0,1,1,1,1,1,0,0,0,3},
			{30315,2,2,3,3,1,1,1,1,1,1,4},
			{30315,1,1,1,1,1,1,1,0,0,0,5},
			{30317,1,1,1,1,1,1,1,0,0,0,1},
			{30317,1,1,1,1,1,1,1,0,0,0,2},
			{30317,1,1,1,1,1,1,0,0,0,0,3},
			{30317,3,3,0,0,1,1,0,0,0,0,4},
			{30317,3,3,2,2,1,1,1,0,0,0,5},
			{30321,1,1,1,1,1,1,0,0,0,0,1},
			{30321,1,1,1,1,1,1,0,0,0,0,2},
			{30321,3,3,1,1,1,1,0,0,0,0,3},
			{30321,3,3,1,1,1,1,0,0,0,0,4},
			{30321,1,1,1,1,1,1,0,0,0,0,5},
			{30323,1,1,1,1,1,1,0,0,0,0,1},
			{30323,1,1,1,1,1,1,0,0,0,0,2},
			{30323,1,1,1,1,1,1,1,0,0,0,3},
			{30323,3,3,1,1,1,1,0,1,0,0,4},
			{30323,1,1,1,1,3,3,0,0,0,0,5},
			{30325,1,1,1,1,1,1,0,0,0,0,1},
			{30325,1,1,1,1,1,1,0,0,0,0,2},
			{30325,1,1,1,1,1,1,0,0,0,0,3},
			{30325,3,3,1,1,1,1,0,1,0,0,4},
			{30325,1,1,1,1,1,1,0,0,0,0,5},
			{30327,0,0,0,0,0,0,0,0,0,0,1},
			{30327,0,0,0,0,0,0,0,0,0,0,2},
			{30327,0,0,0,0,0,0,0,0,0,0,3},
			{30327,0,0,0,0,0,0,0,0,0,0,4},
			{30327,0,0,0,0,0,0,0,0,0,0,5},
			{30401,1,1,1,1,0,0,1,1,1,1,1},
			{30401,1,1,1,1,1,1,1,1,0,0,2},
			{30401,0,0,1,1,1,1,1,1,1,1,3},
			{30401,1,1,1,1,1,1,0,0,0,0,4},
			{30401,0,0,0,0,0,0,0,0,0,0,5},
			{30402,1,1,1,1,1,1,1,1,1,1,1},
			{30402,1,1,1,1,1,1,1,1,1,1,2},
			{30402,1,1,1,1,1,1,1,1,1,1,3},
			{30402,1,1,1,1,1,1,1,1,1,1,4},
			{30402,1,1,1,1,1,1,1,1,1,1,5},
			{30403,0,0,1,1,1,1,0,0,0,0,1},
			{30403,1,1,1,1,1,1,0,0,0,0,2},
			{30403,1,1,1,1,1,1,0,0,0,0,3},
			{30403,1,1,1,1,1,1,0,0,0,0,4},
			{30403,0,0,1,1,1,1,0,0,0,0,5},
			{30404,0,0,1,1,1,1,1,0,0,0,1},
			{30404,0,0,1,1,1,1,1,0,0,0,2},
			{30404,2,2,0,0,1,1,1,0,0,0,3},
			{30404,2,2,1,1,1,1,0,0,0,0,4},
			{30404,0,0,1,1,1,1,1,0,0,0,5},
			{30406,1,1,1,1,1,1,1,1,1,1,1},
			{30406,1,1,1,1,1,1,1,0,0,0,2},
			{30406,1,1,2,2,1,1,0,0,0,0,3},
			{30406,1,1,1,1,1,1,1,0,0,0,4},
			{30406,1,1,1,1,1,0,0,0,0,0,5},
			{30407,1,1,1,1,1,1,1,1,1,1,1},
			{30407,1,1,1,1,1,1,0,0,0,0,2},
			{30407,1,1,1,1,1,1,0,0,0,0,3},
			{30407,1,1,1,1,1,1,1,1,1,1,4},
			{30407,1,1,1,1,1,1,0,0,0,0,5},
			{30408,1,1,1,1,0,0,0,0,0,0,1},
			{30408,1,1,1,1,1,1,0,0,0,0,2},
			{30408,0,0,1,1,1,1,0,0,0,0,3},
			{30408,1,1,1,1,1,1,0,0,0,0,4},
			{30408,0,0,2,2,1,1,0,0,0,0,5},
			{30409,1,1,1,1,1,1,1,1,1,1,1},
			{30409,1,1,1,1,1,1,0,0,0,0,2},
			{30409,1,1,1,1,1,1,0,0,0,0,3},
			{30409,1,1,1,1,1,1,1,1,1,1,4},
			{30409,1,1,1,1,1,1,0,0,0,0,5},
			{30411,1,1,1,1,1,1,1,1,1,1,1},
			{30411,1,1,1,1,1,1,0,0,0,0,2},
			{30411,1,1,1,1,1,1,0,0,0,0,3},
			{30411,1,1,1,1,1,1,1,1,1,1,4},
			{30411,1,1,1,1,0,0,0,0,0,0,5},
			{30412,0,0,0,0,1,1,0,0,0,0,1},
			{30412,1,1,1,1,1,1,0,0,0,0,2},
			{30412,0,0,1,1,1,1,1,1,0,0,3},
			{30412,1,1,1,1,1,1,1,1,0,0,4},
			{30412,0,0,1,1,1,1,1,0,0,0,5},
			{30413,2,2,1,1,1,1,1,1,1,1,1},
			{30413,1,1,1,1,1,1,0,0,0,0,2},
			{30413,1,1,1,1,1,1,0,0,0,0,3},
			{30413,1,1,1,1,1,1,1,1,1,1,4},
			{30413,1,1,1,1,1,1,0,0,0,0,5},
			{30414,0,0,1,1,1,1,1,0,0,0,1},
			{30414,1,1,1,1,1,1,0,0,0,0,2},
			{30414,0,1,1,1,1,1,0,0,0,0,3},
			{30414,1,1,1,1,1,1,1,0,0,0,4},
			{30414,1,1,1,1,1,1,1,0,0,0,5},
			{30416,0,0,1,1,1,1,0,0,1,1,1},
			{30416,1,1,1,1,1,1,0,0,0,0,2},
			{30416,1,1,1,1,1,1,0,0,0,0,3},
			{30416,1,1,1,1,0,0,0,0,1,1,4},
			{30416,1,1,1,1,1,1,0,0,0,0,5},
			{30117,1,1,1,1,1,1,1,0,0,0,1},
			{30117,1,1,1,1,1,1,1,1,0,0,2},
			{30117,1,1,2,2,1,1,1,1,0,0,3},
			{30117,1,1,1,1,1,1,0,0,0,0,4},
			{30117,1,1,1,1,1,1,1,0,0,0,5},
			{30118,1,1,1,1,1,1,0,0,0,0,1},
			{30118,1,1,1,1,1,1,1,1,0,0,2},
			{30118,0,0,1,1,2,2,1,1,0,0,3},
			{30118,2,2,2,2,1,1,0,0,0,0,4},
			{30118,0,0,1,1,1,1,1,0,0,0,5},
			{30119,0,0,1,1,1,1,1,0,0,0,1},
			{30119,0,0,1,1,0,0,1,1,0,0,2},
			{30119,1,1,0,0,1,1,0,0,0,0,3},
			{30119,0,0,0,0,1,1,1,1,0,0,4},
			{30119,3,3,1,1,0,0,0,0,0,0,5},
			{30120,0,0,1,1,1,1,1,0,0,0,1},
			{30120,0,0,1,1,0,0,1,1,0,0,2},
			{30120,1,1,1,1,1,1,1,0,0,0,3},
			{30120,0,0,3,3,1,1,0,0,0,0,4},
			{30120,0,0,1,1,1,1,1,0,0,0,5},
			{30220,1,1,3,3,1,1,1,0,0,0,1},
			{30220,0,0,2,2,1,1,0,0,0,0,2},
			{30220,1,1,1,1,1,1,2,2,0,0,3},
			{30220,0,0,1,1,1,1,1,0,0,0,4},
			{30220,1,1,1,1,1,1,1,0,0,0,5},
			{30222,1,1,1,1,1,1,0,0,0,0,1},
			{30222,0,0,1,1,1,1,1,0,0,0,2},
			{30222,1,1,0,0,1,1,0,0,2,2,3},
			{30222,0,0,2,2,1,1,1,0,0,0,4},
			{30222,1,1,3,3,1,1,1,0,0,0,5},
			{30224,1,1,1,1,1,1,0,0,0,0,1},
			{30224,1,1,1,1,1,1,1,0,0,0,2},
			{30224,2,2,1,1,1,1,1,1,0,0,3},
			{30224,1,1,1,1,1,1,1,0,0,0,4},
			{30224,1,1,1,1,1,1,1,0,0,0,5},
			{30226,0,0,0,0,0,0,1,1,0,0,1},
			{30226,1,1,1,1,0,0,1,1,1,1,2},
			{30226,1,1,1,1,1,1,0,0,0,0,3},
			{30226,1,1,0,0,1,1,1,0,0,0,4},
			{30226,1,1,1,1,1,1,0,0,0,0,5},
			{50101,0,0,0,0,0,0,0,0,0,0,1},
			{50101,0,0,0,0,0,0,0,0,0,0,2},
			{50101,0,0,0,0,0,0,0,0,0,0,3},
			{50101,0,0,0,0,0,0,0,0,0,0,4},
			{50101,0,0,0,0,0,0,0,0,0,0,5},
			{50102,0,0,0,0,0,0,0,0,0,0,1},
			{50102,1,1,1,1,0,0,0,0,0,0,2},
			{50102,0,0,0,0,0,0,0,0,0,0,3},
			{50102,1,1,1,1,0,0,0,0,0,0,4},
			{50102,0,0,0,0,0,0,0,0,0,0,5},
			{50201,0,0,0,0,0,0,0,0,0,0,1},
			{50201,1,1,1,1,0,0,0,0,0,0,2},
			{50201,0,0,0,0,0,0,0,0,0,0,3},
			{50201,0,0,0,0,0,0,0,0,0,0,4},
			{50201,0,0,0,0,0,0,0,0,0,0,5},
			{50202,1,1,1,0,0,0,0,0,0,0,1},
			{50202,1,1,1,1,1,1,0,0,0,0,2},
			{50202,1,1,1,1,0,0,0,0,0,0,3},
			{50202,0,0,1,1,0,0,0,0,0,0,4},
			{50202,1,1,1,1,1,1,0,0,0,0,5},
			{50203,0,0,1,1,0,0,0,0,0,0,1},
			{50203,1,1,1,1,1,1,0,0,0,0,2},
			{50203,1,1,1,1,1,1,0,0,0,0,3},
			{50203,1,1,1,1,0,0,0,0,0,0,4},
			{50203,1,1,1,1,1,1,0,0,0,0,5},
			{50204,1,1,1,1,0,0,0,0,0,0,1},
			{50204,1,1,1,1,1,1,0,0,0,0,2},
			{50204,0,0,0,0,0,0,0,0,0,0,3},
			{50204,1,1,1,1,0,0,0,0,0,0,4},
			{50204,0,0,1,1,0,0,0,0,0,0,5},
			{50205,1,1,1,1,0,0,0,0,0,0,1},
			{50205,1,1,1,1,1,1,1,0,0,0,2},
			{50205,1,1,1,1,1,1,0,0,0,0,3},
			{50205,1,1,1,1,0,0,0,0,0,0,4},
			{50205,0,0,1,1,0,0,0,0,0,0,5},
			{50206,1,1,1,1,1,1,0,0,0,0,1},
			{50206,0,0,1,1,1,1,1,0,0,0,2},
			{50206,1,1,1,1,1,1,0,0,0,0,3},
			{50206,1,1,1,1,1,1,1,0,0,0,4},
			{50206,1,1,1,1,1,1,0,0,0,0,5},
			{50207,0,0,1,1,0,0,0,0,0,0,1},
			{50207,1,1,1,1,0,0,0,0,0,0,2},
			{50207,0,0,0,0,0,0,0,0,0,0,3},
			{50207,0,0,1,1,0,0,1,1,0,0,4},
			{50207,0,0,1,1,1,1,0,0,0,0,5},
			{50208,2,2,1,1,0,0,0,0,0,0,1},
			{50208,0,0,1,1,1,1,0,0,0,0,2},
			{50208,0,0,1,1,1,1,1,0,0,0,3},
			{50208,0,0,0,0,3,3,0,0,0,0,4},
			{50208,0,0,0,0,1,1,1,0,0,0,5},
			{60001,0,0,0,0,0,0,0,0,0,0,1},
			{60001,1,1,0,0,0,0,0,0,0,0,2},
			{60001,1,1,0,0,0,0,0,0,0,0,3},
			{60001,0,0,0,0,0,0,0,0,0,0,4},
			{60001,0,1,1,1,1,0,0,0,0,0,5},
			{60002,1,1,1,1,1,1,1,0,0,0,1},
			{60002,1,1,1,1,0,0,1,1,0,0,2},
			{60002,3,3,0,0,1,1,1,0,0,0,3},
			{60002,0,0,1,1,1,1,1,0,0,0,4},
			{60002,1,1,1,1,0,0,0,0,0,0,5},
			{60003,1,1,1,1,1,1,1,0,0,0,1},
			{60003,1,1,1,1,1,1,0,0,0,0,2},
			{60003,1,1,1,1,1,0,0,0,0,0,3},
			{60003,1,1,1,1,1,1,1,0,0,0,4},
			{60003,1,1,1,1,0,0,0,0,0,0,5},
			{60004,2,2,1,1,1,1,0,0,0,0,1},
			{60004,0,0,1,1,1,1,1,0,0,0,2},
			{60004,0,0,3,3,0,0,2,2,0,0,3},
			{60004,2,2,1,1,1,1,1,0,0,0,4},
			{60004,1,1,1,1,1,1,1,0,0,0,5},
			{60005,1,1,1,1,1,1,1,0,0,0,1},
			{60005,1,1,1,1,1,1,1,0,0,0,2},
			{60005,0,0,1,1,1,1,0,0,0,0,3},
			{60005,3,3,1,1,1,1,0,0,1,1,4},
			{60005,1,1,0,0,1,1,0,0,0,0,5},
			{60006,1,1,1,1,1,1,0,0,0,0,1},
			{60006,1,1,0,0,1,1,0,0,0,0,2},
			{60006,1,1,0,0,1,1,1,0,0,0,3},
			{60006,0,0,1,1,1,1,1,0,0,0,4},
			{60006,0,0,0,0,1,1,1,0,0,0,5},
			{60007,1,1,1,1,1,1,0,0,0,0,1},
			{60007,1,1,1,1,1,1,1,0,0,0,2},
			{60007,1,1,1,1,1,1,1,0,0,0,3},
			{60007,1,1,1,1,1,1,1,0,0,0,4},
			{60007,1,1,1,1,1,1,1,0,0,0,5},
			{60008,1,1,1,1,1,1,1,0,0,0,1},
			{60008,1,1,1,1,1,1,0,0,1,1,2},
			{60008,1,1,1,1,0,0,1,1,0,0,3},
			{60008,1,1,1,1,1,1,1,0,0,0,4},
			{60008,0,0,1,1,1,1,1,0,0,0,5},
			{60009,0,0,1,1,1,1,1,1,0,0,1},
			{60009,1,1,0,0,1,1,1,0,0,0,2},
			{60009,1,1,1,1,1,1,1,0,0,0,3},
			{60009,0,1,1,1,0,0,0,0,0,0,4},
			{60009,1,1,0,0,1,1,0,0,0,0,5},
			{60010,1,1,1,1,0,0,0,0,0,0,1},
			{60010,0,0,0,0,1,1,0,0,0,0,2},
			{60010,1,1,0,0,1,1,1,0,0,0,3},
			{60010,2,2,0,0,0,0,0,0,0,0,4},
			{60010,1,1,0,0,0,0,0,0,0,0,5}
		};
}