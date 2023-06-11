package com.masai.AdminUi;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.MainUi.MainPage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminMain extends JFrame {

	private JPanel contentPane;
	private static AdminMain frame1;
	private JTextField txtEnterAdminId;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 = new AdminMain();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBorder(null);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton.setBackground(Color.BLACK);
				btnNewButton.setForeground(Color.white);
				setCursor(Cursor.HAND_CURSOR); 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton.setBackground(Color.white);
				btnNewButton.setForeground(Color.BLACK);
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				frame1.setVisible(false);
				MainPage.main(null);

			}
		});
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));
		btnNewButton.setBounds(726, 588, 149, 54);
		contentPane.add(btnNewButton);

		JPanel lblNewLabel_2 = new JPanel();
		lblNewLabel_2.setBorder(null);
		lblNewLabel_2.setBackground(new Color(0, 0, 0, 50));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
		lblNewLabel_2.setBounds(0, 0, 1587, 90);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setLayout(null);
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/Images/AdminPage/admin2.png"));
		Image iPage1 = icon1.getImage().getScaledInstance(60, 50, Image.SCALE_SMOOTH);
		icon1 = new ImageIcon(iPage1);

		JLabel lblNewLabel_3 = new JLabel("Admin Login");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(icon1);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(0, 10, 885, 65);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.BOLD, 40));

		JPanel panel = new JPanel();
		panel.setBounds(239, 142, 594, 380);
		panel.setBackground(new Color(0, 0, 0, 80));
		contentPane.add(panel);
		panel.setLayout(null);

		txtEnterAdminId = new JTextField();
		txtEnterAdminId.setForeground(Color.BLACK);
		txtEnterAdminId.setBounds(216, 39, 353, 61);
		panel.add(txtEnterAdminId);
		txtEnterAdminId.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 27));
		txtEnterAdminId.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setForeground(Color.BLACK);
		passwordField.setBounds(216, 164, 353, 56);
		panel.add(passwordField);
		passwordField.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 27));

		JLabel lblNewLabel = new JLabel("Username  : ");
		lblNewLabel.setBounds(40, 36, 178, 64);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));

		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setBounds(40, 164, 165, 54);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));

		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_1.setBackground(Color.GREEN);
				btnNewButton_1.setForeground(Color.white);
				setCursor(Cursor.HAND_CURSOR); 
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_1.setBackground(Color.white);
				btnNewButton_1.setForeground(Color.BLACK);
				setCursor(Cursor.DEFAULT_CURSOR);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtEnterAdminId.getText().equals("") || passwordField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Empty Field....");

				else if (txtEnterAdminId.getText().equals("admin") && passwordField.getText().equals("admin")) {
					JOptionPane.showMessageDialog(null, "Welcome Shubham 😊");
					frame1.setVisible(false);
					AdminOperations.main(null);
					
				} else {

					JOptionPane.showMessageDialog(null, "Invalid Id or Password!");

				}

				txtEnterAdminId.setText(null);
				passwordField.setText(null);

			}
		});
		btnNewButton_1.setBounds(216, 295, 165, 56);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 0, 885, 652);
		contentPane.add(lblNewLabel_4);
		ImageIcon icon = new ImageIcon(getClass().getResource("/Images/AdminPage/nnnn.png"));
		icon = MainPage.setImgeSize(1000, 800, icon);
		lblNewLabel_4.setIcon(icon);

		

	}
}
