package ch13;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.search.CachingWrapperFilter;
import org.apache.lucene.search.MockFilter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;

public class CachingWrapperFilterTest  
{

	public static void main(String[] args) throws IOException 
	{
		//��������Ŀ¼
		Directory dir = new RAMDirectory();
		//������д��
	    IndexWriter writer;
		try 
		{
			//
			writer = new IndexWriter(dir, new StandardAnalyzer(), true);
			//�ر�
			writer.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	    
		//�����Ķ���
	    IndexReader reader = IndexReader.open(dir);
	    
	    //
	    MockFilter filter = new MockFilter();
	    CachingWrapperFilter cacher = new CachingWrapperFilter(filter);
	    
	    //
	    cacher.bits(reader);
	    System.out.println("The first time the Filter was called? "+filter.wasCalled());

	    //��չ�����
	    filter.clear();
	    cacher.bits(reader);
	    System.out.println("The first time the Filter was called? "+filter.wasCalled());
	}
}
