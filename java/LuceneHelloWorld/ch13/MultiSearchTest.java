package ch13;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MultiSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
public class MultiSearchTest  
{
	public static void main(String[] args) throws IOException, ParseException 
	{
		Directory indexStoreA = new RAMDirectory();
        Directory indexStoreB = new RAMDirectory();

        // ����һ���ĵ�
        Document lDoc = new Document();
        lDoc.add(Field.Text("fulltext", "Once upon a time....."));
        lDoc.add(Field.Keyword("id", "doc1"));
        lDoc.add(Field.Keyword("handle", "1"));

        // ����һ���洢�ĵ�
        Document lDoc2 = new Document();
        lDoc2.add(Field.Text("fulltext", "in a galaxy far far away....."));
        lDoc2.add(Field.Keyword("id", "doc2"));
        lDoc2.add(Field.Keyword("handle", "1"));

        //����һ���洢�ĵ�
        Document lDoc3 = new Document();
        lDoc3.add(Field.Text("fulltext", "a bizarre bug manifested itself...."));
        lDoc3.add(Field.Keyword("id", "doc3"));
        lDoc3.add(Field.Keyword("handle", "1"));

        // Ϊ��һ����������һ��������д��
        IndexWriter writerA = new IndexWriter(indexStoreA, new StandardAnalyzer(), true);
        //Ϊ�ڶ�����������һ��������д��������ʲô����д
        IndexWriter writerB = new IndexWriter(indexStoreB, new StandardAnalyzer(), true);
        
        /***********************************/
        // ��һ��
	    /***********************************/
        //���ĵ���ӵ���һ��������
        writerA.addDocument(lDoc);
        writerA.addDocument(lDoc2);
        writerA.addDocument(lDoc3);
        writerA.optimize();
        writerA.close();

        // �رյڶ�������
        writerB.close();

        // ����һ����ѯ����
        Query query = QueryParser.parse("handle:1", "fulltext", new StandardAnalyzer());

        // ������������
        Searcher[] searchers = new Searcher[2];

        searchers[0] = new IndexSearcher(indexStoreB);
        searchers[1] = new IndexSearcher(indexStoreA);
        // ����һ��������������
        Searcher mSearcher = new MultiSearcher(searchers);
        // ���ؼ������
        Hits hits = mSearcher.search(query);

        System.out.println("There is "+hits.length()+" Document(s) matched!");
        try 
        {
            //�����������
            for (int i = 0; i < hits.length(); i++) 
            {
                Document d = hits.doc(i);
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBoundsException thrown: " + e.getMessage());
            e.printStackTrace();
        } finally
        {
            mSearcher.close();
        }
        
        /***********************************/
                // �ڶ���
	    /***********************************/
        //���ĵ���ӵ�һ����������
        writerB = new IndexWriter(indexStoreB, new StandardAnalyzer(), false);
        writerB.addDocument(lDoc);
        writerB.optimize();
        writerB.close();

        // ������������
        Searcher[] searchers2 = new Searcher[2];
		//
        searchers2[0] = new IndexSearcher(indexStoreB);
        searchers2[1] = new IndexSearcher(indexStoreA);
        // ����һ��������������
        Searcher mSearcher2 = new MultiSearcher(searchers);
        // ���ؼ������
        Hits hits2 = mSearcher2.search(query);

        System.out.println("There is "+hits2.length()+" Document(s) matched!");

        try {
            // �����������
            for (int i = 0; i < hits2.length(); i++) 			
{
                Document d = hits2.doc(i);
            }
        }
        catch (Exception e)
        {
            System.out.println("Exception thrown: " + e.getMessage());
            e.printStackTrace();
        } finally
        {
            //mSearcher2.close();
        }
        
        /***********************************/
        // ������
        /***********************************/

        //
        Term term = new Term("id", "doc1");
        IndexReader readerB = IndexReader.open(indexStoreB);
        readerB.delete(term);
        readerB.close();

        // ����������д��
        writerB = new IndexWriter(indexStoreB, new StandardAnalyzer(), false);
		//�Ż�����
        writerB.optimize();
		//�ر�����
        writerB.close();

        // ����������
        Searcher[] searchers3 = new Searcher[2];

        searchers3[0] = new IndexSearcher(indexStoreB);
        searchers3[1] = new IndexSearcher(indexStoreA);
        // ����һ��������������
        Searcher mSearcher3 = new MultiSearcher(searchers);
        // ���ؼ������
        Hits hits3 = mSearcher3.search(query);

        System.out.println("There is "+hits3.length()+" Document(s) matched!");
        try {
            // �����������
            for (int i = 0; i < hits3.length(); i++)
            {
                Document d = hits3.doc(i);
            }
        }
        catch (IOException e)
        {
        	 System.out.println("IOException thrown: " + e.getMessage());
            e.printStackTrace();
        } finally
        {
            //mSearcher3.close();
        }
	}
}
