// Displays .java files from the given folder 

package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListJavaFilesFrame extends JFrame {
	JTextField tfDirectory;
	JButton btnGo, btnExit;
	JTextArea taFiles;

	public ListJavaFilesFrame() {
		super("List Java Files"); // Title
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// build interface
		tfDirectory = new JTextField("e:\\classroom\\java\\may14\\demo",30);
		btnGo = new JButton("Go");
		btnExit = new JButton("Exit");
		
		JPanel tp = new JPanel();  // Uses flow layout 
		tp.add(new JLabel("Directory :"));
		tp.add(tfDirectory);
		tp.add(btnGo);
		tp.add(btnExit);
	
		
		Container c = getContentPane();
		c.add(tp, BorderLayout.NORTH);
		btnGo.addActionListener( e -> processGo() );
		btnExit.addActionListener( e -> System.exit(0));
		
		taFiles = new JTextArea();
		taFiles.setFont( new Font("Verdana", Font.PLAIN, 12));
		taFiles.setEditable(false);
		JScrollPane sp = new JScrollPane(taFiles, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		c.add(sp);
	}
   
	public void processGo() {
		  try {
			  Path  dir = Paths.get( tfDirectory.getText());
			  taFiles.setText("");
			  Files.walk(dir)
			       .filter( p -> p.toString().endsWith(".java"))
			       .forEach( p -> taFiles.append( p.toString() + "\n"));
		  }
		  catch(Exception ex) {
			  taFiles.setText("Error : " + ex.getMessage());
		  }
	}
	public static void main(String[] args) {
		ListJavaFilesFrame f = new ListJavaFilesFrame();
		f.setSize(600, 300);
		f.setVisible(true);
	}
}
