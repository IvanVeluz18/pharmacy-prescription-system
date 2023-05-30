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

public class Medicine extends JFrame implements ActionListener{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		JFrame frame = new JFrame("Medicine");
		
		DefaultTableModel model = new DefaultTableModel();
		
		JTable table = new JTable();

		JLabel lblPID = new JLabel("Patient ID");
		JLabel lblMed = new JLabel("Medicine");
		JLabel lblDir = new JLabel("Direction");
		JLabel lblQty = new JLabel("Quantity");
		JLabel lblDate = new JLabel("Date Prescribed");
		JLabel lblDID = new JLabel("Doctor ID");
		JTextField textFieldMed = new JTextField();
		JTextField textFieldDir = new JTextField();
		JTextField textFieldQty = new JTextField();
		JTextField textFieldDate = new JTextField();
		JTextField textFieldDID = new JTextField();
		JTextField textFieldPID = new JTextField();
		
		JButton btnAdd = new JButton("Add");
		JButton btnNext	= new JButton("Next");
		JButton btnBack = new JButton("Back");
		
		Font fLabel = new Font("Arial Rounded MT Bold", Font.PLAIN, 20);
		Font fText = new Font("Arial Rounded MT Bold", Font.PLAIN, 17);
		
		Connection con = Data_Connection.getConnection();
		PreparedStatement pst;
		ResultSet rs;
	
	public Medicine() {
		initComponents();
		Medicine();
	}
	
	public void Medicine() {
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient", "root", "");
			String sql = "SELECT * FROM medicine";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
	}
	
	public void initComponents() {
		
		Object[] columns = {"Transaction No", "Patient ID", "Medical Prescription", "Direction", "Quantity", "Date Prescribed","Doctor ID"};
	
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
		
		lblMed.setFont(fLabel);
		lblMed.setBounds(10, 386, 132, 24);
		lblMed.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblMed);
		
		lblDir.setFont(fLabel);
		lblDir.setBounds(10, 421, 105, 24);
		lblDir.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblDir);
		
		lblQty.setFont(fLabel);
		lblQty.setBounds(10, 456, 105, 24);
		lblQty.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblQty);
		
		lblDate.setFont(fLabel);
		lblDate.setBounds(10, 491, 168, 24);
		lblDate.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblDate);
		
		lblDID.setFont(fLabel);
		lblDID.setBounds(492, 386, 116, 24);
		lblDID.setForeground(new Color(2,68,107));
		frame.getContentPane().add(lblDID);

		lblPID.setFont(fLabel);
		lblPID.setBounds(492, 421, 116, 24);
		lblPID.setForeground(new Color(2, 68, 107));
		frame.getContentPane().add(lblPID);
		
		textFieldMed.setFont(fText);
		textFieldMed.setBounds(178, 386, 286, 24);
		frame.getContentPane().add(textFieldMed);
		textFieldMed.setColumns(10);
		
		textFieldDir.setFont(fText);
		textFieldDir.setBounds(178, 421, 286, 24);
		frame.getContentPane().add(textFieldDir);
		textFieldDir.setColumns(10);
		
		textFieldQty.setFont(fText);
		textFieldQty.setBounds(178, 456, 286, 24);
		frame.getContentPane().add(textFieldQty);
		textFieldQty.setColumns(10);
		
		textFieldDate.setFont(fText);
		textFieldDate.setBounds(178, 491, 286, 24);
		frame.getContentPane().add(textFieldDate);
		textFieldDate.setColumns(10);
		
		textFieldDID.setFont(fText);
		textFieldDID.setBounds(690, 386, 286, 24);
		frame.getContentPane().add(textFieldDID);
		textFieldDID.setColumns(10);
		
		textFieldPID.setFont(fText);
		textFieldPID.setBounds(690, 421, 286, 24);
		frame.getContentPane().add(textFieldPID);
		textFieldPID.setColumns(10);
		
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
					String sql = "INSERT INTO medicine(Patient_ID, Medical_Prescription, Direction, Quantity, Date_Prescribed, MD_ID)" 
							+ "VALUES (?, ?, ?, ?, ?, ?)";

				pst = con.prepareStatement(sql);

				pst.setString(1, textFieldPID.getText());
				pst.setString(2, textFieldMed.getText());
				pst.setString(3, textFieldDir.getText());
				pst.setString(4, textFieldQty.getText());
				pst.setString(5, textFieldDate.getText());
				pst.setString(6, textFieldDID.getText());
				pst.executeUpdate();
				
				} catch (SQLException | HeadlessException ex) {
					JOptionPane.showMessageDialog(null, ex);
			}
					Medicine();

				textFieldMed.setText("");
				textFieldDir.setText("");
				textFieldQty.setText("");
				textFieldDate.setText("");
				textFieldDID.setText("");
				textFieldPID.setText("");
			}
			if(e.getSource() == btnNext) {
				
				frame.dispose();
			}
			if(e.getSource() == btnBack) {
				Doctor doc = new Doctor();
				doc.setVisible(true);
				
				frame.dispose();
			}
	}
}

