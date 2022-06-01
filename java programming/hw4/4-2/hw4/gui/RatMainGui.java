//00957118 date:0601
package ntou.cs.java2022.hw4.gui;

import ntou.cs.java2022.hw4.model.Pharmacy;
import ntou.cs.java2022.hw4.model.RatHandler;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class RatMainGui extends JFrame{
    private final JTextField district;
    private final JTextField pharmacyName;
    private final JButton confirmButton;
    private final JButton refreshButton;
    private final JPanel upPanel;
    private JPanel downPanel;
    private final RatInfoViewer[] interfacee;
    private final String[] distrcitList;
    private final String[] nameList;
    private int time;
    public RatMainGui()
    {
        super("快篩追蹤系統");

        distrcitList=new String[5];//using array to store different input data
        nameList=new String[5];
        interfacee=new RatInfoViewer[5];//using array to store different ratinfoViewr data
        time=0;

        //upPanel:input Block
        district=new JTextField("輸入地區(如基隆市中正區)");
        pharmacyName=new JTextField("輸入藥局名稱(如海大)");
        district.setPreferredSize(new Dimension(130,30));
        pharmacyName.setPreferredSize(new Dimension(130,30));
        confirmButton=new JButton("搜尋藥局");
        refreshButton=new JButton("更新資料");
        upPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        upPanel.add(district);
        upPanel.add(pharmacyName);
        upPanel.add(confirmButton);
        upPanel.add(refreshButton);

        confirmButton.addActionListener(new Handler("confirmButton"));
        refreshButton.addActionListener(new Handler("refreshButton"));

        setLayout(new BorderLayout());
        add(upPanel,BorderLayout.NORTH);//set the upPanel to the North
    }
    private class Handler implements ActionListener
    {
        private String buttonName;
        public Handler(String b)
        {
            buttonName=b;
        }

        public void actionPerformed(ActionEvent event)
        {
            if(buttonName=="confirmButton") {
                try {
                    nameList[time + 1] = pharmacyName.getText();
                    distrcitList[time + 1] = district.getText();
                    //System.out.println(nameList[time+1]);
                    interfacee[time + 1] = new RatInfoViewer();
                    revalidate(interfacee[time + 1], nameList[time + 1], distrcitList[time + 1]);
                    time++;
                }
                catch (Exception e)//if index out of bounds or cannot find anything ,throw the exception
                {
                    JOptionPane.showMessageDialog(null,"無搜尋結果或超出可顯示數量");
                    return;
                }
            }
            for(int i=1;i<=time;i++) {//reload data
                revalidate(interfacee[i], nameList[i], distrcitList[i]);
            }
            
            if(time<=2)
            {
                downPanel=new JPanel(new GridLayout(2,1));//if RatinfoViewer less than 2, using 2*1 Grid
                for(int i=1;i<=time;i++)
                {
                    downPanel.add(interfacee[i]);

                }
            }
            else//if RatinfoView >2 and <4 ,using 2*2Grid
            {
                downPanel=new JPanel(new GridLayout(2,2));
                for(int i=1;i<=time;i++)
                {
                    downPanel.add(interfacee[i]);
                }
            }
            add(downPanel,BorderLayout.CENTER);//add the downPanel to the center
            setVisible(true);
        }


    }
    private void revalidate(RatInfoViewer ratInfoViewer,String queryName,String queryAddress)
    {
        try {
            RatHandler handler = new RatHandler();
            handler.initialize();
            List<Pharmacy> filteredClinicList = handler.findPharmacies(queryName, queryAddress);

            ratInfoViewer.setPharmacyInfo(filteredClinicList.get(0));

        } catch (IOException | URISyntaxException e) {
            System.err.println(e);
        }
    }


}