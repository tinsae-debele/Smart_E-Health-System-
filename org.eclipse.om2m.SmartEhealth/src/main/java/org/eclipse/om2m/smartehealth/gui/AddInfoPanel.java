package org.eclipse.om2m.smartehealth.gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.om2m.smartehealth.main.SmartController;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



/**
 * 
 * @author tinsae , Kamran , Mohammed , Yohannes
 * this class is responsible for add patient information
 */
public class AddInfoPanel extends JPanel {
	private JTextField txtFristName;
	private JTextField txtLastName;
	private JTextField txtHealthCard;
	private JTextField txtDOB;
	private JTextField txtAddress;
	private JTextField txtTreat;
	private JTextField txtPre;
	private JTextField txtReferral;
	private JTextField txtDrName;

	/**
	 * Create the panel.
	 */
	public AddInfoPanel() {
		setBackground(SystemColor.window);
		setBounds(0, 0, 480,476);
		setVisible(true);
		setLayout(null);
		
		JLabel fristName = new JLabel("Frist Name :");
		fristName.setBounds(32, 76, 88, 15);
		add(fristName);
		
		txtFristName = new JTextField();
		txtFristName.setBounds(120, 74, 114, 19);
		add(txtFristName);
		txtFristName.setColumns(10);
		
		JLabel lblLastName = new JLabel("LastName :");
		lblLastName.setBounds(266, 76, 88, 15);
		add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(354, 74, 114, 19);
		add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblHcard = new JLabel("Health Card Number :");
		lblHcard.setBounds(32, 35, 158, 15);
		add(lblHcard);
		
		txtHealthCard = new JTextField();
		txtHealthCard.setBounds(208, 33, 114, 19);
		add(txtHealthCard);
		txtHealthCard.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("DOB :");
		lblNewLabel.setBounds(32, 112, 70, 15);
		add(lblNewLabel);
		
		txtDOB = new JTextField();
		txtDOB.setBounds(120, 110, 114, 19);
		add(txtDOB);
		txtDOB.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 165, 456, 15);
		add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Address :");
		lblNewLabel_1.setBounds(266, 112, 70, 15);
		add(lblNewLabel_1);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(354, 110, 114, 19);
		add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Type Of Tretmeant :");
		lblNewLabel_2.setBounds(32, 195, 145, 15);
		add(lblNewLabel_2);
		
		txtTreat = new JTextField();
		txtTreat.setBounds(182, 193, 286, 19);
		add(txtTreat);
		txtTreat.setColumns(10);
		
		JLabel lblPre = new JLabel("Prescription :");
		lblPre.setBounds(32, 222, 132, 15);
		add(lblPre);
		
		txtPre = new JTextField();
		txtPre.setBounds(182, 220, 286, 19);
		add(txtPre);
		txtPre.setColumns(10);
		
		JLabel lblReferral = new JLabel("Referral :");
		lblReferral.setBounds(32, 249, 80, 15);
		add(lblReferral);
		
		txtReferral = new JTextField();
		txtReferral.setBounds(182, 247, 286, 19);
		add(txtReferral);
		txtReferral.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 282, 456, 2);
		add(separator_1);
		
		JLabel lblDrName = new JLabel("Doctor Name :");
		lblDrName.setBounds(32, 316, 122, 15);
		add(lblDrName);
		
		txtDrName = new JTextField();
		txtDrName.setBounds(182, 314, 179, 19);
		add(txtDrName);
		txtDrName.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fristName = txtFristName.getText();
				String lastName = txtLastName.getText();
				String namePatient = fristName + " " + lastName;
				String hcard = txtHealthCard.getText();
				String preOrder = txtPre.getText();
				String birthOfDate = txtDOB.getText();
				String phyName = txtDrName.getText();
				String treatType =txtTreat.getText();
				String address = txtAddress.getText();
				String docRef = txtReferral.getText();
				SmartController.addData(hcard,namePatient,birthOfDate, treatType, preOrder, phyName,address, docRef );
				
			}
			
		});
		
		btnNewButton.setBounds(182, 352, 117, 25);
		add(btnNewButton);
		
	}
}
