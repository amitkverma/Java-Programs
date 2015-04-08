/* AWTAccumulator */

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame implements ActionListener
{
	private Label label1;
	private Label label2;
	private TextField field1;
	private TextField field2;
	private int sum=0;
	private int inputNum=0;
	public AWTAccumulator()
	{
		label1=new Label("Enter a Integer");
		label2=new Label("Accumulated sum is");
		field1=new TextField("0");
		field1.addActionListener(this);
		field2=new TextField("0");
		field2.setEditable(false);
		setLayout(new FlowLayout());
		setTitle("AWT Accumulator");
		setSize(200,150);
		setVisible(true);
		add(label1);
		add(field1);
		add(label2);
		add(field2);
	}
	public static void main(String[] args)
	{
		AWTAccumulator gui=new AWTAccumulator();
	}
	@Override
	public void actionPerformed(ActionEvent evt)
	{
		inputNum=Integer.parseInt(field1.getText());
		sum+=inputNum;
		field2.setText(sum+"");
	}
}