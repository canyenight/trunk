/*
 * �������� 2006-4-30
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package cn.edu.nju.shirui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Othello extends JFrame
{
    public Othello()
    {
        OthelloTable drawPane = new OthelloTable(getBackground());
        Container pane = getContentPane();
        pane.add(drawPane, BorderLayout.CENTER);
        setSize(600, 580);
        //f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //f.setUndecorated(true);
        //f.setAlwaysOnTop(true);
        //f.setLocationByPlatform(true);

        setLocation(208, 104);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBackground(Color.PINK);
        setResizable(false);
        setVisible(true);        
    }
    
    public static void main(String[] args) 
    {
        new Othello();
    }
}
