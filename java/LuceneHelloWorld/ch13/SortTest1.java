package ch13;


import org.apache.lucene.store.*;
import org.apache.lucene.document.*;
import org.apache.lucene.analysis.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.queryParser.*;
class SortTest
{
  public static void main(String[] args) 
  {
    try 
    {
		//��������Ŀ¼
      Directory directory = new RAMDirectory();
		//���ɷִ���
      Analyzer analyzer = new SimpleAnalyzer();
		//������д��
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
		//ѭ�����ν�������
      for (int j = 0; j < docs.length; j++)
      {	
		//����Document����
        Document d = new Document();
		//�������
        d.add(Field.Text("contents", docs[j]));
		//��ӵ�������
        writer.addDocument(d);
      }
		//�ر�����
      writer.close();
		//��������������
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
		//���ɷ���������
      QueryParser parser = new QueryParser("contents", analyzer);
   
      for (int j = 0; j < queries.length; j++) 
      {
		//���ɼ�������
        Query query = parser.parse(queries[j]);
        	//
        System.out.println("Query: " + query.toString("contents"));

        	//�������
        Sort sort = new Sort();
	
		//���м��������ؼ������
	    hits = searcher.search(query,sort);
        System.out.println(hits.length() + " total results");

        	//ѭ���������صļ������
        for (int i = 0 ; i < hits.length() && i < 10; i++)
        {
		//ȡ���ĵ�
          Document d = hits.doc(i);
		//
          System.out.println(i + " " + hits.score(i)+ " " + d.get("contents"));
        }
      }
	//�ر�
      searcher.close();
      
    } catch (Exception e) 
	    {
	      System.out.println(" caught a " + e.getClass() +
				 "\n with message: " + e.getMessage());
	    }
  }
}
