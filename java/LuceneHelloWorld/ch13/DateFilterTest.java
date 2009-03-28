package ch13;
import java.io.IOException;

import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.document.DateField;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.DateFilter;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.RAMDirectory;

public class DateFilterTest  
{

	public static void main(String[] args) throws IOException
	{
		//	����һ������
        RAMDirectory indexStore = new RAMDirectory();
		//����������д��
        IndexWriter writer = new IndexWriter(indexStore, new SimpleAnalyzer(), true);
			//ȡ��ϵͳ��ǰʱ��
        long now = System.currentTimeMillis();
		//����һ��Document����
        Document doc = new Document();
        // ��ӹ�ȥ��һ��ʱ��
        doc.add(Field.Keyword("datefield", DateField.timeToString(now - 1000)));
		//���Ҫ����������
        doc.add(Field.Text("body", "Today is a very sunny day in New York City"));
        
	  	try
	  	{
			//���ı���������
			writer.addDocument(doc);
			//�Ż�����
			writer.optimize();
			//�ر�
			writer.close();
		} catch (IOException e1) 
			{
				e1.printStackTrace();
			}
 		//����������
		IndexSearcher searcher = new IndexSearcher(indexStore);
	
		//����Ӧ���ڼ�������б���������
		DateFilter df1 = DateFilter.Before("datefield", now);

		//���˲�Ӧ���ڼ�������г��ֵ�
		DateFilter df2 = DateFilter.Before("datefield", now - 999999);
	
		// û��ʹ�ù������ļ���
		Query query1 = new TermQuery(new Term("body", "NoMatchForThis"));
	
		// ���������ڵ�����
		Query query2 = new TermQuery(new Term("body", "sunny"));
		//���ɱ����������Ķ���
		Hits result;

			try 
		{
		//ʹ��query1,���ؼ������
			result = searcher.search(query1);
		
		System.out.println("There is "+result.length()+"Document(s) matched!");
		} catch (IOException e) 
			{
				e.printStackTrace();
			}
		
	}
}
