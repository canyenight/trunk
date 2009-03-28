package testlucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

public class LuceneIndex {
	public static void main(String[] args) throws Exception {
		// ����һ������
		LuceneIndex indexer = new LuceneIndex();
		// ��������
		Date start = new Date();
		indexer.writeToIndex();
		Date end = new Date();
		
		System.out.println("����������ʱ" + (end.getTime() - start.getTime()) + "����");

		indexer.close();
	}

	public LuceneIndex() {
		try {
			writer = new IndexWriter(Constants.INDEX_STORE_PATH,
					new StandardAnalyzer(), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ������
	private IndexWriter writer = null;

	// ��Ҫ�����������ļ������һ��Document���󣬲����һ����"content"
	private Document getDocument(File f) throws Exception {
		Document doc = new Document();

		FileInputStream is = new FileInputStream(f);
		Reader reader = new BufferedReader(new InputStreamReader(is));
		doc.add(Field.Text("contents", reader));

		doc.add(Field.Keyword("path", f.getAbsolutePath()));
		return doc;
	}

	public void writeToIndex() throws Exception {
		File folder = new File(Constants.INDEX_FILE_PATH);
		if (folder.isDirectory()) {
			String[] files = folder.list();
			for (int i = 0; i < files.length; i++) {
				File file = new File(folder, files[i]);
				Document doc = getDocument(file);
				System.out.println("���ڽ������� : " + file + "");
				writer.addDocument(doc);
			}
		}
	}

	public void close() throws Exception {
		writer.close();
	}

}
