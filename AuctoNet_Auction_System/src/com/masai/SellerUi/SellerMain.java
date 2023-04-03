package com.masai.SellerUi;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.MainUi.MainPage;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class SellerMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private static SellerMain frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SellerMain();
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
	public SellerMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0,64));
		panel.setBounds(48, 194, 420, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 25));
		textField.setBounds(157, 49, 238, 43);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 25));
		passwordField.setBounds(157, 164, 238, 43);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Buyer Id : ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 49, 149, 53);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblNewLabel_1.setBounds(10, 158, 149, 63);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		btnNewButton.setBounds(144, 268, 179, 63);
		panel.add(btnNewButton);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton.setBackground(Color.BLUE);
				btnNewButton.setForeground(Color.WHITE);
				setCursor(Cursor.HAND_CURSOR); 
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton.setBackground(Color.WHITE);
				btnNewButton.setForeground(Color.BLACK);
				setCursor(Cursor.DEFAULT_CURSOR); 
				
				
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				MainPage main = new MainPage();
				main.main(null);
				
				
				
			}
		});
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_1.setBackground(Color.BLUE);
				btnNewButton_1.setForeground(Color.WHITE);
				setCursor(Cursor.HAND_CURSOR); 
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_1.setBackground(Color.WHITE);
				btnNewButton_1.setForeground(Color.BLACK);
				setCursor(Cursor.DEFAULT_CURSOR); 
				
				
			}
		});
		
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		btnNewButton_1.setBounds(804, 547, 123, 44);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Buyer Login");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 35));
		lblNewLabel_3.setBounds(360, 27, 252, 58);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		ImageIcon icon = new ImageIcon(getClass().getResource("/Images/SellerMain/sellerb.png"));
		icon = MainPage.setImgeSize(950, 600, icon);
		lblNewLabel_4.setIcon(icon);
		lblNewLabel_4.setBounds(0, -23, 960, 646);
		contentPane.add(lblNewLabel_4);
	}
}
