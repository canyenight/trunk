/*
 * �������� 2006-2-16
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package testMySQL;

import java.sql.*;

/**
 * @author shirui
 *
 * TODO Ҫ���Ĵ����ɵ�����ע�͵�ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
public class TestMySQL 
{
    public static void main(String args[])
    {
        System.out.println("Hello Java!");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Success loading MySQL Driver...");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mycap","root","nju");
            System.out.println("Success entering MySQL...");
            Statement st = con.createStatement();
            System.out.println( "����Statement�ɹ�!" );

            ResultSet rs = st.executeQuery("select * from customers;");
            System.out.println( "�������ݱ�ɹ�!" );
            System.out.println( "--------------------------------------" );
            
//          System.out.println(rs.getS)

            while(rs.next())
            {
                System.out.print(rs.getString("cid") + "    ");
                System.out.print(rs.getString("cname") + "    ");
                System.out.print(rs.getString("city") + "    ");
                System.out.println(rs.getString("discnt") + "    ");
            }
            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("Error MySQL Driver...");
            e.printStackTrace();
        }
     
    }

}
