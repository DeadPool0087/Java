import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class DataInsertionApp extends JFrame //Extend jframe in class
{
	//declaring required component
    JTextField ID;
    JTextField Name;
	JTextField Address;
    JTextField Salary;
    JButton insertButton;
	JButton deleteButton;
	JButton save;
	JButton deletecol;
    DefaultTableModel tableModel;
    JTable dataTable;
    

    private void initComponents() 
	{
        ID = new JTextField(15);
        Name = new JTextField(15);
		Address = new JTextField(15);
		Salary = new JTextField(15);
        insertButton = new JButton("Insert");
		deleteButton = new JButton("Clear");
		save = new JButton("Save");
		deletecol = new JButton("DeleteColumn");
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
		inputPanel.add(save);
		inputPanel.add(deletecol);

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
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				savefile();
			}
		});
		deletecol.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				delcol();
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
	
	
	//delete column
	public void delcol()
	{
		
	}

	
	
	// sav file
	public void savefile()
	{
		try{
			File file=new File("C:\\Users\\abhay\\OneDrive\\Desktop\\Data.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			
			FileWriter fw=new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(dataTable.getModel()+"\n\nID |  Name  |  Address  |  Salary\n---------------------------------\n");
			for(int i=0;i<dataTable.getRowCount();i++)
			{
				for(int j=0;j<dataTable.getColumnCount();j++){
					bw.write(dataTable.getModel().getValueAt(i,j)+" | ");
				}
				bw.write("\n________________________\n");
			}
			bw.close();
			fw.close();
			JOptionPane.showMessageDialog(null,"Data Saved!!");
		}catch(Exception ex){
			ex.printStackTrace();
		}
			
	}
	
	public DataInsertionApp() //class constructor
	{
        setTitle("Data Insertion App");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.white);
        initComponents();
        layoutComponents();
        attachListeners();
    }

    public static void main(String[] args) 
	{
        new DataInsertionApp().setVisible(true);
    }
}
