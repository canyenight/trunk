package ch15;


public class TestAutoSplit
{
	static 
	{
		System.loadLibrary("Split");
	}
	public static native String split(String source,int outFarmat, int operType);
	
	public static void main(String[] args)
	{
		String source = "�л����񹲺͹�";
		String splitSource = split(source,0,0);
		System.out.println(splitSource);
		
		
	}

}