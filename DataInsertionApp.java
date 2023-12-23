import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataInsertionApp extends JFrame //Extend jframe in class
{
	//declaring required component
    JTextField ID;
    JTextField Name;
	JTextField Address;
    JTextField Salary;
    JButton insertButton;
	JButton deleteButton;
    DefaultTableModel tableModel;
    JTable dataTable;

    

    private void initComponents() 
	{
        ID = new JTextField(15);
        Name = new JTextField(15);
		Address = new JTextField(15);
		Salary = new JTextField(15);
        insertButton = new JButton("Insert");
		deleteButton = new JButton("Delete");
        tableModel = new DefaultTableModel();
        dataTable = new JTable(tableModel);

        // Add columns to the table model
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
		tableModel.addColumn("Address");
        tableModel.addColumn("Salary");
    }


    private void layoutComponents() 
	{
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(ID);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(Name);
		inputPanel.add(new JLabel("Address:"));
        inputPanel.add(Address);
        inputPanel.add(new JLabel("Salary:"));
        inputPanel.add(Salary);
		inputPanel.add(insertButton);
		inputPanel.add(deleteButton);

        add(inputPanel);
        add(new JScrollPane(dataTable));
    }


    private void attachListeners() 
	{
        insertButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
			{
                insertData();
            }
        });
		deleteButton.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
			{
                deleteData();
            }
        });
    }

    private void insertData() 
	{
        String id = ID.getText();
        String name = Name.getText();
		String address=Address.getText();
		String salary=Salary.getText();
        // Validate input
        if (id.isEmpty()||name.isEmpty()||address.isEmpty()||salary.isEmpty()) 
		{
            JOptionPane.showMessageDialog(this, "Please enter both first name and last name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
		else
		{
		// Add data to the table model
        Object[] rowData = {id, name,address,salary};
        tableModel.addRow(rowData);
		
		JOptionPane.showMessageDialog(this, "Add data successfully");
        // Clear text fields
        ID.setText("");
        Name.setText("");
		Address.setText("");
		Salary.setText("");
		}
    }
	
	
	//clear textfield
	public void deleteData()
	{
		ID.setText("");
        Name.setText("");
		Address.setText("");
		Salary.setText("");
	}
	
	
	public DataInsertionApp() //class constructor
	{
        setTitle("Data Insertion App");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        initComponents();
        layoutComponents();
        attachListeners();
    }

    public static void main(String[] args) 
	{
        new DataInsertionApp().setVisible(true);
    }
}
