package org.eclipse.om2m.smartehealth.gui;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.eclipse.om2m.SmartSecurity.controller.AuthenticationController;
import org.eclipse.om2m.SmartSecurity.controller.EncryptAndDecrypt;
import org.eclipse.om2m.smartehealth.main.DataParser;
import org.eclipse.om2m.smartehealth.main.SmartConstants;
import org.eclipse.om2m.smartehealth.main.SmartController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import org.w3c.dom.*;

public class GetInfoPanel extends JPanel {
	private JTextField txtHealthCard;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtDOB;
	private JTextField txtAddrs;
	private JTextField txtTreat;
	private JTextField txtPres;
	private JTextField txtRef;
	private HashMap<String, String> values2;
	private JTextField textFieldUSER;

	/**
	 * Create the panel.
	 */
	public GetInfoPanel() {
		setBackground(SystemColor.window);
		setBounds(0, 0, 480,476);
		setVisible(true);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Health Card Number :");
		lblNewLabel.setBounds(12, 34, 152, 15);
		add(lblNewLabel);
		
		txtHealthCard = new JTextField();
		txtHealthCard.setBounds(182, 32, 152, 19);
		add(txtHealthCard);
		txtHealthCard.setColumns(10);
		
		JButton btnSeach = new JButton("Search");
		
		btnSeach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userName = textFieldUSER.getText();
				String xmlString2 = SmartController.getUser(SmartConstants.AE_NAME,userName).getContent().toString();
				System.out.println(xmlString2);
				DataParser data2 = new DataParser();
				values2 = data2.parseData(xmlString2);
				
				AuthenticationController auth2 = new AuthenticationController();
				
				
				AuthenticationController auth = new AuthenticationController();
				
			
				
				String value22 = auth2.setUserNameandRole("", EncryptAndDecrypt.decrypt(values2.get("User Data")));
				System.out.println(value22);
				String HealthCard = txtHealthCard.getText();
				String xmlString = SmartController.getData(SmartConstants.AE_NAME,HealthCard).getContent().toString();
				DataParser data = new DataParser();

				HashMap<String, String> values = data.parseData(xmlString);
				String [] roleList = {"Doctor" , "Front Dask" , "Nurce", "Pharmacist" ,"radiology"};
				if (value22.equals(roleList[0])  || value22.equals(roleList[2])) {
					txtFirstName = new JTextField();
					txtFirstName.setColumns(10);
					txtFirstName.setBounds(118, 124, 114, 19);
					add(txtFirstName);
					txtFirstName.setText(EncryptAndDecrypt.decrypt(values.get("Patient name")));
					
					JLabel fristName = new JLabel("Full Name :");
					fristName.setBounds(12, 126, 88, 15);
					add(fristName);
					
					JLabel lblNewLabel_1 = new JLabel("DOB :");
					lblNewLabel_1.setBounds(56, 155, 70, 15);
					add(lblNewLabel_1);
					
					txtDOB = new JTextField();
					txtDOB.setColumns(10);
					txtDOB.setBounds(118, 155, 114, 19);
					add(txtDOB);
					txtDOB.setText(EncryptAndDecrypt.decrypt(values.get("Date of birth")));
					
					
					JLabel lblNewLabel_1_1 = new JLabel("Address :");
					lblNewLabel_1_1.setBounds(260, 159, 70, 15);
					add(lblNewLabel_1_1);
					
					txtAddrs = new JTextField();
					txtAddrs.setColumns(10);
					txtAddrs.setBounds(342, 153, 114, 19);
					add(txtAddrs);
					txtAddrs.setText(EncryptAndDecrypt.decrypt(values.get("Address")));
					
					JLabel lblNewLabel_2 = new JLabel("Type Of Tretmeant :");
					lblNewLabel_2.setBounds(12, 217, 145, 15);
					add(lblNewLabel_2);
					
					txtTreat = new JTextField();
					txtTreat.setColumns(10);
					txtTreat.setBounds(170, 215, 286, 19);
					add(txtTreat);
					txtTreat.setText(EncryptAndDecrypt.decrypt(values.get("Type of Treatment")));
					
					txtPres = new JTextField();
					txtPres.setColumns(10);
					txtPres.setBounds(170, 262, 286, 19);
					add(txtPres);
					txtPres.setText(EncryptAndDecrypt.decrypt(values.get("Prescription")));
					
					JLabel lblPre = new JLabel("Prescription :");
					lblPre.setBounds(12, 264, 132, 15);
					add(lblPre);
					
					
					JLabel lblReferral = new JLabel("Referral :");
					lblReferral.setBounds(12, 305, 80, 15);
					add(lblReferral);
					
					txtRef = new JTextField();
					txtRef.setColumns(10);
					txtRef.setBounds(170, 303, 286, 19);
					add(txtRef);
					txtRef.setText(EncryptAndDecrypt.decrypt(values.get("Doc Referral")));
					
				}else if (value22.equals(roleList[1])){
					txtFirstName = new JTextField();
					txtFirstName.setColumns(10);
					txtFirstName.setBounds(118, 124, 114, 19);
					add(txtFirstName);
					txtFirstName.setText(EncryptAndDecrypt.decrypt(values.get("Patient name")));
					
					JLabel fristName = new JLabel("Full Name :");
					fristName.setBounds(12, 126, 88, 15);
					add(fristName);
					
					JLabel lblNewLabel_1 = new JLabel("DOB :");
					lblNewLabel_1.setBounds(56, 155, 70, 15);
					add(lblNewLabel_1);
					
					txtDOB = new JTextField();
					txtDOB.setColumns(10);
					txtDOB.setBounds(118, 155, 114, 19);
					add(txtDOB);
					txtDOB.setText(EncryptAndDecrypt.decrypt(values.get("Date of birth")));
					
					
					JLabel lblNewLabel_1_1 = new JLabel("Address :");
					lblNewLabel_1_1.setBounds(260, 159, 70, 15);
					add(lblNewLabel_1_1);
					
					txtAddrs = new JTextField();
					txtAddrs.setColumns(10);
					txtAddrs.setBounds(342, 153, 114, 19);
					add(txtAddrs);
					txtAddrs.setText(EncryptAndDecrypt.decrypt(values.get("Address")));
					
					
					
				}else if(value22.equals(roleList[3])) {
					
					JLabel fristName = new JLabel("Full Name :");
					fristName.setBounds(12, 126, 88, 15);
					add(fristName);
					
					txtFirstName = new JTextField();
					txtFirstName.setColumns(10);
					txtFirstName.setBounds(118, 124, 114, 19);
					add(txtFirstName);
					txtFirstName.setText(EncryptAndDecrypt.decrypt(values.get("Patient name")));
					
					JLabel lblNewLabel_1 = new JLabel("DOB :");
					lblNewLabel_1.setBounds(56, 155, 70, 15);
					add(lblNewLabel_1);
					
					txtDOB = new JTextField();
					txtDOB.setColumns(10);
					txtDOB.setBounds(118, 155, 114, 19);
					add(txtDOB);
					txtDOB.setText(EncryptAndDecrypt.decrypt(values.get("Date of birth")));
						
					JLabel lblNewLabel_1_1 = new JLabel("Address :");
					lblNewLabel_1_1.setBounds(260, 159, 70, 15);
					add(lblNewLabel_1_1);
					
					txtAddrs = new JTextField();
					txtAddrs.setColumns(10);
					txtAddrs.setBounds(342, 153, 114, 19);
					add(txtAddrs);
					txtAddrs.setText(EncryptAndDecrypt.decrypt(values.get("Address")));
					
					JLabel lblPre = new JLabel("Prescription :");
					lblPre.setBounds(12, 264, 132, 15);
					add(lblPre);
					
					txtPres = new JTextField();
					txtPres.setColumns(10);
					txtPres.setBounds(170, 262, 286, 19);
					add(txtPres);
					txtPres.setText(EncryptAndDecrypt.decrypt(values.get("Prescription")));
				
					
				}else if(value22.equals(roleList[4])){
					JLabel fristName = new JLabel("Full Name :");
					fristName.setBounds(12, 126, 88, 15);
					add(fristName);
					
					txtFirstName = new JTextField();
					txtFirstName.setColumns(10);
					txtFirstName.setBounds(118, 124, 114, 19);
					add(txtFirstName);
					txtFirstName.setText(EncryptAndDecrypt.decrypt(values.get("Patient name")));
					
					JLabel lblNewLabel_1 = new JLabel("DOB :");
					lblNewLabel_1.setBounds(56, 155, 70, 15);
					add(lblNewLabel_1);
					
					txtDOB = new JTextField();
					txtDOB.setColumns(10);
					txtDOB.setBounds(118, 155, 114, 19);
					add(txtDOB);
					txtDOB.setText(EncryptAndDecrypt.decrypt(values.get("Date of birth")));
					
					JLabel lblNewLabel_1_1 = new JLabel("Address :");
					lblNewLabel_1_1.setBounds(260, 159, 70, 15);
					add(lblNewLabel_1_1);
					
					txtAddrs = new JTextField();
					txtAddrs.setColumns(10);
					txtAddrs.setBounds(342, 153, 114, 19);
					add(txtAddrs);
					txtAddrs.setText(EncryptAndDecrypt.decrypt(values.get("Address")));
					
					JLabel lblNewLabel_2 = new JLabel("Type Of Tretmeant :");
					lblNewLabel_2.setBounds(12, 217, 145, 15);
					add(lblNewLabel_2);
					
					txtTreat = new JTextField();
					txtTreat.setColumns(10);
					txtTreat.setBounds(170, 215, 286, 19);
					add(txtTreat);
					txtTreat.setText(EncryptAndDecrypt.decrypt(values.get("Type of Treatment")));
		
					
					JLabel lblReferral = new JLabel("Referral :");
					lblReferral.setBounds(12, 305, 80, 15);
					add(lblReferral);
					
					txtRef = new JTextField();
					txtRef.setColumns(10);
					txtRef.setBounds(170, 303, 286, 19);
					add(txtRef);
					txtRef.setText(EncryptAndDecrypt.decrypt(values.get("Doc Referral")));
				}
			

				
				
				
				JLabel lblNewLabel_2 = new JLabel("Type Of Tretmeant :");
				lblNewLabel_2.setBounds(12, 217, 145, 15);
				add(lblNewLabel_2);
				
				txtTreat = new JTextField();
				txtTreat.setColumns(10);
				txtTreat.setBounds(170, 215, 286, 19);
				add(txtTreat);
				txtTreat.setText(EncryptAndDecrypt.decrypt(values.get("Type of Treatment")));
				
				
				
				
				JLabel lblReferral = new JLabel("Referral :");
				lblReferral.setBounds(12, 305, 80, 15);
				add(lblReferral);
				
				txtRef = new JTextField();
				txtRef.setColumns(10);
				txtRef.setBounds(170, 303, 286, 19);
				add(txtRef);
				txtRef.setText(EncryptAndDecrypt.decrypt(values.get("Doc Referral")));
				
			}
		});
		btnSeach.setBounds(351, 51, 117, 25);
		add(btnSeach);
		
		JLabel lblNewLabel_3 = new JLabel("User Name *");
		lblNewLabel_3.setBounds(12, 56, 152, 15);
		add(lblNewLabel_3);
		
		textFieldUSER = new JTextField();
		textFieldUSER.setBounds(182, 54, 114, 19);
		add(textFieldUSER);
		textFieldUSER.setColumns(10);
		
	
		
	}
}
