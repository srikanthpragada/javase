import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class NumbersFrame extends JFrame {
	JButton btnPrime, btnPerfect, btnExit;
	JLabel lblMessage;
	JTextField tfNumber;

	public NumbersFrame() {
		super("Numbers");

		// create UI
		btnPrime = new JButton("Prime");
		btnPerfect = new JButton("Perfect");
		btnExit = new JButton("Exit");
		JPanel bp = new JPanel();
		bp.add(btnPrime);
		bp.add(btnPerfect);
		bp.add(btnExit);

		lblMessage = new JLabel();
		lblMessage.setHorizontalAlignment(JLabel.CENTER);
		lblMessage.setForeground(Color.BLUE);
		lblMessage.setFont(new Font("Arial", Font.BOLD, 20));

		tfNumber = new JTextField(10);

		JPanel tp = new JPanel();
		tp.add(new JLabel("Number :"));
		tp.add(tfNumber);

		// Add them to Container
		Container c = getContentPane();
		c.add(tp, BorderLayout.PAGE_START);
		c.add(bp, BorderLayout.PAGE_END);
		c.add(lblMessage); // Center

		// Handle events
		btnExit.addActionListener(e -> System.exit(0)); // Lambda expression
		btnPrime.addActionListener(this::primeTest); // Method reference
		btnPerfect.addActionListener(this::perfectTest);

		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void primeTest(ActionEvent evt) {
		int num = getNumber();
		if (num < 0)
			return;

		for (int i = 2; i <= num / 2; i++)
			if (num % i == 0) {
				lblMessage.setText("Not a prime number!");
				return;
			}
		lblMessage.setText("Prime number!");
	}

	public void perfectTest(ActionEvent evt) {
		int num = getNumber();
		if (num < 0)
			return;

		int sum = 0;
		for (int i = 1; i <= num / 2; i++)
			if (num % i == 0) {
				sum += i;
			}

		if (sum == num)
			lblMessage.setText("Perfect number!");
		else
			lblMessage.setText("Not a perfect number!");
	}

	public int getNumber() {
		try {
			return Integer.parseInt(tfNumber.getText());

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Invalid Number. Please try again!", "Error",
					JOptionPane.ERROR_MESSAGE);
			tfNumber.grabFocus();
			return -1;
		}
	}

	public static void main(String[] args) {
		NumbersFrame nf = new NumbersFrame();

	}
}
