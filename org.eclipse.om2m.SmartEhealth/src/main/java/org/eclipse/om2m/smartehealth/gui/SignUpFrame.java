package org.eclipse.om2m.smartehealth.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.om2m.SmartSecurity.model.Authentication;
import org.eclipse.om2m.smartehealth.main.SmartController;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class SignUpFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtFristName;
	private JTextField txtLastName;
	private JTextField txtUserName;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JTextField txtCPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpFrame frame = new SignUpFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUpFrame() {
		String [] roleList = {"Doctor" , "Front Dask" , "Nurce", "Pharmacist" , "radiology"};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0, 139, 139));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSmartEhealthManagment = new JLabel("Smart E-health Managment System: Registeration  Form");
		lblSmartEhealthManagment.setForeground(Color.WHITE);
		lblSmartEhealthManagment.setBounds(12, 12, 411, 15);
		contentPane.add(lblSmartEhealthManagment);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 41, 451, 7);
		contentPane.add(separator);
		
		JLabel fristName = new JLabel("Frist Name :");
		fristName.setBounds(22, 86, 88, 15);
		contentPane.add(fristName);
		
		txtFristName = new JTextField();
		txtFristName.setColumns(10);
		txtFristName.setBounds(128, 84, 114, 19);
		contentPane.add(txtFristName);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(359, 84, 114, 19);
		contentPane.add(txtLastName);
		
		JLabel lblLastName = new JLabel("LastName :");
		lblLastName.setBounds(271, 84, 88, 15);
		contentPane.add(lblLastName);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(128, 115, 114, 19);
		contentPane.add(txtUserName);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setBounds(22, 117, 101, 15);
		contentPane.add(lblUserName);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(128, 196, 286, 19);
		contentPane.add(txtEmail);
		
		JLabel lblEmail = new JLabel("E-Mail  :");
		lblEmail.setBounds(40, 198, 70, 15);
		contentPane.add(lblEmail);
		
		JComboBox CBRole = new JComboBox(roleList);
		CBRole.setBounds(128, 151, 209, 24);
		contentPane.add(CBRole);
		
		JLabel lblRole = new JLabel("Role :");
		lblRole.setBounds(40, 156, 70, 15);
		contentPane.add(lblRole);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(179, 245, 209, 19);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(79, 247, 99, 15);
		contentPane.add(lblPassword);
		
		txtCPassword = new JTextField();
		txtCPassword.setColumns(10);
		txtCPassword.setBounds(179, 276, 209, 19);
		contentPane.add(txtCPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setBounds(22, 274, 137, 17);
		contentPane.add(lblConfirmPassword);
		
		JButton btnReg = new JButton("Register Now");
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd = txtPassword.getText();
				String firstName = txtFristName.getText();
				String lastName = txtLastName.getText();
				String role = String.valueOf(CBRole.getSelectedItem());
				String userName =  txtUserName.getText();
				String email = txtEmail.getText();
				Authentication encPwd = new Authentication();
				
				String userPwdDATA = encPwd.addInfo(userName, pwd, role, email , firstName,lastName);
				
				SmartController.addUser(firstName,lastName ,userName , role ,userPwdDATA);	
				if(JOptionPane.showConfirmDialog(null, "Registration succesfull", "Go Back to Login Page", JOptionPane.YES_NO_OPTION) == 0)
				{
					loginFrame frameLogin = new loginFrame();
					frameLogin.setVisible(true);
					SignUpFrame.this.dispose();
				}
			}
		});
		btnReg.setBounds(161, 307, 216, 25);
		contentPane.add(btnReg);
	}
}
