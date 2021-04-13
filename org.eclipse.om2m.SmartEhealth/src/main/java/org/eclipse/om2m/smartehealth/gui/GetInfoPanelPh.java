package org.eclipse.om2m.smartehealth.gui;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

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

public class GetInfoPanelPh extends JPanel {
	private JTextField txtHealthCard;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtDOB;
	private JTextField txtAddrs;
	private JTextField txtTreat;
	private JTextField txtPres;
	private JTextField txtRef;

	/**
	 * Create the panel.
	 */
	public GetInfoPanelPh() {
		setBackground(SystemColor.window);
		setBounds(0, 0, 480,476);
		setVisible(true);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Health Card Number :");
		lblNewLabel.setBounds(44, 34, 152, 15);
		add(lblNewLabel);
		
		txtHealthCard = new JTextField();
		txtHealthCard.setBounds(214, 32, 152, 19);
		add(txtHealthCard);
		txtHealthCard.setColumns(10);
		
		JButton btnSeach = new JButton("Search");
		
		btnSeach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String HealthCard = txtHealthCard.getText();
				String xmlString = SmartController.getData(SmartConstants.AE_NAME,HealthCard).getContent().toString();
				DataParser data = new DataParser();

				HashMap<String, String> values = data.parseData(xmlString);
				
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
				txtAddrs.setText(EncryptAndDecrypt.decrypt(values.get("Date of birth")));
				txtPres = new JTextField();
				txtPres.setColumns(10);
				txtPres.setBounds(170, 262, 286, 19);
				add(txtPres);
				txtPres.setText(EncryptAndDecrypt.decrypt(values.get("Prescription")));
				
				JLabel lblPre = new JLabel("Prescription :");
				lblPre.setBounds(12, 264, 132, 15);
				add(lblPre);
				
				/*
				JLabel lblReferral = new JLabel("Referral :");
				lblReferral.setBounds(12, 305, 80, 15);
				add(lblReferral);
				
				
				txtRef = new JTextField();
				txtRef.setColumns(10);
				txtRef.setBounds(170, 303, 286, 19);
				add(txtRef);
				txtRef.setText(EncryptAndDecrypt.decrypt(values.get("Doc Referral")));
				*/
			}
		});
		btnSeach.setBounds(224, 63, 117, 25);
		add(btnSeach);
		
	
		
	}
}
