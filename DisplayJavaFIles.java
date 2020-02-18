// Displays list of java file from the given folder.
// Allows user to see the contents of the file by double clicking on the filename in listbox.
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DisplayJavaPrograms extends JFrame {
	private JTextField tfDirectory;
	private JList lstFiles;
	private JButton btnGo;
	private DefaultListModel<String> files;

	class ShowFileContent extends JFrame {
		private JTextArea taContent;

		public ShowFileContent(String filename) {
			super(filename);
			StringBuffer content = new StringBuffer();
			try {
				Path p = Paths.get(filename);
				Files.lines(p).forEach(line -> content.append(line + "\n"));
				taContent = new JTextArea(content.toString());
				taContent.setEditable(false);
				taContent.setFont(new Font("consolas", Font.PLAIN, 12));
				JScrollPane sp = new JScrollPane(taContent, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				getContentPane().add(sp);
				setSize(500, 300);
				setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage(), // Message
						"Error", // Title
						JOptionPane.ERROR_MESSAGE); // ICON
			}
		}
	}

	public DisplayJavaPrograms() {
		super("Java Programs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create UI
		tfDirectory = new JTextField(30);
		tfDirectory.setText("e:\\classroom\\java\\jan7");
		btnGo = new JButton("Go");
		files = new DefaultListModel<>();
		lstFiles = new JList<String>(files);

		// Place components in Frame
		JPanel p = new JPanel();
		p.add(new JLabel("Directory:"));
		p.add(tfDirectory);
		p.add(btnGo);

		Container c = getContentPane();
		c.add(p, BorderLayout.PAGE_START);
		JScrollPane sp = new JScrollPane(lstFiles, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		c.add(sp); // Center

		// Even Handling
		btnGo.addActionListener(e -> getFiles());
		lstFiles.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					String filename = files.get(lstFiles.getSelectedIndex());
					ShowFileContent sfc = new ShowFileContent(filename);
				}
			}
		});

		setSize(600, 400);
		setVisible(true);
	}

	public void getFiles() {
		Path dir = Paths.get(tfDirectory.getText());
		files.removeAllElements(); // Clear files
		try {
			Files.walk(dir).filter(p -> p.toString().endsWith(".java")) // Select .java files
					.forEach(p -> files.addElement(p.toAbsolutePath().toString()));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error : " + ex.getMessage(), // Message
					"Error", // Title
					JOptionPane.ERROR_MESSAGE); // ICON
		}

	}

	public static void main(String[] args) {
		new DisplayJavaPrograms();
	}

}
