package com.masai.AdminUi;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.proteanit.sql.DbUtils;
import javax.swing.border.EmptyBorder;

import com.masai.CSS.CSS;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Exceptions.RecordNotFoundException;
import com.masai.MainUi.MainPage;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

public class ViewAllSeller extends JFrame {

	private JPanel contentPane;
    static ViewAllSeller frame;
    private JTable table;
    private JLabel lblNewLabel;
    private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ViewAllSeller();
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
	public ViewAllSeller() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1402, 484);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		
	
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(562, 331, 222, 56);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				AdminOperations opp = new AdminOperations();
				opp.main(null);
			}
		});
		contentPane.setLayout(null);
		AdminOperations.chanageMouseColor(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		contentPane.add(btnNewButton);
		ImageIcon icon = new ImageIcon(getClass().getResource("/Images/AdminPage/Blueback.png"));
		icon = MainPage.setImgeSize(1400, 800, icon);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(10, 52, 1378, 169);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(SystemColor.window);
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Address", "Mobile Number", "Last Name", "First Name", "Password", "Buyer Id"
			}
		));
		table.setBackground(SystemColor.textHighlight);
		table.setModel(DbUtils.resultSetToTableModel(new AdminDaoImpl().getAllSeller()));
		table.setRowHeight(50);
		CSS.setTable(table);
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(0, 0, 1388, 437);
		contentPane.add(lblNewLabel);
	}
	
	
	
}
