/* AWTCounter */

import java.awt.*;
import java.awt.event.*;

public class AWTCounter extends Frame implements ActionListener
{
	private Label lable;
	private TextField field;
	private Button button;
	public static int count;
	public AWTCounter()
	{
		lable=new Label("Counter");
		field=new TextField("0");
		field.setEditable(false);
		button=new Button("count");
		setLayout(new FlowLayout());
		setTitle("AWT Counter");
		setSize(200,200);
		setVisible(true);
		add(lable);
		add(field);
		add(button);
		button.addActionListener(this);		
	}
	@Override
	public void actionPerformed(ActionEvent ev)
	{
		count++;
		field.setText(count+"");
	}
	public static void main(String[] args)
	{
		AWTCounter gui=new AWTCounter();
	}
}