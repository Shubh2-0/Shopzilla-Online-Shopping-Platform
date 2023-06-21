package com.masai.AdminUi;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.CSS.CSS;
import com.masai.MainUi.MainPage;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class AdminOperations extends JFrame {

	private JPanel contentPane;
	private static AdminOperations frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminOperations();
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
	public AdminOperations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1096, 775);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome Shubham");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 35));
		lblNewLabel.setBounds(365, 10, 408, 74);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(10, 136, 408, 538);
		panel.setBackground(new Color(0, 0, 0, 64));
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("See All Buyers");
		btnNewButton.setBackground(Color.WHITE);
		CSS.setMouseCursorNormal2(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				ViewAllBuyer.main(null);

			}
		});

		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnNewButton.setBounds(75, 54, 251, 67);
		panel.add(btnNewButton);

		JButton btnSeeAllSellers = new JButton("See All Sellers");
		btnSeeAllSellers.setBackground(Color.WHITE);
		CSS.setMouseCursorNormal2(btnSeeAllSellers);
		btnSeeAllSellers.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				ViewAllSeller.main(null);

			}
		});

		btnSeeAllSellers.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnSeeAllSellers.setBounds(75, 190, 251, 67);
		panel.add(btnSeeAllSellers);

		JButton btnSeeAllTransactions = new JButton("See All Transactions");
		CSS.setMouseCursorNormal2(btnSeeAllTransactions);
		btnSeeAllTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				Transaction.main(null);
			}
		});

		btnSeeAllTransactions.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnSeeAllTransactions.setBounds(38, 432, 316, 67);
		panel.add(btnSeeAllTransactions);

		JButton btnViewAllProducts = new JButton("View All Products");
		btnViewAllProducts.setBackground(Color.WHITE);
		CSS.setMouseCursorNormal2(btnViewAllProducts);
		btnViewAllProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				ViewAllProduct.main(null);
			}
		});

		btnViewAllProducts.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		btnViewAllProducts.setBounds(75, 329, 251, 67);
		panel.add(btnViewAllProducts);
		ImageIcon icon = new ImageIcon(getClass().getResource("/Images/AdminPage/backadmin.png"));
		icon = MainPage.setImgeSize(1100, 800, icon);

		JButton btnNewButton_4 = new JButton("Logout");
		CSS.setMouseCursorLogout(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainPage.main(null);
			}
		});

		btnNewButton_4.setBounds(865, 647, 194, 67);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("Bahnschrift", Font.BOLD, 25));

		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/Images/AdminPage/adminback.png"));
		icon2 = MainPage.setImgeSize(700, 450, icon2);
		lblNewLabel_2.setIcon(icon2);

		lblNewLabel_2.setBounds(372, 154, 687, 480);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(icon);
		lblNewLabel_1.setBounds(0, 0, 1077, 731);
		contentPane.add(lblNewLabel_1);
	}

}
