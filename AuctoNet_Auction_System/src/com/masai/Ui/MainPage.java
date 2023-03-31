package com.masai.Ui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage {

	private JFrame frame;
	private static MainPage window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MainPage();
					window.frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 734, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon mainPage = new ImageIcon(getClass().getResource("/Images/MainPage/Logo.png"));
		
		Image iPage = mainPage.getImage().getScaledInstance(300, 230, Image.SCALE_SMOOTH);
		mainPage = new ImageIcon(iPage);
		
		JLabel lblNewLabel_1 = new JLabel("AuctoNet Auction System");
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(190, 62, 337, 134);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(94, 0, 539, 261);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(mainPage);
		
		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			window.frame.setVisible(false);
				
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnNewButton.setBounds(62, 306, 188, 72);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("User Login");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnNewButton_1.setBounds(61, 418, 189, 72);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon mainPage2 = new ImageIcon(getClass().getResource("/Images/MainPage/Main.png"));
		Image iPage2 = mainPage2.getImage().getScaledInstance(300, 230, Image.SCALE_SMOOTH);
		mainPage2 = new ImageIcon(iPage2);
		lblNewLabel_2.setIcon(mainPage2);
		lblNewLabel_2.setBounds(338, 275, 323, 239);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
