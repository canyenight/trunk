package performance.document;

import java.io.*;
import java.util.StringTokenizer;

import org.apache.lucene.document.*;

public class MyDocument {
	
	/**
	 * ���ı��ĵ�ת��Lucene��Document��ʽ
	 * @param file
	 * @return document that represents a file
	 * @throws Exception
	 */
	public static Document getDocument(File file) throws IOException {
		Document doc = new Document();

		/**
		 * Ϊ�ļ�·������һ���ֶ�
		 */
		doc.add(Field.Text("path", file.getPath()));

		/**
		 * Ϊ�ļ�������һ���ֶ�
		 */
		doc.add(Field.Keyword("title", getFileName(file)));

		/**
		 * Ϊ�ļ����ݹ���һ���ֶ�
		 */
		FileInputStream is = new FileInputStream(file);
		Reader reader = new BufferedReader(new InputStreamReader(is));
		doc.add(Field.Text("contents", reader));

		/**
		 * Ϊ�ļ�������޸�ʱ�乹��һ���ֶ�
		 */
		doc.add(Field.Keyword("modified", DateField.timeToString(file
				.lastModified())));

		return doc;
	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	private static String getFileName(File file) {
		String path = file.getPath();
		StringTokenizer st = new StringTokenizer(path, File.separator);
		String token = "";
		while (st.hasMoreTokens()) {
			token = st.nextToken();
		}

		if (token != null) {
			token = token.substring(0, token.indexOf(".txt"));
		}
		return token;
	}
}
