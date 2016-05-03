package swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PrimeFrame extends JFrame implements ActionListener {

	JTextField tfNumber;
	JButton btnPrime;
	JLabel lblMessage;

	public PrimeFrame() {
		super("Prime Number");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildUI();
	}

	public void buildUI() {
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		c.add(new JLabel("Number"), gbc);
		tfNumber = new JTextField(10);
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		c.add(tfNumber, gbc);

		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.NONE;
		btnPrime = new JButton("Prime");
		c.add(btnPrime, gbc);

		btnPrime.addActionListener(this);

		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		lblMessage = new JLabel();
		lblMessage.setHorizontalAlignment(JLabel.CENTER);
		lblMessage.setForeground(new Color(255, 0, 0));
		c.add(lblMessage, gbc);

	}

	public void actionPerformed(ActionEvent evt) {
		try {
			int number = Integer.parseInt(tfNumber.getText());

			for (int i = 2; i <= number / 2; i++) {
				if (number % i == 0) {
					lblMessage.setText("Not a prime number!");
					return;
				}
			}

			lblMessage.setText("Prime Number!");
		} catch (Exception ex) {
			lblMessage.setText("Sorry! Invalid Number!");
			tfNumber.selectAll();
			tfNumber.grabFocus();
		}
	}

	public static void main(String[] args) {
		PrimeFrame f = new PrimeFrame();
		f.setSize(300, 200);
		f.setVisible(true);

	}

}
