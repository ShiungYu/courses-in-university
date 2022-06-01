
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.lang.Double;

public class ExternalFrame extends JFrame//this is main Frame
{
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;
    private final JLabel label4;
    private final TemperatureChoiceFrame frameUp;
    private final TemperatureChoiceFrame frameDown;
    private final InputFrame input;
    private final JTextField ansTextField;

    public ExternalFrame()
    {
        super("Temperature Conversion");
        setLayout(new GridLayout(8,1));

        label1=new JLabel("Convert from:");
        add(label1);

        frameUp=new TemperatureChoiceFrame();
        add(frameUp);

        label2=new JLabel("Convert to:");
        add(label2);

        frameDown=new TemperatureChoiceFrame();
        add(frameDown);

        label3=new JLabel("Source Temperature:");
        add(label3);

        input= new InputFrame();
        add(input);

        label4=new JLabel("Target Temperature:");
        add(label4);

        ansTextField=new JTextField();
        ansTextField.setEditable(false);
        add(ansTextField);
        
        buttonHandler handler=new buttonHandler();
        input.inputField.addActionListener(handler);
        input.confirmButton.addActionListener(handler); 
    }
    private class buttonHandler implements ActionListener//if press enter in textfield or click confirmbutton , Do the action event
    {
        

        public void actionPerformed(ActionEvent e)
        {
            
            String temp=input.inputField.getText();
            count(Double.parseDouble(temp));
        }
    }
    public void setAns(String input)//set the output
    {
        
        ansTextField.setText(input);
    }

    public void count(double intitialNum)//changing all unit to celsius and calculate
    {
        if(frameUp.getStatus()=="fahrenheit")
        {   
            intitialNum=(intitialNum-32)*5/9;
        }
        else if(frameUp.getStatus()=="kelvin")
        {
            intitialNum-=273.15;
        }
        if(frameDown.getStatus()=="fahrenheit")
        {
            intitialNum=intitialNum*9/5+32;
        }
        else if(frameDown.getStatus()=="kelvin")
        {
            intitialNum+=273.15;
        }
        
        
        setAns(Double.toString(intitialNum));
    }
    
}