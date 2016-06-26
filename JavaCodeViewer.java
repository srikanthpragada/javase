import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class JavaCodeViewer extends JFrame {
	private String dir = "c:\\jdk8\\may6";
	private JList lstFiles;
	private JTextArea taContents;
	private DefaultListModel files;
	private JToolBar toolBar;
	private JButton  btnChange;

	public JavaCodeViewer() {
		super("Java Code Viewer");
		buildUI();
	}

	public void buildUI() {

		taContents = new JTextArea();
		files = new DefaultListModel();
		loadFiles();
		lstFiles = new JList(files);
		lstFiles.setBackground(Color.lightGray);
		lstFiles.addListSelectionListener(e -> showFile());

		toolBar = new JToolBar();
        btnChange = new JButton("Change Directory");
        btnChange.addActionListener( e -> changeDir());
        toolBar.add(btnChange);
        
        
		Container c = getContentPane();
		c.add(lstFiles, BorderLayout.LINE_START);
		c.add(taContents);
		c.add(toolBar, BorderLayout.PAGE_START);
	}
	
	public void changeDir() {
	   String input = JOptionPane.showInputDialog(this,"Enter Directory Name", "Directory", JOptionPane.PLAIN_MESSAGE);
	   if ( input != null)
	   {
		   dir = input;
		   loadFiles();
		   taContents.setText("");
	   }
	}

	public void showFile() {
		if ( lstFiles.getSelectedIndex() < 0 )
			return; 
		taContents.setText("");
		try {
			Path p = Paths.get(dir + "\\" + lstFiles.getSelectedValue());
			Files.lines(p).forEach( line -> taContents.append(line + "\n"));
		} catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void loadFiles() {
		files.clear();
		File fileDir = new File(dir);
		for (File f : fileDir.listFiles()) {
			if (f.getName().endsWith(".java"))
				files.addElement(f.getName());

		}
	}

	public static void main(String[] args) {

		JavaCodeViewer f = new JavaCodeViewer();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 400);
		f.setVisible(true);

	}

}
