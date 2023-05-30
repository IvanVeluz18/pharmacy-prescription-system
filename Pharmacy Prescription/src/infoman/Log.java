package infoman;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Log extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JFrame frame = new JFrame("Log In");

	JLabel lblTitle = new JLabel("Pharmacy Prescription");
	JLabel lblTitleShadow = new JLabel("Pharmacy Prescription");
	JLabel lblTitle1 = new JLabel("System");
	JLabel lblTitle1Shadow = new JLabel("System");
	JLabel lblLogo = new JLabel("+");
	JLabel lblLogoShadow = new JLabel("+");
	JLabel lblUser = new JLabel("Username");
	
	JTextField txtUser = new JTextField();
	JPasswordField txtPass = new JPasswordField();
	JLabel lblPass = new JLabel("Password");
	JButton btnLog = new JButton("Log in");
	
	Font fTitle = new Font("Arial Rounded MT Bold", Font.BOLD, 55);
	Font fSymbol = new Font("Britannic Bold", Font.BOLD, 250);
	Font fText = new Font("Arial Rounded MT Bold", Font.BOLD, 20);
	
		public Log() {
			initComponents();
		}
		
		public void initComponents() {
			frame.getContentPane().setBackground(Color.white);
			frame.setBounds(100,100,1000,600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.setLocationRelativeTo(null);
			
			lblTitle.setFont(fTitle);
			lblTitle.setForeground(new Color(2,68,107));
			lblTitle.setBounds(324, 39, 665, 81);
			frame.getContentPane().add(lblTitle);
			
			lblTitleShadow.setFont(fTitle);
			lblTitleShadow.setForeground(new Color(91,153,189));
			lblTitleShadow.setBounds(327, 42, 665, 81);
			frame.getContentPane().add(lblTitleShadow);
			
			lblTitle1.setFont(fTitle);
			lblTitle1.setForeground(new Color(2,68,107));
			lblTitle1.setBounds(550, 98, 252, 81);
			frame.getContentPane().add(lblTitle1);

			lblTitle1Shadow.setFont(fTitle);
			lblTitle1Shadow.setForeground(new Color(91,153,189));
			lblTitle1Shadow.setBounds(553, 101, 252, 81);
			frame.getContentPane().add(lblTitle1Shadow);

			lblLogo.setFont(fSymbol);
			lblLogo.setForeground(new Color(2, 68, 107));
			lblLogo.setBounds(587, 189, 133, 158);
			frame.getContentPane().add(lblLogo);
			
			lblLogoShadow.setFont(fSymbol);
			lblLogoShadow.setForeground(new Color(91,153,189));
			lblLogoShadow.setBounds(603, 211, 133, 164);
			frame.getContentPane().add(lblLogoShadow);
			
			lblUser.setFont(fText);
			lblUser.setForeground(new Color(2,68,107));
			lblUser.setBounds(412, 395, 109, 31);
			frame.getContentPane().add(lblUser);
			
			lblPass.setFont(fText);
			lblPass.setForeground(new Color(2,68,107));
			lblPass.setBounds(412, 437, 109, 31);
			frame.getContentPane().add(lblPass);
			
			txtUser.setFont(fText);
			txtUser.setBounds(531, 395, 326, 31);
			txtUser.setBackground(new Color(200,234,255));
			txtUser.setForeground(new Color(2,68,107));
			frame.getContentPane().add(txtUser);
			txtUser.setColumns(10);
			
			txtPass.setFont(fText);
			txtPass.setBounds(531, 437, 326, 31);
			txtPass.setBackground(new Color(200,234,255));
			txtPass.setForeground(new Color(2,68,107));
			txtPass.setEchoChar('*');
			frame.getContentPane().add(txtPass);
			txtPass.setColumns(10);
			
			btnLog.setFont(fText);
			btnLog.setBackground(new Color(2,68,107));
			btnLog.setForeground(new Color(136,205,246));
			btnLog.setBounds(614, 479, 119, 31);
			frame.getContentPane().add(btnLog);
			btnLog.addActionListener(this);
			
			JLabel lblIcon = new JLabel("");
			Image img = new ImageIcon(this.getClass().getResource("/doctor.png")).getImage();
			lblIcon.setIcon(new ImageIcon(img));
			lblIcon.setBounds(10, 26, 426, 512);
			frame.getContentPane().add(lblIcon);
			
			frame.setVisible(true);
		}
		
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnLog){
					frame.dispose();
					Patient p = new Patient();
					p.setVisible(true);
				}
			}
}