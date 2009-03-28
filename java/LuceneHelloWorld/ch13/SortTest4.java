package ch13;
import org.apache.lucene.store.*;
import org.apache.lucene.document.*;
import org.apache.lucene.analysis.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.queryParser.*;

class SortTest4
{
  public static void main(String[] args) 
  {
    try 
    {
      Directory directory = new RAMDirectory();  
      Analyzer analyzer = new SimpleAnalyzer();
      IndexWriter writer = new IndexWriter(directory, analyzer, true);
	//��Ҫ�����������ĵ�����
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
	//���ν��ĵ���ӽ�������
      for (int j = 0; j < docs.length; j++)
      {
		//����һ���ĵ�����
        Document d = new Document();
		//�������
        d.add(Field.Text("contents", docs[j]));
		//���ĵ���ӽ�����
        writer.addDocument(d);
      }
		//�ر�����
      writer.close();
		//����һ��������
      Searcher searcher = new IndexSearcher(directory);
      	//���õļ����ַ���
      String[] queries = {
 	"\"a b\"",
      };
      Hits hits = null;

      QueryParser parser = new QueryParser("contents", analyzer);
   
	//���μ���
      for (int j = 0; j < queries.length; j++) 
      {
		//����Query����
        Query query = parser.parse(queries[j]);
        
        System.out.println("Query: " + query.toString("contents"));
        //�����������
        Sort sort = new Sort(new SortField[]{new SortField("title"),new SortField("contents")});
        //���ؼ������
        hits = searcher.search(query,sort);
        
        System.out.println(hits.length() + " total results");
        //�����������
        for (int i = 0 ; i < hits.length() && i < 10; i++)
        {
		//ȡ���ĵ�
          Document d = hits.doc(i);
          System.out.println(i + " " + hits.score(i)+ " " + d.get("contents"));
        }
      }
		//�ر�������
      searcher.close();
      
    } catch (Exception e) 
	    {
	      System.out.println(" caught a " + e.getClass() +
				 "\n with message: " + e.getMessage());
	    }
  }
}
