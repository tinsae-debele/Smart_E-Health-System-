package org.eclipse.om2m.smartehealth.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.eclipse.om2m.SmartSecurity.controller.AuthenticationController;
import org.eclipse.om2m.SmartSecurity.controller.EncryptAndDecrypt;
import org.eclipse.om2m.smartehealth.main.DataParser;
import org.eclipse.om2m.smartehealth.main.SmartConstants;
import org.eclipse.om2m.smartehealth.main.SmartController;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.AccessController;
import java.util.HashMap;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class loginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblloginmsg = new JLabel("");
	private HashMap<String, String> values;
	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame frame = new loginFrame();
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
	public loginFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600,400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new LineBorder(new Color(0,0, 128) , 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(162, 117, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
				}
				else {
					txtUsername.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("")){
					txtUsername.setText("Username");
				}
			}
		});
		txtUsername.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		txtUsername.setText("Username");
		txtUsername.setBounds(12, 12, 167, 20);
		txtUsername.setBorder(new LineBorder(new Color(0,0, 0) , 0));
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(162, 168, 250, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('•');
					txtPassword.setText("");
				}
				else {
					txtPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("")){
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
			
		});
		txtPassword.setFont(new Font("Dialog", Font.BOLD, 12));
		txtPassword.setText("Password");
		txtPassword.setEchoChar((char)0);
		txtPassword.setBounds(12, 12, 165, 20);
		txtPassword.setBorder(new LineBorder(new Color(0,0, 0) , 0));
		panel_1.add(txtPassword);
		
		JPanel pnlBtnLogin = new JPanel();
		pnlBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				String userName = txtUsername.getText();
				String xmlString = SmartController.getUser(SmartConstants.AE_NAME,userName).getContent().toString();
				System.out.println(xmlString);
				DataParser data = new DataParser();
				values = data.parseData(xmlString);
				AuthenticationController auth = new AuthenticationController();
				
				if(auth.checkPassword(txtUsername.getText(), txtPassword.getText(), EncryptAndDecrypt.decrypt(values.get("User Data")))) {	
					String value = auth.setUserNameandRole(txtUsername.getText(), EncryptAndDecrypt.decrypt(values.get("User Data")));
					DashBoard DOCdashBoard = new DashBoard();
		
			    	if (value.equals("Doctor")){
			    		DOCdashBoard.setVisible(true);
			    		loginFrame.this.dispose();
			    	}else if(value.equals("Front Dask")) {
			    		DOCdashBoard.setVisible(true);
			    		loginFrame.this.dispose();
			    	}else if(value.equals("Pharmacist")) {
			    		
			    	}else if(value.equals("Nurce")) {
			    		DOCdashBoard.setVisible(true);
			    		loginFrame.this.dispose();
			    	}
					
					
				}
				else if(txtUsername.getText().equals("") || txtUsername.getText().equals("Username") || txtPassword.getText().equals("") ||
						txtPassword.getText().equals("") || txtPassword.getText().equals("Password")) {
					lblloginmsg.setText("Please Input all requirements");
				}
				else {
					lblloginmsg.setText("Wrong Password or Username! try again");
				}
			}
		});
		pnlBtnLogin.setBackground(new Color(128, 128, 128));
		pnlBtnLogin.setBounds(162, 251, 250, 40);
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setForeground(new Color(224, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(102, 12, 136, 16);
		pnlBtnLogin.add(lblNewLabel);
		
		JLabel lblx = new JLabel("X");
		lblx.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this applicaiton", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
				{
					loginFrame.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblx.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblx.setForeground(Color.WHITE);
			}
		});
		lblx.setForeground(Color.WHITE);
		lblx.setFont(new Font("Dialog", Font.BOLD, 14));
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setBounds(574, 0, 26, 20);
		contentPane.add(lblx);
		
		JLabel lblNewLabel_3 = new JLabel("Smart");
		lblNewLabel_3.setFont(new Font("Abyssinica SIL", Font.BOLD, 24));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(173, 52, 90, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("E-Health System");
		lblNewLabel_2.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(254, 51, 262, 31);
		contentPane.add(lblNewLabel_2);
		
		lblloginmsg.setForeground(Color.RED);
		lblloginmsg.setFont(new Font("Dialog", Font.BOLD, 13));
		lblloginmsg.setBounds(119, 224, 333, 15);
		contentPane.add(lblloginmsg);
		
		JPanel pnlBtnSignUp = new JPanel();
		pnlBtnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUpFrame signUpForm = new SignUpFrame();
				signUpForm.setVisible(true);
				loginFrame.this.dispose();
			}
		});
		pnlBtnSignUp.setLayout(null);
		pnlBtnSignUp.setBackground(Color.GRAY);
		pnlBtnSignUp.setBounds(162, 303, 250, 40);
		contentPane.add(pnlBtnSignUp);
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setForeground(new Color(224, 255, 255));
		lblSignUp.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSignUp.setBounds(102, 12, 136, 16);
		pnlBtnSignUp.add(lblSignUp);
		setLocationRelativeTo(null);
		
		
	}
}
