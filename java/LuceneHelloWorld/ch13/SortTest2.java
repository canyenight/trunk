package ch13;

import org.apache.lucene.store.*;
import org.apache.lucene.document.*;
import org.apache.lucene.analysis.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.queryParser.*;

class SortTest2
{
  public static void main(String[] args) 
  {
    try 
    {
		//��������Ŀ¼
      Directory directory = new RAMDirectory();
		//���ɷ�����
      Analyzer analyzer = new SimpleAnalyzer();
		//����������д��
      IndexWriter writer = new IndexWriter(directory, analyzer, true);
		//��Ҫ���м������ı�����
      String[] docs = 
      {
        "a b c d e",
        "a b c d e a b c d e",
        "a b c d e f g h i j",
        "a c e",
        "e c a",
        "a c e a c e",
        "a c e a b c"
      };
		//ѭ�����������������
      for (int j = 0; j < docs.length; j++)
      {	
		//ȡ���ĵ�
        Document d = new Document();
		//��Ӽ�������
        d.add(Field.Text("contents", docs[j]));
		//��ӽ�����
        writer.addDocument(d);
      }
		//�ر�����
      writer.close();
		//���ɼ�������
      Searcher searcher = new IndexSearcher(directory);
      	//���ü������ַ���
      String[] queries = {
 	"\"a b\"",
 	// 	"\"a b c\"",
 	// 	"\"a c\"",
 	// "\"a c e\"",
      };
		//����������
      Hits hits = null;
		//���ɼ�������
      QueryParser parser = new QueryParser("contents", analyzer);
   
		//���ν��м���
      for (int j = 0; j < queries.length; j++) 
      {
		//���ɼ�������
        Query query = parser.parse(queries[j]);
        	//
        System.out.println("Query: " + query.toString("contents"));

		//���ؼ������
		 hits = searcher.search(query,Sort.RELEVANCE);

		//����������
        //Sort sort = new Sort();
	    //hits = searcher.search(query,sort);
        System.out.println(hits.length() + " total results");
        	
        //�������صļ������
        for (int i = 0 ; i < hits.length() && i < 10; i++)
        {
		//ȡ���ĵ�
          Document d = hits.doc(i);
		//
          System.out.println(i + " " + hits.score(i)+ " " + d.get("contents"));
        }
      }
		//�رռ�����
      searcher.close();
    } catch (Exception e) 
	    {
		//
	      System.out.println(" caught a " + e.getClass() +
				 "\n with message: " + e.getMessage());
	    }
  }
}
