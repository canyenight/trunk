package testlucene;

import java.util.Date;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Hits;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;

public class LuceneSearch {
//	public static void main(String[] args) throws Exception {
//		LuceneSearch test = new LuceneSearch();
//		// ��������������ؼ���
//		Hits h = null;
//		h = test.search("�л�");
//		test.printResult(h);
//		h = test.search("����");
//		test.printResult(h);
//		h = test.search("���͹�");
//		test.printResult(h);
//	}
	
	public static void main(String[] args) throws Exception {
		LuceneSearch test = new LuceneSearch();
		Hits h = null;
		h = test.search("����");
		test.printResult(h);
		h = test.search("����");
		test.printResult(h);
		h = test.search("��");
		test.printResult(h);
	}

	public LuceneSearch() {
		try {
			searcher = new IndexSearcher(IndexReader
					.open(Constants.INDEX_STORE_PATH));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ����һ��IndexSearcher����
	private IndexSearcher searcher = null;

	// ����һ��Query����
	private Query query = null;

	public final Hits search(String keyword) {
		System.out.println("���ڼ����ؼ��� : " + keyword);
		try {
			// ���ؼ��ְ�װ��Query����
			query = QueryParser.parse(keyword, "contents",
					new StandardAnalyzer());

			Date start = new Date();
			Hits hits = searcher.search(query);
			Date end = new Date();
			System.out.println("������ɣ���ʱ" + (end.getTime() - start.getTime()) + "����");
			return hits;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void printResult(Hits h) {
		if (h.length() == 0) {
			System.out.println("�Բ���û���ҵ���Ҫ�Ľ����");
		} 
		else 
		{
			for (int i = 0; i < h.length(); i++) {
				try {
					Document doc = h.doc(i);
					System.out.print("���ǵ�" + i + "���������Ľ�����ļ���Ϊ��");
					System.out.println(doc.get("path"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("--------------------------");
	}

}
