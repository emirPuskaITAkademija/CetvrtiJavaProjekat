package gui.six.swing;

import gui.five.PlayerInfo;
import gui.five.PlayerInfoDao;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
//Pattern
//Compile
//regex -> Regular expressions

public class PlayerInfoPanel extends JPanel implements TableModelListener {

    private final PlayerInfoDao playerDao;
    private JCheckBox rowCheckBox;
    private JCheckBox columnCheckBox;
    private ButtonGroup buttonGroup;
    private JTextArea outputTextArea;

    public PlayerInfoPanel(PlayerInfoDao playerDao) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.playerDao = playerDao;
        //tabela sa scroll pane
        OurTableModel tableModel = new OurTableModel(playerDao.getColumnNames(), getAll());
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.getModel().addTableModelListener(this);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        //
        add(new JLabel("Selection Mode"));
        rowCheckBox = new JCheckBox("Row selection");
        add(rowCheckBox);
        columnCheckBox = new JCheckBox("Column Selection");
        add(columnCheckBox);
        add(new JLabel("Selection Options"));
        JRadioButton singleRadioButton = new JRadioButton("Single selection");
        JRadioButton multipleRadioButton = new JRadioButton("Multiple selection");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(singleRadioButton);
        buttonGroup.add(multipleRadioButton);
        add(singleRadioButton);
        add(multipleRadioButton);
        outputTextArea = new JTextArea(5, 40);
        add(new JScrollPane(outputTextArea));
    }

    private Vector<Vector<Object>> getAll() {
        Vector<Vector<Object>> dataRow = new Vector<>();
        for (PlayerInfo playerInfo : playerDao.getAll()) {
            Vector<Object> row = new Vector<>();
            row.addElement(playerInfo.getId());
            row.addElement(playerInfo.getFirstName());
            row.addElement(playerInfo.getLastName());
            row.addElement(playerInfo.getSport());
            row.addElement(playerInfo.getOfYears());
            row.addElement(playerInfo.getVegetarian());
            dataRow.addElement(row);
        }
        return dataRow;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel tableModel = (TableModel) e.getSource();
        String columnName = tableModel.getColumnName(column);
        Object data = tableModel.getValueAt(row, column);
        System.out.println("Ime kolone: " + columnName);
        System.out.println(data + " <------ podatak koji se promijenio");
    }

    private class OurTableModel extends AbstractTableModel {

        private final Vector<String> columnNames;
        private final Vector<Vector<Object>> data;

        public OurTableModel(Vector<String> columnNames, Vector<Vector<Object>> data) {
            this.columnNames = columnNames;
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames.get(column);
        }

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
        public Class<? extends Object> getColumnClass(int columnIndex) {
            Class<?> clazz = getValueAt(0, columnIndex).getClass();
            System.out.println(clazz);
            return getValueAt(0, columnIndex).getClass(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Vector<Object> rowVector = data.get(rowIndex);
            rowVector.remove(columnIndex);
            rowVector.add(columnIndex, aValue);
        }
    }
}
