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

public class FontFrameV1 {
	private JFrame appFrame;
	private JButton increaseButton; // button to increase font size
	private JButton decreaseButton; // button to decrease font size
	private JTextArea text; // displays example text
	private int fontSize = 20; // current font size

	public FontFrameV1() {
		appFrame = new JFrame("Font Test");

		ActionListener listener0 = new MyEventListener(false);
		ActionListener listener1 = new MyEventListener(true);
		// create buttons and add action listeners
		// TODO
		increaseButton=new JButton("increase Button");
		decreaseButton=new JButton("decrease Button");
		appFrame.add(increaseButton);
		appFrame.add(decreaseButton);
		//add two botton to the appFrame
		increaseButton.addActionListener(listener0);//increase botton
		decreaseButton.addActionListener(listener1);//decrease botton 
		// create text area and set initial font
		text = new JTextArea("Test");
		text.setFont(new Font("Consolas", Font.PLAIN, fontSize));

		// add GUI components to frame
		JPanel panel = new JPanel(); // used to get proper layout
		panel.add(decreaseButton);
		panel.add(increaseButton);
		
		appFrame.add(panel, BorderLayout.NORTH); // add buttons at top
		appFrame.add(new JScrollPane(text)); // allow scrolling
	}

	private class MyEventListener implements ActionListener {
		// change font size when user clicks on a button
		// TODO
		private boolean isdecrease;
		public MyEventListener(boolean isdecrease)//contructor
		{	
			this.isdecrease=isdecrease;
		}

		public void actionPerformed(ActionEvent event)
		{
			if (isdecrease)// if isdecrease is true , it is decrease bottom
			{
				if(fontSize>=8)
				{
					fontSize-=2;
					text.setFont(new Font("Consolos", Font.PLAIN, fontSize));
				}
				else{
					JOptionPane.showMessageDialog(appFrame,String.format("No, it cannot be smaller!"));
				}
			}
			else//increase botton 
			{
				if(fontSize<=160)
				{
					fontSize+=2;
					text.setFont(new Font("Consolos", Font.PLAIN, fontSize));
				}
				else{
					JOptionPane.showMessageDialog(appFrame, String.format("No, it cannot be larger!"));
				}
			}
		}
	}
	
	public JFrame getFrame() {
		return appFrame;
	}
}
