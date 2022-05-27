import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FontFrameV2 extends JFrame {
	private JButton increaseButton; // button to increase font size
	private JButton decreaseButton; // button to decrease font size
	private JTextArea text; // displays example text
	private int fontSize = 20; // current font size

	public FontFrameV2() {
		super("Font Test");//title

		MyEventListner handler0 = new MyEventListner(false);
		MyEventListner handler1 = new MyEventListner(true);
		// create buttons and add action listeners
		// TODO
		increaseButton=new JButton("increase Button");
		decreaseButton=new JButton("decrease Button");
		add(increaseButton);
		add(decreaseButton);
		increaseButton.addActionListener(handler0);//increase botton
		decreaseButton.addActionListener(handler1);//decrease botton
		// create text area and set initial font
		text = new JTextArea("Test");
		text.setFont(new Font("Consolos", Font.PLAIN, fontSize));

		// add GUI components to frame
		JPanel panel = new JPanel(); // used to get proper layout
		panel.add(decreaseButton);
		panel.add(increaseButton);

		add(panel, BorderLayout.NORTH); // add buttons at top
		add(new JScrollPane(text)); // allow scrolling
	}

	private class MyEventListner implements ActionListener {
		// change font size when user clicks on a button
		// TODO
		private boolean isdecrease;
		public MyEventListner(boolean isdecrease)//contructor
		{
			this.isdecrease=isdecrease;
		}
		@Override
		public void actionPerformed(ActionEvent event)//if isdecrease = true , it is decrease botton
		{
			if (isdecrease)
			{
				if(fontSize>=8)//if font size is higher than 8
				{
					fontSize-=2;
					text.setFont(new Font("Consolos", Font.PLAIN, fontSize));
				}
				else{
					JOptionPane.showMessageDialog(FontFrameV2.this, String.format("No, it cannot be smaller!"));
				}
			}
			else 
			{
				if(fontSize<=160)//if font size is lower than 160
				{
					fontSize+=2;
					text.setFont(new Font("Consolos", Font.PLAIN, fontSize));
				}
				else{
					JOptionPane.showMessageDialog(FontFrameV2.this, String.format("No, it cannot be larger!"));
				}
			}
		}
	}

} 
