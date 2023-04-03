package com.masai.CSS;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class CSS {
	
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
	

}
