package ch15;


public class SplitCaller {
  private SplitCaller() {
  }
  public static native String split(String source,int outFarmat, int operType);

  public static void main (String[] args){
	String source = "��ֻ��һ������ʵ��";
	System.out.println(split(source,0,0));
  }
  static{
    System.loadLibrary("Split");
  }
}
