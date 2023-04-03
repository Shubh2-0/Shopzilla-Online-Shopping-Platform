package com.masai.AdminUi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.masai.CSS.CSS;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Exceptions.RecordNotFoundException;
import com.masai.MainUi.MainPage;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;
import javax.swing.ListSelectionModel;





public class ViewAllBuyer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
    static ViewAllBuyer frame;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewAllBuyer();
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
	public ViewAllBuyer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1276, 587);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 51, 1214, 214);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setForeground(Color.WHITE);
		table.setBackground(new Color(102, 153, 255));
		table.setBorder(UIManager.getBorder("RadioButton.border"));
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"buyer1", "password1", "Amit", "Sharma", "9876543210", "123 Main St, Delhi"},
				{"buyer2", "password2", "Neha", "Patel", "8765432109", "456 Oak St, Mumbai"},
				{"buyer3", "password3", "Rahul", "Singh", "7654321098", "789 Maple St, Bangalore"},
				{"buyer4", "password4", "Pooja", "Gupta", "6543210987", "456 Elm St, Chennai"},
				{"buyer5", "password5", "Priya", "Verma", "+91-9876543211", "345 Park St, Kolkata"},
				{"buyer6", "password6", "Raj", "Gandhi", "+91-8765432108", "567 Beach Rd, Goa"},
				{"buyer7", "password7", "Sneha", "Kapoor", "+91-7654321097", "789 Hill St, Hyderabad"},
				{"buyer8", "password8", "Vikram", "Mehra", "+91-6543210986", "234 Lake Ave, Chandigarh"},
			},
			new String[] {
				"UserName", "password", "first_name", "last_name", "mobile_no", "address"
			}
		));
		table.getColumnModel().getColumn(5).setPreferredWidth(108);
			
		
		try {
			table.setModel(DbUtils.resultSetToTableModel(new AdminDaoImpl().getAllBuyer()));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CSS.setTable(table);

		
	
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				AdminOperations opp = new AdminOperations();
				opp.main(null);
			}
		});
		AdminOperations.chanageMouseColor(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewButton.setBounds(617, 373, 222, 56);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		ImageIcon icon = new ImageIcon(getClass().getResource("/Images/AdminPage/Blueback.png"));
		icon = MainPage.setImgeSize(1400, 800, icon);
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(0, 0, 1262, 550);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 495, 345, 13);
		contentPane.add(lblNewLabel_1);
	}
	
	

	
}
