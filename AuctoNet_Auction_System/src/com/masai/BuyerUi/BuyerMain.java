package com.masai.BuyerUi;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.Dao.BuyerDaoImpl;
import com.masai.Dto.BuyerImpl;
import com.masai.MainUi.MainPage;

import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class BuyerMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static BuyerMain frame;
	public static BuyerImpl buyer;
	public static BuyerDaoImpl buyerDao = new BuyerDaoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BuyerMain();
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
	public BuyerMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon icon0 = new ImageIcon(getClass().getResource("/Images/BuyerMain/buyIcon.png"));
		icon0 = MainPage.setImgeSize(40, 40, icon0);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 250, 240));
		ImageIcon icon = new ImageIcon(getClass().getResource("/Images/BuyerMain/BuyerMain2.png"));
		icon = MainPage.setImgeSize(170, 170, icon);
		lblNewLabel_1.setIcon(icon);
		lblNewLabel_1.setBounds(680, 199, 232, 216);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Buyer Login");
		lblNewLabel.setBounds(563, 42, 425, 78);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(icon0);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		
		textField = new JTextField();
		textField.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		textField.setBackground(new Color(255, 200, 205));
		textField.setBorder(null);
		textField.setBounds(339, 231, 302, 51);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		textField_1.setBackground(new Color(255, 200, 205));
		textField_1.setColumns(10);
		textField_1.setBounds(339, 302, 302, 51);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				frame.setVisible(false);
				MainPage.main(null);
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		btnNewButton.setBounds(788, 581, 200, 61);
		contentPane.add(btnNewButton);
		
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
		
		
		JLabel lblNewLabel_2 = new JLabel("Username : ");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_2.setBounds(195, 231, 156, 61);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblNewLabel_3.setBounds(195, 302, 146, 51);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = textField.getText();
				String password = textField_1.getText();
				
				 buyer = null;
				
				if(username.equals("") || password.equals(""))
					JOptionPane.showMessageDialog(null, "Empty field..");
				
				
				
				else {
					
					buyer = buyerDao.loginBuyer(username, password);
	 
					
					if(buyer==null) {
					
						JOptionPane.showMessageDialog(null, "Invalid username or password");
						textField.setText(null);
						textField_1.setText(null);
						
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Welcome "+buyer.getFirstName()+"  😊");
						
						frame.setVisible(false);
						BuyerOperations b = new BuyerOperations(buyer);
						b.main(null);
						
					}
				}
				
				
				
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_1.setBackground(Color.PINK);
				btnNewButton_1.setForeground(Color.WHITE);
				setCursor(Cursor.HAND_CURSOR); 
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_1.setBackground(new Color(255, 204, 255));
				btnNewButton_1.setForeground(Color.BLACK);
				setCursor(Cursor.DEFAULT_CURSOR); 
				
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 204, 255));
		btnNewButton.setBackground(new Color(204, 255, 255));
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		btnNewButton_1.setBounds(446, 405, 134, 44);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2_1.setBounds(0, 0, 998, 571);
		contentPane.add(lblNewLabel_2_1);
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/Images/BuyerMain/buyerBack.png"));
		icon = MainPage.setImgeSize(2000, 12000, icon4);
		lblNewLabel_2_1.setIcon(icon4);
		
		JButton btnCreateNewAccount = new JButton("Create New Account");
		btnCreateNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				NewBuyer.main(null);
				
			}
		});
		btnCreateNewAccount.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		btnCreateNewAccount.setBackground(new Color(204, 255, 255));
		btnCreateNewAccount.setBounds(10, 581, 331, 61);
		contentPane.add(btnCreateNewAccount);
		
		JButton btnRestoreAccount = new JButton("Restore Account");
		btnRestoreAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				RestoreBuyerAcount.main(null);
				
				
			}
		});
		btnRestoreAccount.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		btnRestoreAccount.setBackground(new Color(204, 255, 255));
		btnRestoreAccount.setBounds(402, 581, 331, 61);
		contentPane.add(btnRestoreAccount);
	}
}
