package com.masai.BuyerUi;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.CSS.CSS;
import com.masai.Dao.BuyerDao;
import com.masai.Dao.BuyerDaoImpl;
import com.masai.MainUi.MainPage;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RestoreBuyerAcount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
	static RestoreBuyerAcount frame;
	private JPasswordField passwordField;
	static BuyerDao buyerDao = new BuyerDaoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new RestoreBuyerAcount();
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
	public RestoreBuyerAcount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 647);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Recovery");
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 39));
		lblNewLabel.setBounds(261, 53, 481, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(147, 10, 151, 128);
		contentPane.add(lblNewLabel_1);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/Images/BuyerMain/buyerrecover.png"));
		icon = MainPage.setImgeSize(100, 100, icon);
		lblNewLabel_1.setIcon(icon);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		lblNewLabel_2.setText("Note: You can recover your account if you request the recovery within");
		lblNewLabel_2.setBounds(10, 141, 808, 38);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblNewLabel_3.setText("30 days from the date of deletion");
		lblNewLabel_3.setBounds(504, 144, 473, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_4.setBounds(40, 230, 190, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Password");
		lblNewLabel_4_1.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_4_1.setBounds(40, 309, 176, 30);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Confirm Password");
		lblNewLabel_4_2.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		lblNewLabel_4_2.setBounds(40, 398, 226, 30);
		contentPane.add(lblNewLabel_4_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		textField.setBounds(299, 211, 396, 49);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		textField_1.setColumns(10);
		textField_1.setBounds(299, 290, 396, 49);
		contentPane.add(textField_1);
		
		textField_2 = new JPasswordField();
		textField_2.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		textField_2.setColumns(10);
		textField_2.setBounds(299, 379, 396, 49);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Recover Acount");
		CSS.setMouseCursorNormal2(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				String tempusername = textField.getText();
				String temppassword = textField_1.getText();
				String confirmPassword = textField_2.getText();
				
                
				if(temppassword.equals("") || tempusername.equals("") | confirmPassword.equals("")) {
					
					JOptionPane.showMessageDialog(null, "Please ensure all required fields are filled before proceeding");
					return;
					
				}
				
				if(!temppassword.equals(confirmPassword)) {
				
					JOptionPane.showMessageDialog(null, "Password and confirm password is not matching");
					return;
					
				}
				
				
				String ans = buyerDao.recoverBuyerAcount(tempusername, confirmPassword, LocalDate.now());
				
				JOptionPane.showMessageDialog(null, ans);
				
				frame.setVisible(false);
				BuyerMain.main(null);
				
				
				
				
				
			}
		});
		btnNewButton.setToolTipText("");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton.setBounds(263, 479, 190, 49);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		CSS.setMouseCursorBack(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				BuyerMain.main(null);
				
			}
		});
		btnBack.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnBack.setBounds(640, 551, 118, 49);
		contentPane.add(btnBack);
		
		
		
	}
}
