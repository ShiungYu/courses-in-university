import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class TemperatureChoiceFrame extends JPanel{//this Jpanel implement three temperature unit for selecting 

    private final JRadioButton fahrenheit;
    private final JRadioButton celsius;
    private final JRadioButton kelvin;
    private final ButtonGroup radioGroup;
    private String status;//recording the currently unit 

    public TemperatureChoiceFrame()
    {
        status="fahrenheit";
        setLayout(new FlowLayout(FlowLayout.LEFT));
        fahrenheit=new JRadioButton("Fahrenheit",true);
        celsius=new JRadioButton("Celsius",true);
        kelvin=new JRadioButton("Kelvin",true);
        add(fahrenheit);
        add(celsius);
        add(kelvin);

        //put these three button to the group
        radioGroup=new ButtonGroup();
        radioGroup.add(fahrenheit);
        radioGroup.add(celsius);
        radioGroup.add(kelvin);

        fahrenheit.addItemListener(new Handler("fahrenheit"));
        celsius.addItemListener(new Handler("celsius"));
        kelvin.addItemListener(new Handler("kelvin"));
    }

    private class Handler implements ItemListener
    {
        private String ss;
        public Handler(String b)
        {
            ss=b;
        }

        public void itemStateChanged(ItemEvent event)
        {
            status=ss;//if the button is changed, change the status
        }
    }

    public String getStatus()//get the unit which is using
    {
        return status;
    }
}
