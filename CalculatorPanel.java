import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorPanel extends JPanel
{
	private JTextField Output;
	private JButton add, sub, div, equal, multip, clear, and, or, one, zero;
	private int count = 0;
	private char sign='+';
	private String answer = " ";
	private String [] input= {"0", "0"};
	{
		setPreferredSize(new Dimension(250, 150));
	    setBackground(Color.cyan);
	    setLayout(new FlowLayout());
		Output = new JTextField(null, 20);
		Output.setEditable(false);
		
		zero = new JButton("0");
		one = new JButton("1");
		add = new JButton ("+");
		sub = new JButton ("-");
		div = new JButton ("/");
		multip = new JButton ("*");
		and = new JButton ("AND");
		or = new JButton ("OR");
		equal = new JButton ("=");
		clear = new JButton("C");
		
		add(Output, BorderLayout.NORTH);
		
		add(zero);
		add(one);
		add(add);
		add(sub);
		add(div);
		add(multip);
		add(equal);
		add(and);
		add(or);
		add(clear);
		zero.addActionListener(new ButtonListener());
		equal.addActionListener(new ButtonListener());
		one.addActionListener(new ButtonListener());
		add.addActionListener(new ButtonListener());
		sub.addActionListener(new ButtonListener());
		div.addActionListener(new ButtonListener());
		multip.addActionListener(new ButtonListener());
		and.addActionListener(new ButtonListener());
		or.addActionListener(new ButtonListener());
		Output.addActionListener(new ButtonListener());
		clear.addActionListener(new ButtonListener());
	}
	
	private class ButtonListener implements ActionListener
	   {
		String sanswer = " "; int d1 = 0; int d2 = 0; int answer = 0;

		public void actionPerformed(ActionEvent event) 
		{
			
			JButton buttonPressed = (JButton)event.getSource();
			
			if (buttonPressed.equals(one))
			{
				input[1]+="1";
				Output.setText(input[count+1]);		
			}
			
			if (buttonPressed.equals(zero))
			{
				input[count+1]+="0";
                Output.setText(input[count+1]);
			}	
			
			if(buttonPressed.equals(add))
			{
				operation();
				sign = '+';
			}
			
			if(buttonPressed.equals(sub))
			{
				operation();
				sign = '-';
           }		
			
			if(buttonPressed.equals(multip))
			{
				operation();
	            sign = '*';			
			}
			
			if(buttonPressed.equals(div))
			{
				
				operation();
				if(d2==0)
				sign = '/';			
			}
			
			if(buttonPressed.equals(and))
			{
				operation();
				sign = '&';			
			}
			
			if(buttonPressed.equals(or))
			{
				operation();
				sign = '|';			
			}
			
			if(buttonPressed.equals(equal))
			{
				operation();				
			}
			
			if(buttonPressed.equals(clear))
			{
				input[count]="0";
				input[count+1]="0";
				Output.setText("0");
			}
		}
		
		public void operation()
		{	
			d1= BinaryDecimal.BinaryToDecimal(input[count]);
			d2= BinaryDecimal.BinaryToDecimal(input[count+1]);
			if(sign==('+'))
				answer = d1 + d2;
			else if(sign==('-'))
				answer = d1- d2;
			else if(sign==('*'))
				answer = d1*d2;
			else if(sign==('/'))
				answer = d1/d2;
			else if(sign ==('|'))
				answer = d1|d2;
			else if(sign ==('&'))
				answer = d1&d2;
			sanswer = BinaryDecimal.DecimalToBinary(answer);
			Output.setText(sanswer);
            input[count] = sanswer;
            input[count+1]="0";
		}		
	}
}
