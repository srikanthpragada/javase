import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradeFinder extends JFrame {
	private JButton btnFind;
	private JTextField tfMarks;
	private JLabel lblGrade;

	public void showGrade() {
		// take marks and convert that to int
		try {
			int marks = Integer.parseInt(tfMarks.getText());
			if (marks > 80)
				lblGrade.setText("Grade A");
			else if (marks > 70)
				lblGrade.setText("Grade B");
			else
				lblGrade.setText("Grade C");
		} catch (Exception ex) {
			lblGrade.setText("Sorry! Invalid marks!");
		}
	}

	public GradeFinder() {
		super("Grade Finder");
		btnFind = new JButton("Find Grade");
		// ActionListener - void actionPerformed(ActionEvent evt)
		btnFind.addActionListener(e -> showGrade() );

		lblGrade = new JLabel("Grade will be here!");
		lblGrade.setHorizontalAlignment(JLabel.CENTER);
		lblGrade.setForeground(Color.blue);

		tfMarks = new JTextField(10);
		// Layout
		JPanel p = new JPanel(); // Default layout is FlowLayout
		p.add(new JLabel("Marks :"));
		p.add(tfMarks);
		p.add(btnFind);

		Container c = getContentPane();
		c.add(p, BorderLayout.CENTER);
		c.add(lblGrade, BorderLayout.PAGE_END);

		this.setSize(300, 200);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		GradeFinder f = new GradeFinder();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
