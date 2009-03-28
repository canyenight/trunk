/*
 * �������� 2006-5-23
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
import java.awt.*;
import javax.swing.*;
//import javax.sound.*;

public class MonitorWindows extends JFrame
{
    private static final  long serialVersionUID = 1L;
    
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 600;
    
    private JTextArea reportArea;
    private JButton socketSetButton;
    private JScrollPane scrollPane;
    private JPanel buttonPanel;
    
    public static void main(String[] args)
    {
        // TODO �Զ����ɷ������
        MonitorWindows frame = new MonitorWindows();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    
    public MonitorWindows()
    {
        setTitle("AntiHunter Monitor Center");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        
        Container contentPane = getContentPane();
        buttonPanel = new JPanel();
        socketSetButton = new JButton("Socket Setup");
        buttonPanel.add(socketSetButton);
        contentPane.add(buttonPanel,BorderLayout.SOUTH);
        
        reportArea = new JTextArea();
        scrollPane = new JScrollPane(reportArea);
        
        contentPane.add(scrollPane, BorderLayout.CENTER);
    }
    

}
