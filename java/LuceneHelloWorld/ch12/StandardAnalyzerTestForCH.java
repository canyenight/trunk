package ch12;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

public class StandardAnalyzerTestForCH {

		// ���캯��
	public StandardAnalyzerTestForCH ()
	{
	}
	
	public static void main(String[] args) 
	{
		// ��ʼ��һ��StandardAnalyzer����
		Analyzer a = new StandardAnalyzer();
		// �����ַ���
		StringReader  sr = new StringReader("����ʯ��λ��ɽ��ʡ��ͬ�����������ҹ��Ŵ������Ĺ屦��");
		// ��ȡ��������
		TokenStream ts = a.tokenStream(sr);
		
		try {
			int i=0;
			// ȡ����һ���зֺõĴ�
			Token t = ts.next();
			while(t!=null)
			{
				i++;
				// ��ӡ
				System.out.println("Line"+i+":"+t.termText());
				// ������ȡ
				t=ts.next();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
