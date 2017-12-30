// Displays employees for the selected department 
package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class EmployeesByDept extends JFrame {

	JComboBox<String> cmbDepartments;
	DefaultComboBoxModel<String> model;
	JTextArea taEmployees;
	JButton btnRefresh;
	TreeMap<String, LinkedHashSet<String>> employees = new TreeMap<>();

	public EmployeesByDept() {
		super("Employees By Department");
		
		model = new DefaultComboBoxModel<>();
		loadData();
		cmbDepartments = new JComboBox<>(model);
		
		cmbDepartments.addItemListener((e) -> showEmployees());
		taEmployees = new JTextArea();
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener( (e) ->  loadData());

		JPanel tp = new JPanel();
		tp.add(new JLabel("Select Department"));
		tp.add(cmbDepartments);
		tp.add(btnRefresh);

		Container c = getContentPane();
		c.add(tp, BorderLayout.PAGE_START);

		c.add(taEmployees); // center

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);

	}

	private void loadData() {
		try {
			employees.clear();
			Path file = Paths.get("f:\\classroom\\dec6\\employees.txt");
			Files.lines(file).forEach(line -> processLine(line));

			// fill combobox model
			model.removeAllElements();
			for (String dname : employees.keySet())
				model.addElement(dname);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void showEmployees() {
        
		// find out selected department
		Object dept = cmbDepartments.getSelectedItem();
		
		if ( dept == null)
			return;

		taEmployees.setText("");
		for (String emp : employees.get(dept.toString()))
			taEmployees.append(emp + "\n");
	}

	public void processLine(String line) {
		String parts[] = line.split(",");

		if (parts.length < 2)
			return;

		String emp = parts[0];
		String dept = parts[1];

		if (employees.containsKey(dept))
			employees.get(dept).add(emp);
		else {
			LinkedHashSet<String> emps = new LinkedHashSet<>();
			emps.add(emp);
			employees.put(dept, emps);
		}

	}

	public static void main(String[] args) {
		new EmployeesByDept();

	}
}

employees.txt
=============
Mike,EDP
Jason,Sales
Steve,Sales
Scott,EDP
Larry,HR
Belinda,HR
Bill,HR
Belinda,EDP
Bill,Sales
Herbert,Sales
James,EDP


