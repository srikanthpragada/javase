import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ManageNames extends JFrame {
	DefaultListModel<String> data;
	JList<String> lst;
	JButton btnAdd, btnRemove, btnSave, btnReload;
	private final String FILENAME = "e:\\classroom\\names.txt"; 

	public void loadNames() {
		// load data from e:\classroom\names.txt
		try {
			Path file = Paths.get(FILENAME);
			data.clear(); // remove all items
			Files.lines(file).forEach(line -> data.addElement(line));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void saveNames() {
		// load data from e:\classroom\names.txt
		try {
			Path file = Paths.get(FILENAME);
			BufferedWriter bw = Files.newBufferedWriter(file);
			Enumeration<String> e = data.elements();
			while(e.hasMoreElements()) {
				bw.write(e.nextElement() + "\n");
			}
			bw.close(); 
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public ManageNames() {
		super("List Demo");
		data = new DefaultListModel<String>(); // mutable list data model
		loadNames();
		lst = new JList<String>(data);
		btnAdd = new JButton("Add");
		btnRemove = new JButton("Remove");
		btnSave = new JButton("Save");
		btnReload = new JButton("Reload");
		Container c = getContentPane();
		JScrollPane jsp = new JScrollPane(lst, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		c.add(jsp, "Center");

		JPanel p = new JPanel();
		p.add(btnAdd);
		p.add(btnRemove);
		p.add(btnSave);
		p.add(btnReload);

		c.add(p, BorderLayout.PAGE_END);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);

		btnAdd.addActionListener(evt -> {
			String name = JOptionPane.showInputDialog(this, "Enter a name:", "Add", JOptionPane.PLAIN_MESSAGE);
			if (name != null) {
				data.addElement(name);
			}
		});

		btnRemove.addActionListener(evt -> {
			List<String> items = lst.getSelectedValuesList();
			if (items.size() == 0)
				return;
			int res = JOptionPane.showConfirmDialog(this, "Do you want to delete selected names?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (res == JOptionPane.YES_OPTION) {
				lst.getSelectedValuesList().forEach(name -> data.removeElement(name));
			}
		});
		
		btnSave.addActionListener( evt -> saveNames());
		btnReload.addActionListener( evt -> loadNames());
	}

	public static void main(String args[]) {
		new ManageNames().setVisible(true);
	}
}
