import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WordIndex extends JFrame {
	JTextField tfFilename;
	JButton btnBrowse, btnIndex;
	JTextArea  taResult;
	TreeMap<String, TreeSet<Integer>> index = new TreeMap<>();
	int lineno;
	
	public WordIndex(){
		super("Word Index");
		tfFilename = new JTextField(20);
		btnBrowse  = new JButton("...");
		btnIndex  = new JButton("Index");
		taResult = new JTextArea();
		taResult.setFont( new Font("Courier New",Font.BOLD, 14));
		
		JPanel tp = new JPanel();
		tp.add(new JLabel("Filename :"));
		tp.add(tfFilename);
		tp.add(btnBrowse);
		tp.add(btnIndex);
		
		btnBrowse.addActionListener(e -> takeFilename());
		btnIndex.addActionListener(e -> indexFile());
		
		Container c = getContentPane();
		c.add(tp, BorderLayout.PAGE_START);
		JScrollPane sp = new JScrollPane(taResult,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		c.add(sp);
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void indexFile() {

		try{
			Path file = Paths.get(tfFilename.getText());
			index.clear();
			lineno=1;
			Files.lines(file)
		         .forEach( line -> {
		        	 String words[] = line.split("[,;. ]+");
		        	 
		        	 // place words along with line number into Map
		        	 for(String word : words)
		        	 {
		        		 if (word.length() == 0)
		        			 continue; 
		        		 
		        		 // check whether word is already present
		        		 TreeSet<Integer> linenos;
		        		 if (!index.containsKey(word))
		        		 {
		        			 linenos = new TreeSet<>();
		        			 linenos.add(lineno);
		        			 index.put(word, linenos);
		        		 }
		        		 else
		        		 {
		        		   linenos = index.get(word);
		        		   linenos.add(lineno);
		        		 }
		        	 }
		        	 lineno++;
		         });  	
			
			// Display Index
			showIndex();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(this,
					"Sorry! File cannot be opened!", 
					"Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void showIndex() {
		taResult.setText("");
		StringBuilder output = new StringBuilder();
		for(String word : index.keySet()) {
			StringBuilder line = new StringBuilder(word);
			line.append("--->");
			for(Integer lineno :  index.get(word)) 
			{
				line.append(lineno.toString() + " ");
			}
			output.append(line + "\n\r");
		}
		taResult.setText(output.toString());
	}
	public void takeFilename() {
		 JFileChooser jfc = new JFileChooser();
         int status = jfc.showOpenDialog(this); // Frame is parent
         if (status == JFileChooser.APPROVE_OPTION)
         {
             tfFilename.setText(
                 jfc.getSelectedFile().getAbsolutePath());
         }
	}

	public static void main(String[] args) {
		 WordIndex frame = new WordIndex();
		 frame.setSize(500,300);
		 frame.setVisible(true);
	}

}

