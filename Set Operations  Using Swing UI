package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SetOperations extends JFrame {
	JButton btnBrowse1, btnBrowse2;
	JButton btnUnion, btnIntersect, btnMinus;
	JTextField txtFile1, txtFile2;
	JTextArea txtResult;

	public SetOperations() {
		super("Set Operations");
		// create components
		btnBrowse1 = new JButton("...");
		btnBrowse1.addActionListener(e -> {
			JFileChooser jfc = new JFileChooser();
			int status = jfc.showOpenDialog(this);
			if (status == JFileChooser.APPROVE_OPTION) {
				txtFile1.setText(jfc.getSelectedFile().getAbsolutePath());
			}
		});

		btnBrowse2 = new JButton("...");
		btnBrowse2.addActionListener(e -> {
			JFileChooser jfc = new JFileChooser();
			int status = jfc.showOpenDialog(this);
			if (status == JFileChooser.APPROVE_OPTION) {
				txtFile2.setText(jfc.getSelectedFile().getAbsolutePath());
			}
		});

		btnUnion = new JButton("Union");
		btnUnion.addActionListener(e -> union());

		btnIntersect = new JButton("Intersect");
		btnIntersect.addActionListener(e -> intersect());
		btnMinus = new JButton("Minus");
		txtFile1 = new JTextField(30);
		txtFile2 = new JTextField(30);
		txtResult = new JTextArea();
		// build UI
		JPanel tp = new JPanel();
		GridLayout gl = new GridLayout(3, 1);
		tp.setLayout(gl);

		// first row
		JPanel p1 = new JPanel();
		p1.add(new JLabel("File1"));
		p1.add(txtFile1);
		p1.add(btnBrowse1);
		tp.add(p1);

		// Second row
		JPanel p2 = new JPanel();
		p2.add(new JLabel("File2"));
		p2.add(txtFile2);
		p2.add(btnBrowse2);
		tp.add(p2);

		// Second row
		JPanel p3 = new JPanel();
		p3.add(btnUnion);
		p3.add(btnIntersect);
		p3.add(btnMinus);
		tp.add(p3);

		Container c = getContentPane();
		c.add(tp, BorderLayout.PAGE_START);

		JScrollPane sp = new JScrollPane(txtResult, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		c.add(sp); // Center

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void union() {
		try {
			// open first file and read all lines into list
			List<String> lines = Files.readAllLines(Paths.get(txtFile1.getText()));
			LinkedHashSet<String> result = new LinkedHashSet<>(lines);
			result.addAll(Files.readAllLines(Paths.get(txtFile2.getText())));
			// display result

			txtResult.setText(""); // empty
			for (String line : result)
				txtResult.append(line + "\n");

		} catch (Exception ex) {
			showError(ex);
		}

	}

	public void showError(Exception ex) {
		JOptionPane.showMessageDialog(this, "Error during opening file!", "Error", JOptionPane.ERROR_MESSAGE);
		txtFile1.grabFocus();
	}

	public void intersect() {
		try {
			// open first file and read all lines into list
			List<String> lines1 = Files.readAllLines(Paths.get(txtFile1.getText()));
			List<String> lines2 = Files.readAllLines(Paths.get(txtFile2.getText()));
			LinkedHashSet<String> result = new LinkedHashSet<>();

			for (String line : lines2)
				if (lines1.contains(line))
					result.add(line);

			// display result
			txtResult.setText(""); // empty
			for (String line : result)
				txtResult.append(line + "\n");

		} catch (Exception ex) {
			showError(ex);
		}

	}

	public static void main(String[] args) {
		SetOperations f = new SetOperations();
		f.setSize(600, 400);
		f.setVisible(true);

	}

}
