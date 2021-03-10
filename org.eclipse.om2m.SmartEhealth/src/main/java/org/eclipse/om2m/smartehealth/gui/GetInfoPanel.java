package org.eclipse.om2m.smartehealth.gui;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.eclipse.om2m.smartehealth.main.SmartConstants;
import org.eclipse.om2m.smartehealth.main.SmartController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import org.w3c.dom.*;

public class GetInfoPanel extends JPanel {
	private JTextField txtHealthCard;

	/**
	 * Create the panel.
	 */
	public GetInfoPanel() {
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
		
		JTextPane txtOutPut = new JTextPane();
		txtOutPut.setFont(new Font("Dialog", Font.PLAIN, 10));
		txtOutPut.setBounds(12, 104, 456, 341);
		add(txtOutPut);
		JButton btnSeach = new JButton("Search");
		btnSeach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String HealthCard = txtHealthCard.getText();
				String output = SmartController.getData(SmartConstants.AE_NAME,HealthCard).getContent().toString();
				System.out.println("Get Result");
				System.out.println(output);
				txtOutPut.setText(output);
				
			}
		});
		btnSeach.setBounds(224, 63, 117, 25);
		add(btnSeach);
		
		
	}
}
