import javax.swing.JFrame;
public class TemperatureTransferFrameTest {
public ExternalFrame demo;
    public static void main(String[] args)
    {
        ExternalFrame demo = new ExternalFrame();
    
        demo.setSize(300, 300);//Frame size
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        demo.setVisible(true);   
    }
}
