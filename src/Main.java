import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JMenuBar;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.border.BevelBorder;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import java.awt.Button;
import java.awt.Panel;


public class Main {

	private JFrame frame;
	File myFile;
	DataStorage myData = new DataStorage();

	/**
	 * Launch the application.
	 */
	public static   List<Staff> staffList = new ArrayList<>();
	public static   List<Customer> customerList = new ArrayList<>();
	public  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	public static Booking lastBooking;
	private JTextField textFieldAddRDate;
	private JTextField textFieldAddCard;
	private JTextField textFieldAddMSal;
	private JTextField textFieldAddEndDate;
	private JTextField textFieldAddYSal;
	DefaultListModel<String> model;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 * @throws NoSuchProviderException 
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException 
	 * @throws ClassNotFoundException 
	 */
	public Main() throws NoSuchAlgorithmException, NoSuchProviderException, IOException, ClassNotFoundException {
	
		initialize();
		
		
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 766, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RestManApp");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(289, 11, 145, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 33, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("File");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Load Database");      //Loading all database to the arraylist
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						ResultSet rs=myData.readData("SELECT id,name,date_of_birth FROM person");
						while (rs.next()) {
							Customer temp = new Customer();
							 temp.setId(rs.getInt("id"));
							 temp.setName(rs.getString("name"));
							 temp.setDateOfBirth(rs.getString("date_of_birth") );
							customerList.add(temp);
							                    
							}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						checkDataModificated();
					} catch (HeadlessException | NoSuchAlgorithmException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				
		});
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Save");            //Save all changes to the Database
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Customer customer :customerList){ //End of array
	            	
	            	try {
						myData.writeData(customer);
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}         //write all array list     
	            	finally {
	            		try {
							secureData();
						} catch (NoSuchAlgorithmException | NoSuchProviderException | ClassNotFoundException
								| IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	            	}
					
				}
				}
				
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(40, 61, 613, 357);
		frame.getContentPane().add(tabbedPane);
		
		


		
		JPanel addPanel = new JPanel();
		tabbedPane.addTab("Add", null, addPanel, null);
		addPanel.setVisible(false);
		addPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		addPanel.setLayout(null);
		
		
		DefaultListModel<String> jListModel = new DefaultListModel<>();
		
		
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(22, 47, 11, 14);
		addPanel.add(lblNewLabel_1);
		JList<String> jlist = new JList<>( jListModel );
		jlist.setBounds(266, 12, 0, 0);
		addPanel.add(jlist);
		
		TextField textFieldAddID = new TextField();
		textFieldAddID.setBounds(63, 39, 84, 22);
		addPanel.add(textFieldAddID);
		
		Label label = new Label("Name");
		label.setBounds(10, 88, 41, 22);
		addPanel.add(label);
		
		TextField textFieldAddName = new TextField();
		textFieldAddName.setBounds(63, 88, 84, 22);
		addPanel.add(textFieldAddName);
		
		TextField textFieldAddGender = new TextField();
		textFieldAddGender.setBounds(63, 131, 84, 22);
		addPanel.add(textFieldAddGender);
		
		TextField textFieldAddBDate = new TextField();
		textFieldAddBDate.setBounds(63, 176, 84, 22);
		addPanel.add(textFieldAddBDate);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setBounds(5, 139, 46, 14);
		addPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Birth Date");
		lblNewLabel_3.setBounds(5, 184, 52, 14);
		addPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Regis Date");
		lblNewLabel_4.setBounds(199, 27, 58, 14);
		addPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("C.Card D.");
		lblNewLabel_5.setBounds(199, 66, 58, 14);
		addPanel.add(lblNewLabel_5);
		
		textFieldAddRDate = new JTextField();
		textFieldAddRDate.setBounds(279, 24, 86, 20);
		addPanel.add(textFieldAddRDate);
		textFieldAddRDate.setColumns(10);
		
		textFieldAddCard = new JTextField();
		textFieldAddCard.setBounds(279, 63, 86, 20);
		addPanel.add(textFieldAddCard);
		textFieldAddCard.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add Customer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerList.add(new Customer( 
						Integer.parseInt(textFieldAddID.getText() ),
						textFieldAddName.getText(),
						textFieldAddGender.getText().charAt(0),
						textFieldAddBDate.getText(),
						textFieldAddRDate.getText(),
						textFieldAddCard.getText() ) );
				
				textFieldAddID.setText("");
				textFieldAddName.setText("");
				textFieldAddGender.setText("");
				textFieldAddBDate.setText("");
				textFieldAddRDate.setText("");
				textFieldAddCard.setText("");
			}
		});
		btnNewButton_1.setBounds(395, 43, 119, 23);
		addPanel.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("M. Salary");
		lblNewLabel_6.setBounds(199, 131, 46, 14);
		addPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("E.End Date");
		lblNewLabel_7.setBounds(199, 168, 67, 14);
		addPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Y. Salary");
		lblNewLabel_8.setBounds(199, 235, 46, 14);
		addPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("R. From");
		lblNewLabel_9.setBounds(199, 273, 46, 14);
		addPanel.add(lblNewLabel_9);
		
		textFieldAddMSal = new JTextField();
		textFieldAddMSal.setBounds(279, 131, 86, 20);
		addPanel.add(textFieldAddMSal);
		textFieldAddMSal.setColumns(10);
		
		textFieldAddEndDate = new JTextField();
		textFieldAddEndDate.setBounds(279, 165, 86, 20);
		addPanel.add(textFieldAddEndDate);
		textFieldAddEndDate.setColumns(10);
		
		textFieldAddYSal = new JTextField();
		textFieldAddYSal.setBounds(279, 232, 86, 20);
		addPanel.add(textFieldAddYSal);
		textFieldAddYSal.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Add Junior");
		btnNewButton_2.setBounds(395, 130, 119, 23);
		addPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add Senior");
		btnNewButton_3.setBounds(395, 245, 119, 23);
		addPanel.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Delete", null, panel, null);
		panel.setLayout(null);
		
		model = new DefaultListModel<>();
		JList<String> customerJlist = new JList<>( model );	
		customerJlist.setBounds(10, 53, 173, 266);
		customerJlist.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		for ( int i = 0; i < customerList.size(); i++ ){
			  model.addElement( customerList.get(i).getName() );
			}
		panel.add(customerJlist);
		
		
		JLabel lblNewLabel_10 = new JLabel("Customers");
		lblNewLabel_10.setBounds(57, 11, 60, 24);
		panel.add(lblNewLabel_10);
		
		model = new DefaultListModel<>();
		JList<String>staffJlist = new JList<>( model );
		staffJlist.setBounds(301, 53, 180, 266);
		staffJlist.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		for ( int i = 0; i < staffList.size(); i++ ){
			  model.addElement( staffList.get(i).getName() );
			}
		panel.add(staffJlist);
		
		Label label_1 = new Label("Staffs");
		label_1.setBounds(369, 13, 62, 22);
		panel.add(label_1);
		
		Panel panel_1 = new Panel();
		tabbedPane.addTab("Order", null, panel_1, null);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(74, 37, 96, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("ID");
		lblNewLabel_11.setBounds(8, 40, 46, 14);
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Date");
		lblNewLabel_12.setBounds(8, 77, 46, 14);
		panel_1.add(lblNewLabel_12);
		
		textField_1 = new JTextField();
		textField_1.setBounds(74, 68, 96, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Details");
		lblNewLabel_13.setBounds(10, 119, 46, 14);
		panel_1.add(lblNewLabel_13);
		
		textField_2 = new JTextField();
		textField_2.setBounds(74, 116, 96, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		Label label_2 = new Label("Extra Notes");
		label_2.setBounds(8, 165, 62, 22);
		panel_1.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(74, 165, 96, 22);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		Label label_3 = new Label("Payment Type");
		label_3.setBounds(242, 37, 73, 22);
		panel_1.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(361, 37, 96, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Table No");
		lblNewLabel_14.setBounds(254, 142, 46, 14);
		panel_1.add(lblNewLabel_14);
		
		TextField textField_5 = new TextField();
		textField_5.setBounds(361, 134, 96, 22);
		panel_1.add(textField_5);
		
		
		
		
		JButton btnNewButton = new JButton("DeleteCus");
		btnNewButton.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				customerList.removeIf(n -> (n.getName().equals(customerJlist.getSelectedValue())) );  //delete customer by name
			}
			
		});
		btnNewButton.setBounds(189, 160, 81, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("DeleteStaff");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				staffList.removeIf(n -> (n.getName().equals(staffJlist.getSelectedValue())) ); //delete staff by name
			}
		});
		btnNewButton_4.setBounds(493, 159, 87, 24);
		panel.add(btnNewButton_4);

		
	}
	@SuppressWarnings("unlikely-arg-type")
	protected void checkDataModificated() throws HeadlessException, IOException, NoSuchAlgorithmException {
	    @SuppressWarnings("resource")
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream("security.txt")));

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		for(Customer customer :customerList){
			oos.writeObject(customer);
			oos.flush();
		}
		byte buffer[]= baos.toByteArray();
		//choose algorithm
		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		//make buffer empty
		algorithm.reset();
		//Fill the digest's buffer with data to compute a message digest from
		algorithm.update(buffer);
		//generate digest
		byte digest[] = algorithm.digest();
		StringBuffer hexString=new StringBuffer();
		for(int i = 0; i<digest.length ; i++) {
			hexString.append(Integer.toHexString(0xFF & digest[i]));
			hexString.append(" ");
		}
		
		
		if(hexString.equals(in.readAllBytes()))
			
		JOptionPane.showMessageDialog(null,"Your Data has updated");
	}

	void secureData() throws NoSuchAlgorithmException, NoSuchProviderException, IOException, ClassNotFoundException {
		
		BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("security.txt"))); // security external file
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		for(Customer customer :customerList){
			oos.writeObject(customer);
			oos.flush();
		}
		byte buffer[]= baos.toByteArray();
		//choose algorithm
		MessageDigest algorithm = MessageDigest.getInstance("MD5");
		//make buffer empty
		algorithm.reset();
		//Fill the digest's buffer with data to compute a message digest from
		algorithm.update(buffer);
		//generate digest
		byte digest[] = algorithm.digest();
		StringBuffer hexString=new StringBuffer();
		for(int i = 0; i<digest.length ; i++) {
			hexString.append(Integer.toHexString(0xFF & digest[i]));
			hexString.append(" ");
		}
		bwr.write(hexString.toString());  //write contents of StringBuffer to a file
		bwr.flush();  //flush the stream
		bwr.close();   //close the stream
	
	}
}
