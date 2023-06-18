package com.masai.MainUi;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


import com.masai.AdminUi.AdminMain;
import com.masai.BuyerUi.BuyerMain;
import com.masai.CSS.CSS;
import com.masai.SellerUi.SellerMain;


import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private static MainPage frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainPage();
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
	public MainPage() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 644);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AuctoNet Auction System");
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lblNewLabel.setBounds(258, 86, 383, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon logo = new ImageIcon(getClass().getResource("/Images/MainPage/Logo.png"));
		logo = setImgeSize(300, 200, logo);
		lblNewLabel_1.setIcon(logo);
		lblNewLabel_1.setBounds(296, 0, 300, 187);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Find your treasure today!");
		lblNewLabel_2.setForeground(new Color(153, 51, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblNewLabel_2.setBounds(226, 197, 448, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon mainIcon = new ImageIcon(getClass().getResource("/Images/MainPage/Main.png"));
		mainIcon = setImgeSize(400, 300, mainIcon);
		lblNewLabel_3.setIcon(mainIcon);
		lblNewLabel_3.setBounds(334, 295, 552, 312);
		contentPane.add(lblNewLabel_3);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		CSS.setMouseCursorNormal(btnAdminLogin);
		
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				System.out.println(false);
				AdminMain.main(null);
				
			}
		});
		btnAdminLogin.setForeground(new Color(0, 51, 255));
		btnAdminLogin.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		btnAdminLogin.setBounds(50, 243, 238, 64);
		contentPane.add(btnAdminLogin);
		
		JButton btnBuyerLogin = new JButton("Buyer Login");
		CSS.setMouseCursorNormal(btnBuyerLogin);
		btnBuyerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				BuyerMain.main(null);
			}
		});
		
		btnBuyerLogin.setForeground(new Color(0, 51, 255));
		btnBuyerLogin.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		btnBuyerLogin.setBounds(50, 358, 238, 64);
		contentPane.add(btnBuyerLogin);
		
		JButton btnSellerLogin = new JButton("Seller Login");
		CSS.setMouseCursorNormal(btnSellerLogin);
		btnSellerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SellerMain.main(null);
			}
		});
		
		
		btnSellerLogin.setForeground(new Color(0, 51, 255));
		btnSellerLogin.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		btnSellerLogin.setBounds(50, 472, 238, 64);
		contentPane.add(btnSellerLogin);
		
		JLabel lblNewLabel_4 = new JLabel("");
		ImageIcon imageShade = new ImageIcon(getClass().getResource("/Images/MainPage/shadeMain.png"));
		imageShade = setImgeSize(1000, 700, imageShade);
		lblNewLabel_4.setIcon(imageShade);
		lblNewLabel_4.setBounds(0, -35, 426, 705);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Exit");
		CSS.setMouseCursorExit(btnNewButton);
	    
		
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton.setBounds(773, 22, 113, 36);
		contentPane.add(btnNewButton);
		
		
	}
	
	public static ImageIcon setImgeSize(int b,int h,ImageIcon icon) {
		Image image = icon.getImage().getScaledInstance(b, h,Image.SCALE_SMOOTH );
		ImageIcon result = new ImageIcon(image);
		return result;
		
	}
}
