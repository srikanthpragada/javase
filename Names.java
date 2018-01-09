// Swing App to manipulate names.txt

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Names extends JFrame {

	DefaultListModel<String> data;
	JList<String> lstNames;
	JButton btnAdd, btnRemove, btnSave;

	public Names() {
		super("List Demo");
		data = new DefaultListModel<String>(); // mutable list data model
		loadNames();
		lstNames = new JList<String>(data);

		btnAdd = new JButton("Add");
		btnRemove = new JButton("Remove");
		btnSave = new JButton("Save");

		Container c = getContentPane();
		JScrollPane jsp = new JScrollPane(lstNames, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		c.add(jsp, "Center");

		JPanel p = new JPanel();
		p.add(btnAdd);
		p.add(btnRemove);
		p.add(btnSave);

		c.add(p, BorderLayout.PAGE_END);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);

		btnAdd.addActionListener(e -> addName());
		btnRemove.addActionListener(e -> removeNames());
		btnSave.addActionListener(e -> saveNames());

	}

	public void loadNames() {
		try {
			Path path = Paths.get("f:\\classroom\\names.txt");
			Files.lines(path).forEach(line -> data.addElement(line));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void saveNames() {
		try {
			Path path = Paths.get("f:\\classroom\\names.txt");
			BufferedWriter bw = Files.newBufferedWriter(path);
			Enumeration<String> names = data.elements();
			while (names.hasMoreElements())
				bw.write(names.nextElement() + "\n");
			bw.close();
			JOptionPane.showMessageDialog(this, "Saved Succesfully!", "Status", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void addName() {
		String name = JOptionPane.showInputDialog(this, "Enter a name:", "Add", JOptionPane.PLAIN_MESSAGE);
		if (name != null) {
			data.addElement(name);
		}

	}

	public void removeNames() {
		int res = JOptionPane.showConfirmDialog(this, "Do you want to delete selected items?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (res == JOptionPane.YES_OPTION) {
			lstNames.getSelectedValuesList().forEach(name -> data.removeElement(name));
		}

	}

	public static void main(String args[]) {
		new Names().setVisible(true);
	}
}
