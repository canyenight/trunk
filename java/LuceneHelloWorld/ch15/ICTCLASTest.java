package ch15;

import com.xjt.nlp.word.*;

public class ICTCLASTest {
	public static void main (String [] args) {
		ICTCLAS instance = ICTCLAS.getInstance();
		String sentence = "�ǵ���һλΰ��������˶�Ա";
		System.out.println(instance.paragraphProcess(sentence));
	}
}
