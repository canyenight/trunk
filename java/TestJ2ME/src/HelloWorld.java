import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class HelloWorld extends MIDlet
{
	private Display display;
	private Form form;

	public HelloWorld()
	{
		super();
		// TODO �Զ����ɹ��캯�����
		display = Display.getDisplay(this);		
		form = new Form("Example Form");
	}

	protected void startApp() throws MIDletStateChangeException
	{
		// TODO �Զ����ɷ������
		form.append("shirui");
		display.setCurrent(form);
	}

	protected void pauseApp()
	{
		// TODO �Զ����ɷ������

	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException
	{
		// TODO �Զ����ɷ������

	}

}
