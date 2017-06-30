import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ContactInfoFrame extends JFrame {
	JTextField tfName;
	JLabel lblInfo;
	JButton btnSearch, btnAdd;
	TreeMap<String, String> contacts;

	public void loadContactsInfo() {
		try {
			Path path = Paths.get("f:\\classroom\\contacts.txt");

			contacts = new TreeMap<>();
			Files.lines(path).forEach(line -> {
				String parts[] = line.split("-");
				if (parts.length >= 3) {
					contacts.put(parts[0].trim().toUpperCase(), parts[1] + "," + parts[2]);
				}
			});

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public ContactInfoFrame() {
		super("Contact Information");

		loadContactsInfo();

		Container c = getContentPane();
		GridBagConstraints gbc = new GridBagConstraints();
		c.setLayout(new GridBagLayout());

		gbc.insets = new Insets(2, 2, 2, 2);

		tfName = new JTextField(15);
		lblInfo = new JLabel();
		lblInfo.setHorizontalAlignment(JLabel.CENTER);
		lblInfo.setBackground(new Color(200, 200, 200));
		lblInfo.setForeground(Color.BLUE);
		lblInfo.setOpaque(true);
		lblInfo.setFont(new Font("Arial", Font.BOLD, 20));
		btnSearch = new JButton("Search");
		btnSearch.addActionListener( e ->  search() );
		
		btnAdd  = new JButton("Add Contact");
		

		c.add(new JLabel("Person Name :"), gbc);

		c.add(tfName, gbc);
		c.add(btnSearch, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		c.add(lblInfo, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth =1;
		gbc.fill = GridBagConstraints.NONE;
		c.add(btnAdd, gbc);
		
		btnAdd.addActionListener( e ->  {
			
			AddContactFrame f = new AddContactFrame();
			f.setVisible(true);
		});
		
	}

	private void search() {
	   String name = tfName.getText().toUpperCase();
       if (contacts.containsKey(name))
       {
    	   String  details = contacts.get(name);
    	   lblInfo.setText(details);
       }
       else
       {
    	   lblInfo.setText("Sorry! Name not found!");
       }
	}

	public static void main(String[] args) {
		ContactInfoFrame f = new ContactInfoFrame();
		f.setSize(400, 200);
		f.setVisible(true);
	}

}
