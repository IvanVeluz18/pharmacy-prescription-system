package infoman;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Patient extends JFrame implements ActionListener{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		JFrame frame = new JFrame("Patient");
		
		DefaultTableModel model = new DefaultTableModel();
		
		JTable table = new JTable();
		
		JLabel lblID = new JLabel("Patient ID");
		JLabel lblName = new JLabel("Patient Name");
		JLabel lblBD = new JLabel("Birthdate");
		JLabel lblSex = new JLabel("Sex");
		JLabel lblAdd = new JLabel("Address");
		JLabel lblNo = new JLabel("Contact No.");
		JLabel lblMedAll = new JLabel("Medicine Allergies");

		JTextField textFieldID = new JTextField();
		JTextField textFieldName = new JTextField();
		JTextField textFieldBD = new JTextField();
		JTextField textFieldSex = new JTextField();
		JTextField textFieldAdd = new JTextField();
		JTextField textFieldNo = new JTextField();
		JTextField textFieldMedAll = new JTextField();
		
		JButton btnAdd = new JButton("Add");
		JButton btnNext	= new JButton("Next");
		
		Font fLabel = new Font("Arial Rounded MT Bold", Font.PLAIN, 20);
		Font fText = new Font("Arial Rounded MT Bold", Font.PLAIN, 17);
		
		Connection con = Data_Connection.getConnection();
		PreparedStatement pst;
		ResultSet rs;	
		
	public Patient() {
		initComponents();
		Patient();
	}
	
	public void Patient() {
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient", "root", "");
			String sql = "SELECT * FROM patient";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	public void initComponents() {
		Object[] columns = {"Patient ID", "Patient Name", "Birthdate", "Sex", "Address", "Contact No.", "Medicine Allergies"};
	
		frame.getContentPane().setBackground(new Color(136,205,246));
		frame.setBounds(100,100,1000,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setBackground(new Color(136,205,246));
		table.setForeground(new Color(2,68,107));
		table.setSelectionBackground(Color.gray);
		table.setGridColor(new Color(2,68,107));
		table.setSelectionForeground(new Color(136,205,246));
		table.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		table.setRowHeight(20);
		table.setAutoCreateRowSorter(true);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setForeground(Color.RED);
		pane.setBackground(Color.WHITE);
		pane.setBounds(10,10,966,349);
		frame.getContentPane().add(pane);
		
		lblID.setFont(fLabel);
		lblID.setBounds(10, 386, 105, 24);
		lblID.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblID);
		
		lblName.setFont(fLabel);
		lblName.setBounds(10, 421, 132, 24);
		lblName.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblName);
		
		lblBD.setFont(fLabel);
		lblBD.setBounds(10, 456, 105, 24);
		lblBD.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblBD);
		
		lblSex.setFont(fLabel);
		lblSex.setBounds(10, 491, 105, 24);
		lblSex.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblSex);
		
		lblAdd.setFont(fLabel);
		lblAdd.setBounds(475, 386, 105, 24);
		lblAdd.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblAdd);
		
		lblNo.setFont(fLabel);
		lblNo.setBounds(474, 421, 116, 24);
		lblNo.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblNo);
		
		lblMedAll.setFont(fLabel);
		lblMedAll.setBounds(475, 456, 180, 24);
		lblMedAll.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblMedAll);
		
		textFieldID.setFont(fText);
		textFieldID.setBounds(168, 386, 286, 24);
		frame.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldName.setFont(fText);
		textFieldName.setBounds(168, 421, 286, 24);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldBD.setFont(fText);
		textFieldBD.setBounds(168, 456, 286, 24);
		frame.getContentPane().add(textFieldBD);
		textFieldBD.setColumns(10);
		
		textFieldSex.setFont(fText);
		textFieldSex.setBounds(168, 491, 286, 24);
		frame.getContentPane().add(textFieldSex);
		textFieldSex.setColumns(10);
		
		textFieldAdd.setFont(fText);
		textFieldAdd.setBounds(690, 386, 286, 24);
		frame.getContentPane().add(textFieldAdd);
		textFieldAdd.setColumns(10);
		
		textFieldNo.setFont(fText);
		textFieldNo.setBounds(690, 421, 286, 24);
		frame.getContentPane().add(textFieldNo);
		textFieldNo.setColumns(10);
		
		textFieldMedAll.setFont(fText);
		textFieldMedAll.setBounds(690, 456, 286, 24);
		frame.getContentPane().add(textFieldMedAll);
		textFieldMedAll.setColumns(10);
		
		btnAdd.setFont(fText);
		btnAdd.setBackground(new Color(2,68,107));
		btnAdd.setForeground(new Color(136,205,246));
		btnAdd.setBounds(770, 489, 98, 28);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnNext.setFont(fText);
		btnNext.setBackground(new Color(2,68,107));
		btnNext.setForeground(new Color(136,205,246));
		btnNext.setBounds(878, 489, 98, 28);
		frame.getContentPane().add(btnNext);
		btnNext.addActionListener(this);
		
		frame.setVisible(true);
	}

	@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnAdd) {
				try {
					String sql = "INSERT INTO patient (Patient_ID, Patient_Name, Birthdate, Sex, Address, Contact_No, Medicine_Allergies)" 
							+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
				
				pst = con.prepareStatement(sql);
				
				pst.setString(1, textFieldID.getText());
				pst.setString(2, textFieldName.getText());
				pst.setString(3, textFieldBD.getText());
				pst.setString(4, textFieldSex.getText());
				pst.setString(5, textFieldAdd.getText());
				pst.setString(6, textFieldNo.getText());
				pst.setString(7, textFieldMedAll.getText());
				pst.executeUpdate();
				
			} catch (SQLException | HeadlessException ex) {
				JOptionPane.showMessageDialog(null, ex);
		}
				Patient();
				
				textFieldID.setText("");
				textFieldName.setText("");
				textFieldBD.setText("");
				textFieldSex.setText("");
				textFieldAdd.setText("");
				textFieldNo.setText("");
				textFieldMedAll.setText("");
				
			}
			else {
				Doctor doc = new Doctor();
				doc.setVisible(true);
				
				frame.dispose();
			}
		
	}
}
