package org.eclipse.om2m.smartehealth.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

/**
 * 
 * @author tinsae , Kamran , Mohammed , Yohannes
 *
 */
public class DashBoard extends JFrame {

	private JPanel contentPane;
	private AddInfoPanel addinfoPanal;
	private GetInfoPanel getInfoPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard();
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
	public DashBoard() {
		setBackground(new Color(0, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 603);
		//setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		//contentPane.setBorder(new LineBorder(new Color(0,0, 128) , 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addinfoPanal = new AddInfoPanel();
		getInfoPanel = new GetInfoPanel();
		
		
		
		JPanel getPnl = new JPanel();
		getPnl.setBackground(new Color(0, 100, 0));
		getPnl.addMouseListener(new PanelButtonMouseAdapter(getPnl){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(getInfoPanel);
			}
		});
		getPnl.setBounds(119, 26, 133, 30);
		//getPnl.setBorder(new LineBorder(new Color(0,0, 128) , 2));
		contentPane.add(getPnl);
		
		JLabel lblNewLabel_1_1 = new JLabel("GET INFO");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		getPnl.add(lblNewLabel_1_1);
		
		JPanel addPnl = new JPanel();
		addPnl.addMouseListener(new PanelButtonMouseAdapter(addPnl) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(addinfoPanal);
			}
		});
		addPnl.setBackground(new Color(0, 100, 0));
		//addPnl.setBorder(new LineBorder(new Color(0,0, 128) , 2));
		addPnl.setForeground(new Color(0, 0, 0));
		addPnl.setBounds(0, 26, 120, 30);
		contentPane.add(addPnl);
		
		JLabel lblNewLabel_1 = new JLabel("ADD");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Century Schoolbook L", Font.BOLD, 15));
		addPnl.add(lblNewLabel_1);

		JLabel lblExit = new JLabel("X");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this applicaiton", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
				{
					DashBoard.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(Color.WHITE);
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Dialog", Font.BOLD, 14));
		lblExit.setBounds(476, 0, 26, 20);
		contentPane.add(lblExit);
		
		JLabel lblNewLabel = new JLabel("Smart E-health Managment System");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(12, 5, 411, 15);
		contentPane.add(lblNewLabel);
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBounds(10, 68, 480, 476);
		contentPane.add(paneMainContent);
		
		
		
		JPanel signOutbtn = new JPanel();
		signOutbtn.addMouseListener(new PanelButtonMouseAdapter(signOutbtn){
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to sign out ?") == 0) {
					loginFrame frameLogin = new loginFrame();
					frameLogin.setVisible(true);
					DashBoard.this.dispose();
				}
			}
		});
		signOutbtn.setBackground(new Color(0, 100, 0));
		signOutbtn.setBounds(370, 556, 120, 20);
		contentPane.add(signOutbtn);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("SIGN OUT");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Century Schoolbook L", Font.BOLD, 13));
		signOutbtn.add(lblNewLabel_1_2_1);
		paneMainContent.setLayout(null);
		
		paneMainContent.add(addinfoPanal);
		addinfoPanal.setVisible(true);
		paneMainContent.add(getInfoPanel);
		menuClicked(addinfoPanal);
		menuClicked(addinfoPanal);
	}
	public void menuClicked(JPanel panel) {
		addinfoPanal.setVisible(false);
		getInfoPanel.setVisible(false);
		panel.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112, 128 , 144));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(47, 79, 79));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
	}
}
