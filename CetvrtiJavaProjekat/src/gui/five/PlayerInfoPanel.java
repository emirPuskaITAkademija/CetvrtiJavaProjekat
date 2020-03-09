package gui.five;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;

public class PlayerInfoPanel extends JPanel {

    private final PlayerInfoDao playerDao;
    private final Vector<Vector<Object>> data;
    private final Vector<String> columnNames;
    private JCheckBox rowCheckBox;
    private JCheckBox columnCheckBox;
    private ButtonGroup buttonGroup;
    private JTextArea outputTextArea;

    public PlayerInfoPanel(PlayerInfoDao playerDao) {
       setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.playerDao = playerDao;
        this.columnNames = playerDao.getColumnNames();
        this.data = getAll();
        //tabela sa scroll pane
        JTable table = new JTable(this.data, this.columnNames);
        OurTableModel tableModel = new OurTableModel();
        table.setModel(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private Vector<Vector<Object>> getAll() {
        Vector<Vector<Object>> data = new Vector<>();
        for (PlayerInfo playerInfo : playerDao.getAll()) {
            Vector<Object> vectorRow = new Vector<>();
            vectorRow.addElement(playerInfo.getId());
            vectorRow.addElement(playerInfo.getFirstName());
            vectorRow.addElement(playerInfo.getLastName());
            vectorRow.addElement(playerInfo.getSport());
            vectorRow.addElement(playerInfo.getOfYears());
            vectorRow.addElement(playerInfo.getVegetarian());
            data.addElement(vectorRow);
        }
        return data;
    }

    private class OurTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Vector<Object> rowVector = data.get(rowIndex);
            Object object = rowVector.get(columnIndex);
            return object;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class<?> clazz = getValueAt(0, columnIndex).getClass();
            System.out.println(clazz.getName());
            return getValueAt(0, columnIndex).getClass(); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
