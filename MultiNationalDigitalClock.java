

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class MultiNationalDigitalClock extends JFrame {
    Timer t;
    JLabel lblIndia, lblSing, lblAust;
    
    
    public void formatLabel(JLabel lbl)
    { 
    	lbl.setHorizontalAlignment(JLabel.CENTER);
        lbl.setFont( new Font("Arial", Font.BOLD, 30));
    }
    
    public MultiNationalDigitalClock() {
        super("Digital Clock");
        lblIndia = new JLabel();
        lblSing = new JLabel();
        lblAust = new JLabel();
        
        formatLabel(lblIndia);
        formatLabel(lblSing);
        formatLabel(lblAust);
        
       
        Container c = getContentPane();
        c.setLayout( new GridLayout(3,1));
        
        c.add(lblIndia);
        c.add(lblSing);
        c.add(lblAust);
        
        t = new Timer(1000, e -> updateTimes() ); 
        t.start();
        
        setSize(300, 400);
    }

    public void updateTimes()
    {
    	 lblIndia.setText(LocalTime.now().format
                (DateTimeFormatter.ofPattern("HH:mm:ss")));
    	 
    	 lblSing.setText(LocalTime.now( ZoneId.of("Asia/Singapore")).format
                 (DateTimeFormatter.ofPattern("HH:mm:ss")));
    	 
    	 lblAust.setText(LocalTime.now( ZoneId.of("Australia/Sydney")).format
                 (DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
   
    public static void main(String args[]) {
        MultiNationalDigitalClock f = new MultiNationalDigitalClock();
        f.setVisible(true);
    }



}
