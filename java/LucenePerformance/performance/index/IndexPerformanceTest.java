package performance.index;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.*;
//import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
//import org.apache.lucene.queryParser.*;
import org.apache.lucene.store.*;

import performance.document.MyDocument;

public class IndexPerformanceTest {
	
	/**
	 * ������ŵ�λ��
	 */
	public static final String INDEX_STORE_PATH = "c:\\index";
	
	/**
	 * �ϲ�����ǰ���ڴ��������ļ�����
	 */
	public static final int DEFAULT_MAX_DOCS_IN_RAM = 64;
	
	/**
	 * ����ֶγ���
	 */
	public static final int DEFAULT_MAX_FIELD_LENGTH = Integer.MAX_VALUE;
	
	/***
	 * ����ģʽ
	 */
	private static IndexPerformanceTest indexer = null;
	
	// ����������
	private IndexWriter ramWriter = null;
	private IndexWriter fsWriter = null;	

	// �ڴ����Ѿ��е��ĵ�����
	private int docs_in_ram;
	// �ڴ��������ĵ�����
	private int ramMaxFiles = DEFAULT_MAX_DOCS_IN_RAM;
	
	// �ڴ��Ƿ��Ѿ���ˢ�¹�
	private boolean freshed = true;
	
	// ������ŵ��ļ�ϵͳĿ¼
	FSDirectory fsDir = null;
	// ������ŵ��ڴ�Ŀ¼
	RAMDirectory ramDir = null;
	
	// ˽�еĹ��캯��
	private IndexPerformanceTest() throws IOException{
		
	}
	
	/**
	 * ��̬��������һ������ 
	 */
	public static IndexPerformanceTest getInstance() throws IOException{
		if (indexer == null){
			indexer = new IndexPerformanceTest();
		}
		return indexer;
	}
	
	/**
	 *  ����������
	 */
	public void newWriter(){
		
		if (fsWriter != null || ramWriter != null) {
			System.out.println("close the indexer first then to create a new one");
			return;
		}
		
		try{
			boolean rebuild = true;
			
			fsDir = FSDirectory.getDirectory(INDEX_STORE_PATH,rebuild);
			ramDir = new RAMDirectory();
			
			Analyzer analyzer = new StandardAnalyzer();
			
			ramWriter = new IndexWriter(ramDir,analyzer,true);
			fsWriter = new IndexWriter(fsDir,analyzer,rebuild);
			initWriter();
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ʼ��������
	 * @throws IOException
	 */
	private void initWriter() throws IOException{
		fsWriter.maxFieldLength = DEFAULT_MAX_FIELD_LENGTH;
	}
	
	/**
	 *  �Ż�����
	 */
	public void optimizeIndex() throws IOException{
		if (fsWriter == null || ramWriter == null) {
			System.out.println("use newWriter() method to initialize a new indexer first");
			return;
		}
		
		refreshRam();
		fsWriter.optimize();
	}
	

	/***
	 * ����ĳ��Ŀ¼�µ��ļ�
	 * @param path
	 */
	public void toIndex(String path) throws IOException{
		toIndex(new File(path));
	}
	
	/***
	 * ����ĳ��File����
	 * @param file
	 */
	public void toIndex(File file) throws IOException{
		if (fsWriter == null || ramWriter == null) {
			System.out.println("use newWriter() method to initialize a new indexer first");
			return;
		}
		freshed = false;
		Date start = new Date();
		int number = indexFiles(file);
		Date end = new Date();
		System.out.println("�ܹ���ʱ" + (end.getTime()-start.getTime()) + "����" );
		System.out.println("һ��Ϊ" + number + "���ļ���������");
	}
	
	/***
	 * �ر�����
	 *
	 */
	public void close() throws IOException{
		if (fsWriter == null || ramWriter == null) {
			System.out.println("use newWriter() method to initialize a new indexer first");
			return;
		}
//		refreshRam();
		ramWriter.close();
		fsWriter.close();
	}
	
	/***
	 * ˢ���ڴ�
	 *
	 */
	private void refreshRam() throws IOException{
		if ( !freshed ){
			
			System.out.println("Refreshing..");
			
			fsWriter.addIndexes(new Directory[] {ramDir});

			ramDir.close();
			ramDir = new RAMDirectory();
			ramWriter = new IndexWriter(ramDir,new StandardAnalyzer(),true);
			
			docs_in_ram = 0;
			freshed = true;
		}
	}
	
	/***
	 * �������м����ĵ�
	 * @throws IOException
	 */
	private void addDocument(File file) throws IOException{
		
		if (docs_in_ram >= ramMaxFiles){
			refreshRam();
		}
		
		ramWriter.addDocument(MyDocument.getDocument(file));
		docs_in_ram++;
		freshed = false;
	}
	
	/***
	 * �ݹ�����ļ�Ŀ¼����������
	 * 
	 * @throws IOException
	 */
	private int indexFiles(File file) throws IOException{
		if (file.isDirectory()){
			File[] files = file.listFiles();
			int num = 0;
			for (int i=0;i<files.length;i++) {
				num += indexFiles(files[i]);
			}
			return num;
		} else {
			if (file.getPath().endsWith(".txt"))
//			if (true)
			{
				System.out.println("���ڽ�����" + file);
				addDocument(file);
				return 1;
			}
			else
			{
				System.out.println("�ļ����Ͳ�֧��" + file);
				return 0;
			}
		}
	}
	
	public static void main (String [] args) throws IOException {
		IndexPerformanceTest indexer = IndexPerformanceTest.getInstance();
		indexer.newWriter();
		indexer.toIndex("c:\\myweb");
		indexer.close();
	}
}
