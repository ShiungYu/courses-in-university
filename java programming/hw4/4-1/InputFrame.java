import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JButton;


public class InputFrame extends JPanel{//this Jpanel implement input block 
    public final JTextField inputField;//a textField
    public final JButton confirmButton;//a confirmbutton
    //private boolean go;
    public InputFrame()
    {
        //go=false;
        setLayout(new BorderLayout());

        inputField=new JTextField();
        add(inputField,BorderLayout.CENTER);
        confirmButton=new JButton("convert");
        add(confirmButton,BorderLayout.EAST);

           
        
    } 
}

