import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AgeCalculator extends JFrame {
	JTextField tfDob;
	JButton btnCalculate;
	JLabel lblAge;

	public AgeCalculator() {
		super("Age Calculator 1.0");
		tfDob = new JTextField(10);
		btnCalculate = new JButton("Calculate");
		lblAge = new JLabel("");
		lblAge.setFont(new Font("Arial", Font.BOLD, 30));
		lblAge.setForeground(Color.RED);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		Container c = getContentPane();
		c.setLayout(new GridBagLayout());

		// first row
		c.add(new JLabel("Date of Birth :"), gbc);

		c.add(tfDob, gbc);

		c.add(new JLabel("(yyyymmdd)"), gbc);

		// Second row
		gbc.gridx = 1;
		gbc.gridy = 1;
		c.add(btnCalculate, gbc);

		// Third row
		gbc.gridx = 1;
		gbc.gridy = 2;

		c.add(lblAge, gbc);

		btnCalculate.addActionListener(e -> calculateAge());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void calculateAge() {

		if (!Pattern.matches("^\\d{8}$", tfDob.getText())) {
			JOptionPane.showMessageDialog(this, "Sorry! Invalid Date of Birth!", "Error", JOptionPane.ERROR_MESSAGE);
			lblAge.setText("");
			return;
		}

		// split and create a date
		String year = tfDob.getText().substring(0, 4);
		String month = tfDob.getText().substring(4, 6);
		String day = tfDob.getText().substring(6, 8);

		try {
			LocalDate dob = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			LocalDate now = LocalDate.now();

			Period p = Period.between(dob, now);
			lblAge.setText(String.valueOf(p.getYears()));

		} catch (Exception ex) {
			lblAge.setText("");
			JOptionPane.showMessageDialog(this, "Sorry! Invalid Date of Birth!", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void main(String[] args) {
		AgeCalculator f = new AgeCalculator();
		f.setSize(400, 200);
		f.setVisible(true);

	}

}
