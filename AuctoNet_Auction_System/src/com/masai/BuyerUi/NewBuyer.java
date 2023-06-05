package com.masai.BuyerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.MainUi.MainPage;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

public class NewBuyer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBuyer frame = new NewBuyer();
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
	public NewBuyer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 936);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.disabledShadow"));
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(UIManager.getColor("Button.disabledShadow"));
		panel.setBackground(new Color(0, 0, 0, 80));
		panel.setBounds(40, 105, 610, 730);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(175, 54, 333, 45);
		panel.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Usernme");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_1.setBounds(32, 69, 133, 30);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_2.setBounds(32, 172, 133, 30);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(175, 157, 333, 45);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(175, 260, 333, 45);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(175, 363, 333, 45);
		panel.add(textField_3);
		
		lblNewLabel_3 = new JLabel("Firstaname");
		lblNewLabel_3.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_3.setBounds(32, 275, 133, 30);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Lastname");
		lblNewLabel_4.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_4.setBounds(32, 379, 133, 30);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(175, 470, 333, 45);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(175, 578, 333, 45);
		panel.add(textField_5);
		
		lblNewLabel_5 = new JLabel("Mobile No.");
		lblNewLabel_5.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_5.setBounds(32, 486, 133, 30);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_6.setBounds(32, 598, 133, 30);
		panel.add(lblNewLabel_6);
		
		btnNewButton = new JButton("Create Account");
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton.setBounds(220, 651, 183, 50);
		panel.add(btnNewButton);
		
		lblNewLabel = new JLabel("Welcome To  AuctoNet Auction System");
		lblNewLabel.setForeground(new Color(255, 51, 51));
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		lblNewLabel.setBounds(0, 0, 739, 845);
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/Images/BuyerMain/newbuyer.png"));
		icon4 = MainPage.setImgeSize(2000, 12000, icon4);
		lblNewLabel.setIcon(icon4);
		
		contentPane.add(lblNewLabel);
	}
}
