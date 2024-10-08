package co.edu.uptc.views.tables;

import co.edu.uptc.views.wildCardClasses.Global;
import lombok.Getter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@Getter
public class Table {
    private JTable table;

    public Table() {
        createTable(new String[]{});
    }
    public void createTable(String[] columnNames) {
        DefaultTableModel model = new DefaultTableModel(null, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);

        table.setFont(Global.FONT_TEXTS_SMALL);
        table.setRowHeight(32);

        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnNames.length; i++) {
            columnModel.getColumn(i).setPreferredWidth(200);
        }
    }
    public void putData(Object[] data){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(data);
    }
}
