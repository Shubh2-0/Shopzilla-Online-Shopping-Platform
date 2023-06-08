package com.masai.BuyerUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.masai.Dao.BuyerDao;
import com.masai.Dao.BuyerDaoImpl;
import com.masai.Dto.Buyer;
import com.masai.Dto.BuyerImpl;
import com.masai.MainUi.MainPage;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JLabel lblNewLabel_7;
    static BuyerImpl buyer ;
    static JFrame frame;
    static final BuyerDao bDao = new BuyerDaoImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new NewBuyer();
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
		panel.setBounds(46, 10, 650, 825);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		textField.setBounds(175, 122, 333, 45);
		panel.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Firstname");
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_1.setBounds(21, 137, 133, 30);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Lastname");
		lblNewLabel_2.setForeground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_2.setBounds(21, 243, 133, 30);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		textField_1.setColumns(10);
		textField_1.setBounds(175, 219, 333, 45);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		textField_2.setColumns(10);
		textField_2.setBounds(175, 321, 333, 45);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		textField_3.setColumns(10);
		textField_3.setBounds(175, 421, 333, 45);
		panel.add(textField_3);
		
		lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setForeground(Color.PINK);
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_3.setBounds(21, 336, 133, 30);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(Color.PINK);
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_4.setBounds(21, 436, 133, 30);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		textField_4.setColumns(10);
		textField_4.setBounds(175, 511, 333, 45);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Bahnschrift", Font.PLAIN, 21));
		textField_5.setColumns(10);
		textField_5.setBounds(175, 611, 333, 45);
		panel.add(textField_5);
		
		lblNewLabel_5 = new JLabel("Mobile No.");
		lblNewLabel_5.setForeground(Color.PINK);
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_5.setBounds(21, 526, 133, 30);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setForeground(Color.PINK);
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.BOLD, 23));
		lblNewLabel_6.setBounds(21, 626, 133, 30);
		panel.add(lblNewLabel_6);
		
		btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String firstName = textField.getText() ;
				String lastName = textField_1.getText();
				String username = textField_2.getText();
				String password = textField_3.getText();
				String mobileNo = textField_4.getText();
				String address = textField_5.getText();
				
				if(firstName.equals("") || lastName.equals("") || 
						username.equals("") || password.equals("") ||
						mobileNo.equals("") || address.equals("")) {
					
					JOptionPane.showMessageDialog(null, "kindly provide the necessary information in all the required fields");
					return ;
					
				}
				
			
				
				
				buyer =  bDao.getBuyerByUsername(username.toString());
				
				if(buyer != null) {
					buyer = null;
					JOptionPane.showMessageDialog(null, "Please choose a different username as the current one is already taken");
					textField_2.setText("");
					return;
					
				}else {
					JOptionPane.showMessageDialog(null, "Congratulations! Your account has been successfully created");
					buyer = new BuyerImpl(username, password, firstName, lastName, mobileNo, address);
					bDao.registerNewBuyer(buyer);
					frame.setVisible(false);
					BuyerMain.main(null);
					
					
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		btnNewButton.setBounds(231, 711, 183, 50);
		panel.add(btnNewButton);
		
		lblNewLabel_7 = new JLabel("Welcome To Actonet Auction System");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		lblNewLabel_7.setForeground(Color.CYAN);
		lblNewLabel_7.setBounds(60, 10, 561, 102);
		panel.add(lblNewLabel_7);
		
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
