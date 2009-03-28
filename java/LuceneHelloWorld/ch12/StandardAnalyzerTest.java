package ch12;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

public class StandardAnalyzerTest 
{

	//���캯����
	public StandardAnalyzerTest()
	{
	}
	
	public static void main(String[] args) 
	{
		//����һ��StandardAnalyzer����
		Analyzer aAnalyzer = new StandardAnalyzer();
		//�����ַ���
		StringReader sr = new StringReader("People are always talking about 'the problem of youth'.");

		//����TokenStream����
		TokenStream ts = aAnalyzer.tokenStream(sr);
		
		try {
			int i=0;
			Token t = ts.next();
			while(t!=null)
			{
				//�������ʱ��ʾ�к�
				i++;
				//����������ַ�
				System.out.println("Line"+i+":"+t.termText());
				//ȡ����һ���ַ�
				t=ts.next();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
