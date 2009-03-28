package ch11;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.RangeQuery;

public class PrefixQueryTest {
	public static void main(String[] args) throws Exception {
		Document doc1 = new Document();
		doc1.add(Field.Text("name", "David"));
		doc1.add(Field.Keyword("title", "doc1"));

		Document doc2 = new Document();
		doc2.add(Field.Text("name", "Darwen"));
		doc2.add(Field.Keyword("title", "doc2"));

		Document doc3 = new Document();
		doc3.add(Field.Text("name", "Smith"));
		doc3.add(Field.Keyword("title", "doc3"));

		Document doc4 = new Document();
		doc4.add(Field.Text("name", "Smart"));
		doc4.add(Field.Keyword("title", "doc4"));

		IndexWriter writer = new IndexWriter("c:\\index",
				new StandardAnalyzer(), true);
		writer.setUseCompoundFile(true);
		writer.addDocument(doc1);
		writer.addDocument(doc2);
		writer.addDocument(doc3);
		writer.addDocument(doc4);
		writer.close();

		IndexSearcher searcher = new IndexSearcher("c:\\index");
		Term pre1 = new Term("name", "Da");
		Term pre2 = new Term("name", "da");
		Term pre3 = new Term("name", "sm");

		Hits hits = null;
		PrefixQuery query = null;

		query = new PrefixQuery(pre1);
		hits = searcher.search(query);
		printResult(hits, "ǰ׺Ϊ'Da'���ĵ�");
		
		query = new PrefixQuery(pre2);
		hits = searcher.search(query);
		printResult(hits, "ǰ׺Ϊ'da'���ĵ�");
		
		query = new PrefixQuery(pre3);
		hits = searcher.search(query);
		printResult(hits, "ǰ׺Ϊ'sm'���ĵ�");

	}

	public static void printResult(Hits hits, String key) throws Exception {
		System.out.println("���� \"" + key + "\" :");
		if (hits != null) {
			if (hits.length() == 0) {
				System.out.println("û���ҵ��κν��");
				System.out.println();
			} else {
				System.out.print("�ҵ�");
				for (int i = 0; i < hits.length(); i++) {
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
