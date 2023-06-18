package com.masai.CSS;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class CSS extends JFrame {
	
	public static void setTable(JTable table) {
	
		table.setRowHeight(40);
		
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setHorizontalAlignment(JLabel.CENTER);
			table.setDefaultRenderer(Object.class, renderer);
			
			TableColumnModel columnModel = table.getColumnModel();
			for (int column = 0; column < table.getColumnCount(); column++) {
			    TableColumn tableColumn = columnModel.getColumn(column);
			    int preferredWidth = 0;
			    for (int row = 0; row < table.getRowCount(); row++) {
			        TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
			        Component c = table.prepareRenderer(cellRenderer, row, column);
			        int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
			        preferredWidth = Math.max(preferredWidth, width);
			    }
			    tableColumn.setPreferredWidth(preferredWidth);
			}
		
		
	}
	
	
	public static void setMouseCursorLogout(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.BLACK);
                button.setForeground(Color.WHITE);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
                button.setCursor(Cursor.getDefaultCursor());
            }
        });
    
}
	
	public static void setMouseCursorLogin(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.GREEN);
                button.setForeground(Color.white);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
                button.setCursor(Cursor.getDefaultCursor());
            }
        });
    
}
	
	public static void setMouseCursorDelete(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.RED);
                button.setForeground(Color.white);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
                button.setCursor(Cursor.getDefaultCursor());
            }
        });
    
}
    
	public static void setMouseCursorBack(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.GRAY);
                button.setForeground(Color.white);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
                button.setCursor(Cursor.getDefaultCursor());
            }
        });
    
}
	 
	
	
	
	public static void setMouseCursorNormal2(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.blue);
                button.setForeground(Color.white);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
                button.setCursor(Cursor.getDefaultCursor());
            }
        });
    
}
	 
	
	
	
	public static void setMouseCursorNormal(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.blue);
                button.setForeground(Color.white);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.blue);
                button.setCursor(Cursor.getDefaultCursor());
            }
        });
    
}
	
	public static void setMouseDelete(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.RED);
                button.setForeground(Color.WHITE);
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
                button.setCursor(Cursor.getDefaultCursor());
            }
        });
    
}
	 
    
	
		public static void setMouseCursorExit(JButton button) {
	        button.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                button.setBackground(Color.RED);
	                button.setForeground(Color.WHITE);
	                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                button.setBackground(Color.WHITE);
	                button.setForeground(Color.RED);
	                button.setCursor(Cursor.getDefaultCursor());
	            }
	        });
	    
	}
	
}
