package ch11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Searcher;

public class HitsTest
{

  public static void main(String[] args) throws Exception
  {
      // ��������
      buildIndex();

      // ʹ���Ѿ���������Ŀ¼
      Searcher searcher = new IndexSearcher("c:\\index");
      // ʹ�ñ�׼������
      Analyzer aStandardAnalyzer = new StandardAnalyzer();
      // �ӱ�׼�����ȡ��ѯ���ַ���
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      while (true)
      {
        System.out.println("-------------------------------------------------");
        System.out.print("Query: ");
        String line = in.readLine();
        // �ж��Ƿ�ֱ������Ļس�
        if (line.length() == 0)
          break;
        // ����Query����
        Query query = QueryParser.parse(line, "contents", aStandardAnalyzer);
        // ���Ҫ����������
        System.out.println("���� :    " + query.toString("contents"));
        // ʹ��searcher�����search�����������������ص���һ��Hits���͵Ķ���
        Hits hits = searcher.search(query);
        // ʹ��Hits�����length����������������������ĵ�������
        System.out.println("�ܹ��ҵ� " + hits.length() + " ���ĵ�");
        // ����ÿ����ʾ�����������Ŀ
        final int HITS_PER_PAGE = 10;
        // ѭ�����
        for (int start = 0; start < hits.length(); start += HITS_PER_PAGE)
        {
          //
          int end = Math.min(hits.length(), start + HITS_PER_PAGE);
          for (int i = start; i < end; i++)
          {
            // ȡ����������е�һ���ĵ�����
            Document doc = hits.doc(i);
            // ����ĵ���ID���
            System.out.println("�ĵ����ڲ�ID��:" + hits.id(i));
            // ����ĵ�������
            System.out.println("�ĵ��ķ�ֵ:" + hits.score(i));
            // ����ĵ��Ĵ��·��
            String path = doc.get("path");
            if (path != null)
            {
              System.out.println("·��Ϊ��"+path);
            }
          }
          // �ж��Ƿ��н��δ���
          if (hits.length() > end)
          {
            System.out.print("more (y/n) ? ");
            line = in.readLine();
            if (line.length() == 0 || line.charAt(0) == 'n')
              break;
          }
        }
      }
      //
      searcher.close();
  }
  
  public static void buildIndex() throws Exception {
    Document doc1 = new Document();
    doc1.add(Field.Text("contents", "word1 word"));
    doc1.add(Field.Keyword("path", "path\\document1.txt"));
    doc1.setBoost(1.0f);
    
    Document doc2 = new Document();
    doc2.add(Field.Text("contents", "word2 word"));
    doc2.add(Field.Keyword("path", "path\\document2.txt"));
    doc2.setBoost(0.1f);
    
    Document doc3 = new Document();
    doc3.add(Field.Text("contents", "word3 word"));
    doc3.add(Field.Keyword("path", "path\\document3.txt"));
    doc3.setBoost(0.5f);
    
    Document doc4 = new Document();
    doc4.add(Field.Text("contents", "word4 word"));
    doc4.add(Field.Keyword("path", "path\\document4.txt"));
    doc4.setBoost(0.2f);
    
    Document doc5 = new Document();
    doc5.add(Field.Text("contents", "word5 word"));
    doc5.add(Field.Keyword("path", "path\\document5.txt"));
    doc5.setBoost(0.8f);
    
    Document doc6 = new Document();
    doc6.add(Field.Text("contents", "word6 word"));
    doc6.add(Field.Keyword("path", "path\\document6.txt"));
    doc6.setBoost(0.1f);
    
    Document doc7 = new Document();
    doc7.add(Field.Text("contents", "word7 word"));
    doc7.add(Field.Keyword("path", "path\\document7.txt"));
    doc7.setBoost(0.5f);
    
    Document doc8 = new Document();
    doc8.add(Field.Text("contents", "word8 word"));
    doc8.add(Field.Keyword("path", "path\\document8.txt"));
    doc8.setBoost(0.7f);
    
    Document doc9 = new Document();
    doc9.add(Field.Text("contents", "word9 word"));
    doc9.add(Field.Keyword("path", "path\\document9.txt"));
    doc9.setBoost(0.2f);
    
    Document doc10 = new Document();
    doc10.add(Field.Text("contents", "word10 word"));
    doc10.add(Field.Keyword("path", "path\\document10.txt"));
    doc10.setBoost(0.4f);
    
    Document doc11 = new Document();
    doc11.add(Field.Text("contents", "word11 word"));
    doc11.add(Field.Keyword("path", "path\\document11.txt"));
    
    Document doc12 = new Document();
    doc12.add(Field.Text("contents", "word12 word"));
    doc12.add(Field.Keyword("path", "path\\document12.txt"));
    
    IndexWriter writer = new IndexWriter("c:\\index", new StandardAnalyzer(), true);
    
    writer.addDocument(doc1);
    writer.addDocument(doc2);
    writer.addDocument(doc3);
    writer.addDocument(doc4);
    writer.addDocument(doc5);
    writer.addDocument(doc6);
    writer.addDocument(doc7);
    writer.addDocument(doc8);
    writer.addDocument(doc9);
    writer.addDocument(doc10);
    writer.addDocument(doc11);
    writer.addDocument(doc12);
    
    writer.close();
  }
}
