import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.Period;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AgeCalculator2 extends JFrame {
	JComboBox<String> cmbYears, cmbMonths, cmbDays;
	JButton btnCalculate;
	JLabel lblAge;

	public AgeCalculator2() {
		super("Age Calculator 2.0");
		
		// create and populate comboboxes
		Vector<String> years = new Vector<>();
		
		int currentYear = LocalDate.now().getYear();
		for(int y = currentYear ; y >= 1970 ; y --)
			 years.add(String.valueOf(y));
		
		cmbYears = new JComboBox<String>(years);
		
		
		// Months
		Vector<String> months = new Vector<>();
		for(int m =1;  m <= 12; m ++)
			 months.add(String.valueOf(m));
		
		cmbMonths = new JComboBox<String>(months);
		
		// Days
		Vector<String> days = new Vector<>();
		for(int d =1;  d <= 31; d ++)
			 days.add(String.valueOf(d));
		
		cmbDays = new JComboBox<String>(days);
		
		btnCalculate = new JButton("Calculate");
		lblAge = new JLabel("");
		lblAge.setHorizontalAlignment(JLabel.CENTER);
		lblAge.setFont(new Font("Arial", Font.BOLD, 20));
		lblAge.setForeground(Color.RED);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		Container c = getContentPane();
		c.setLayout(new GridBagLayout());

		// first row
		c.add(new JLabel("Date of Birth :"), gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		c.add(cmbYears, gbc);
		c.add(cmbMonths, gbc);
		c.add(cmbDays, gbc);
		
		// Second row
		gbc.gridx = 1;
		gbc.gridy = 1;
		c.add(btnCalculate, gbc);

		// Third row
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 4;

		c.add(lblAge, gbc);

		btnCalculate.addActionListener(e -> calculateAge());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void calculateAge() {
		// split and create a date
		String year = cmbYears.getSelectedItem().toString();
		String month = cmbMonths.getSelectedItem().toString();
		String day = cmbDays.getSelectedItem().toString();

		try {
			LocalDate dob = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			LocalDate now = LocalDate.now();

			Period p = Period.between(dob, now);
			String result = String.format("%d Years %d Months %d Days", p.getYears(),p.getMonths(),p.getDays());
			lblAge.setText(result);

		} catch (Exception ex) {
			lblAge.setText("");
			JOptionPane.showMessageDialog(this, "Sorry! Invalid Date of Birth!", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		AgeCalculator2 f = new AgeCalculator2();
		f.setSize(400, 200);
		f.setVisible(true);
	}

}
