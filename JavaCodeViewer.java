package demo;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class JavaCodeViewer extends JFrame {
	private String dir = "/Users/srikanthpragada/Documents/workspace/demo/src/demo";
	private JList<String> lstFiles;
	private JTextArea taContents;
	private DefaultListModel<String> files;
	private JToolBar toolBar;
	private JButton  btnChange, btnExit;
	private JCheckBox cbLineNumbers;
	private String title = "Java Code Viewer";

	public JavaCodeViewer() {
 		buildUI();
		this.setTitle(title + " - " + dir);
	}

	public void buildUI() {

		taContents = new JTextArea();
		files = new DefaultListModel<String>();
		loadFiles();
		lstFiles = new JList<String>(files); 
		lstFiles.setSize( new Dimension(150,0));
		lstFiles.setBackground(Color.lightGray);
		lstFiles.addListSelectionListener(e -> showFile());

		toolBar = new JToolBar();
        btnChange = new JButton( getImage("changedir.png"));
        btnChange.setToolTipText("Change Directory");
        btnChange.addActionListener( e -> changeDir());
        toolBar.add(btnChange);
        
        
        btnExit = new JButton( getImage("exit.png"));
        
        btnExit.setToolTipText("Exit Application");
        btnExit.addActionListener( e -> System.exit(0));
        toolBar.add(btnExit);
        
        cbLineNumbers = new JCheckBox("Line Numbers");
        cbLineNumbers.addItemListener(  e -> showFile());
        toolBar.add(cbLineNumbers);
        
        
        toolBar.setPreferredSize( new Dimension(0,40));
        
        
        
		Container c = getContentPane();
		JScrollPane spFiles = new JScrollPane(lstFiles, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		spFiles.setPreferredSize(new Dimension(150,0));
		c.add(spFiles, BorderLayout.LINE_START);
		
		JScrollPane sp = new JScrollPane(taContents, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		c.add(sp);
		c.add(toolBar, BorderLayout.PAGE_START);
	}
	
	public void changeDir() {
	   JFileChooser chooser = new JFileChooser(); 
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Select Folder");
	    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	    int result = chooser.showOpenDialog(this);
	    if ( result == JFileChooser.APPROVE_OPTION)
	    {
	       
		   dir = chooser.getSelectedFile().getAbsolutePath();
		   System.out.println(dir);
		   loadFiles();
		   setTitle(title + "  - " + dir);
		   taContents.setText("");
	   }
	}

	
	public ImageIcon getImage(String filename) {
		try {
			return new ImageIcon(this.getClass().getResource(filename));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
	public void showFile() {
		if ( lstFiles.getSelectedIndex() < 0 )
			return; 
		
		taContents.setText("");
		
		try {
			Path p = Paths.get(dir + File.separator + lstFiles.getSelectedValue());
		    if ( cbLineNumbers.isSelected()) {
		    	 int lineno=1;
			     Stream<String> lines = Files.lines(p);
			     
			     for(Object line : lines.toArray())		     {
			    	 taContents.append(String.format("%4d : %s\n", lineno,line));
			    	 lineno ++;
			     }
		    }
		    else
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
 
