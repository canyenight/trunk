package ch13;
import java.io.IOException;
import java.util.BitSet;

import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Filter;
import org.apache.lucene.search.FilteredQuery;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.RAMDirectory;

public class FilterQueryTest  
{

	public static void main(String[] args) throws IOException 
	{
		//��������Ŀ¼
		RAMDirectory directory = new RAMDirectory();
	    IndexWriter writer = new IndexWriter (directory, new WhitespaceAnalyzer(), true);
		
	    //����Document����
	    Document doc = new Document();
	    //������������ӵ�Document������
	    doc.add (Field.Text ("field", "one two three four five"));
	    doc.add (Field.Text ("sorter", "b"));
		//���ĵ���ӽ�����
	    writer.addDocument (doc);
		
	    //����Document����
	    doc = new Document();
		//������������ӵ�Document������
	    doc.add (Field.Text ("field", "one two three four"));
	    doc.add (Field.Text ("sorter", "d"));
		//���ĵ���ӽ�����
	    writer.addDocument (doc);

	    ////����Document����
	    doc = new Document();
		//������������ӵ�Document������
	    doc.add (Field.Text ("field", "one two three y"));
	    doc.add (Field.Text ("sorter", "a"));
		//���ĵ���ӽ�����
	    writer.addDocument (doc);
		
	    //����Document����
	    doc = new Document();
		//������������ӵ�Document������
	    doc.add (Field.Text ("field", "one two x"));
	    doc.add (Field.Text ("sorter", "c"));
		//���ĵ���ӽ�����
	    writer.addDocument (doc);
	    
	    //�Ż�����
	    writer.optimize ();
		//�ر�����
	    writer.close ();

	    //����IndexSearcher����
	    IndexSearcher searcher = new IndexSearcher (directory);
		//���ɲ�ѯ����
	    Query query = new TermQuery (new Term ("field", "three"));
		
	    //����������
	    Filter filter = new Filter() 
	    {
	      public BitSet bits (IndexReader reader) throws IOException 
	      {
	        BitSet bitset = new BitSet(5);
	        bitset.set (1);
	        bitset.set (3);
	        return bitset;
	      }
	    };
	    
	    //���ɴ��й������Ĳ�ѯ����
	    Query filteredquery = new FilteredQuery (query, filter);
		//���ؼ������
	    Hits hits = searcher.search (filteredquery);
	    System.out.println("There is "+hits.length()+" Document(s) matched!");
	    
	    //���ؼ������
	    hits = searcher.search (filteredquery, new Sort("sorter"));
	    System.out.println("There is "+hits.length()+" Document(s) matched!");
	    
	    //���ɴ��й������Ĳ�ѯ����
	    filteredquery = new FilteredQuery (new TermQuery (new Term ("field", "one")), filter);
		//���ؼ������
	    hits = searcher.search (filteredquery);
	    System.out.println("There is "+hits.length()+" Document(s) matched!");
	    
	    //���ɴ��й������Ĳ�ѯ����
	    filteredquery = new FilteredQuery (new TermQuery (new Term ("field", "x")), filter);
		//���ؼ������
	    hits = searcher.search (filteredquery);
	    System.out.println("There is "+hits.length()+" Document(s) matched!");
	    
	    //���ɴ��й������Ĳ�ѯ����
	    filteredquery = new FilteredQuery (new TermQuery (new Term ("field", "y")), filter);
		//���ؼ������
	    hits = searcher.search (filteredquery);
	    System.out.println("There is "+hits.length()+" Document(s) matched!");
	    
	}
}
