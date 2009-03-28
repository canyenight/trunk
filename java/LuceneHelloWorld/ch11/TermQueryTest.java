/*
 * Created on 2006-3-11
 */
package ch11;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;

public class TermQueryTest
{
  public static void main(String[] args) throws Exception
  {
    Document doc1 = new Document();
    doc1.add(Field.Text("name", "word1 word2 word3"));
    doc1.add(Field.Keyword("title", "doc1"));

    IndexWriter writer = new IndexWriter("c:\\index", new StandardAnalyzer(), true);
    writer.addDocument(doc1);
    writer.close();

    Query query = null;
    Hits hits = null;
    
    IndexSearcher searcher = new IndexSearcher("c:\\index");
    
    query = new TermQuery(new Term("name","word1"));
    hits = searcher.search(query);
    printResult(hits, "word1");
    
    query = new TermQuery(new Term("title","doc1"));
    hits = searcher.search(query);
    printResult(hits, "doc1");

  }

  public static void printResult(Hits hits, String key) throws Exception
  {
    System.out.println("���� \"" + key + "\" :");
    if (hits != null)
    {
      if (hits.length() == 0)
      {
        System.out.println("û���ҵ��κν��");
      }
      else
      {
        System.out.println("�ҵ�" + hits.length() + "�����");
        for (int i = 0; i < hits.length(); i++)
        {
          Document d = hits.doc(i);
          String dname = d.get("title");
          System.out.print(dname + "   ");
        }
        System.out.println();
        System.out.println();
      }
    }
  }
}
