// Takes a number and displays factorial 
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FactorialFrame extends JFrame  {
    JTextField tfNumber;
    JButton btnGo;
    JLabel lblResult;
    
	public FactorialFrame() {
		super("Factorial");
		// build ui
		tfNumber = new JTextField(10);
		btnGo = new JButton("Go");
		lblResult = new JLabel();
		
		//lblResult.setBackground(Color.ORANGE);
		lblResult.setFont( new Font("Calibri",Font.BOLD,20));
		lblResult.setHorizontalAlignment(JLabel.CENTER);
		// lblResult.setOpaque(true);
		
		Container c = getContentPane();
		JPanel p = new JPanel();  // Default FlowLayout
		p.add( new JLabel("Number :"));
		p.add( tfNumber);
		p.add( btnGo);
		
		c.add(p, BorderLayout.CENTER);
		c.add(lblResult, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		
		btnGo.addActionListener( e -> {
			// calculate factorial of the given number
			int num = Integer.parseInt(tfNumber.getText());
			int fact = 1;
			for (int i = 2; i <= num; i ++)
				fact *= i;
			
			lblResult.setText(String.valueOf(fact));
		});
		
	}
	public static void main(String[] args) {
		FactorialFrame f = new FactorialFrame();
		f.setSize(300,200);
		f.setVisible(true);
	}

}
