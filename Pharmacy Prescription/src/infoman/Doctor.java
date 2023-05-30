package infoman;

import java.awt.Color;
import java.awt.Dimension;
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

public class Doctor extends JFrame implements ActionListener{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		JFrame frame = new JFrame("Doctor");
		
		DefaultTableModel model = new DefaultTableModel();

		JTable table = new JTable();
		
		JLabel lblDID = new JLabel("Doctor ID");
		JLabel lblDName = new JLabel("Doctor Name");
		JLabel lblDAdd = new JLabel("Doctor Address");
		JLabel lblDNo = new JLabel("Doctor Contact No.");

		JTextField textFieldDID = new JTextField();
		JTextField textFieldDName = new JTextField();
		JTextField textFieldDAdd = new JTextField();
		JTextField textFieldDNo = new JTextField();
		
		JButton btnAdd = new JButton("Add");
		JButton btnNext	= new JButton("Next");
		JButton btnBack = new JButton("Back");
		
		Font fLabel = new Font("Arial Rounded MT Bold", Font.PLAIN, 20);
		Font fText = new Font("Arial Rounded MT Bold", Font.PLAIN, 17);
	
		Connection con = Data_Connection.getConnection();
		PreparedStatement pst;
		ResultSet rs;
		
	public Doctor() {
		initComponents();
		Doctor();
	}
	
	public void Doctor() {
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient", "root", "");
			String sql = "SELECT * FROM doctor";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	public void initComponents() {
		
		Object[] columns = {"Doctor ID", "Doctor Name", "Doctor Address", "Doctor Contact No."};
	
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
		
		lblDID.setFont(fLabel);
		lblDID.setBounds(10, 386, 105, 24);
		lblDID.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblDID);
		
		lblDName.setFont(fLabel);
		lblDName.setBounds(10, 421, 132, 24);
		lblDName.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblDName);
		
		lblDAdd.setFont(fLabel);
		lblDAdd.setBounds(10, 456, 160, 24);
		lblDAdd.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblDAdd);
		
		lblDNo.setFont(fLabel);
		lblDNo.setBounds(10, 491, 188, 24);
		lblDNo.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblDNo);
		
		textFieldDID.setFont(fText);
		textFieldDID.setBounds(211, 386, 286, 24);
		frame.getContentPane().add(textFieldDID);
		textFieldDID.setColumns(10);
		
		textFieldDName.setFont(fText);
		textFieldDName.setBounds(211, 421, 286, 24);
		frame.getContentPane().add(textFieldDName);
		textFieldDName.setColumns(10);
		
		textFieldDAdd.setFont(fText);
		textFieldDAdd.setBounds(211, 456, 286, 24);
		frame.getContentPane().add(textFieldDAdd);
		textFieldDAdd.setColumns(10);
		
		textFieldDNo.setFont(fText);
		textFieldDNo.setBounds(211, 491, 286, 24);
		frame.getContentPane().add(textFieldDNo);
		textFieldDNo.setColumns(10);
		
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

		btnBack.setFont(fText);
		btnBack.setBackground(new Color(2, 68, 107));
		btnBack.setForeground(new Color(136, 205, 246));
		btnBack.setBounds(878, 524, 98, 28);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(this);
		
		frame.setVisible(true);
	}

	@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnAdd) {
				try {
					String sql = "INSERT INTO doctor(MD_ID, MD_Name, MD_Address, MD_Contact)"
							+ "VALUES (?, ?, ?, ?)";

				pst = con.prepareStatement(sql);

				pst.setString(1, textFieldDID.getText());
				pst.setString(2, textFieldDName.getText());
				pst.setString(3, textFieldDAdd.getText());
				pst.setString(4, textFieldDNo.getText());
				pst.executeUpdate();
				
				} catch (SQLException | HeadlessException ex) {
					JOptionPane.showMessageDialog(null, ex);
			}
					Doctor();

				textFieldDID.setText("");
				textFieldDName.setText("");
				textFieldDAdd.setText("");
				textFieldDNo.setText("");
				
			}
			if(e.getSource() == btnNext) {
				Medicine med = new Medicine();
				med.setVisible(true);
				
				frame.dispose();
			}
			if(e.getSource() == btnBack) {
				Patient p = new Patient();
				p.setVisible(true);
				
				frame.dispose();
			}
	}
}
