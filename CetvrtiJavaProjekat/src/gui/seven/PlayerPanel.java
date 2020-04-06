package gui.seven;

import gui.five.PlayerInfo;
import gui.five.PlayerInfoDao;
import gui.five.PlayerInfoFrame;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * 1. Table(JTable)
 * <ol>
 * <li> single select
 * <li> multiple select
 * <li>
 *
 * @author Grupa2
 */
public class PlayerPanel extends JPanel {

    private final PlayerInfoDao playerDao;

    private JTextField sportTextField;
    private TableRowSorter<OurTableModel> tableRowSorter;
    private JTable table;


    public PlayerPanel(PlayerInfoDao playerDao) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.playerDao = playerDao;
        OurTableModel tableModel = new OurTableModel(playerDao.getColumnNames(), getPlayers());
        this.tableRowSorter = new TableRowSorter<>(tableModel);
        JPanel form = new JPanel(new GridLayout(1, 1));
        JLabel sportLabel = new JLabel("Filter by sport:", SwingConstants.TRAILING);
        form.add(sportLabel);
        sportTextField = new JTextField();
        PlayerDocumentListener documentListener = new PlayerDocumentListener(sportTextField, tableRowSorter);
        sportTextField.getDocument().addDocumentListener(documentListener);
        sportLabel.setLabelFor(sportTextField);
        form.add(sportTextField);

        this.table = new JTable(tableModel);
        this.table.setRowSorter(tableRowSorter);
        this.table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        this.table.setFillsViewportHeight(true);
        this.table.getModel().addTableModelListener(new PlayerTableModelListener(playerDao));
        //
        add(form);
        add(new JScrollPane(table));
    }

    private Vector<Vector<Object>> getPlayers() {
        Vector<Vector<Object>> dataRows = new Vector<>();
        for (PlayerInfo playerInfo : playerDao.getAll()) {
            Vector<Object> row = new Vector<>();
            row.addElement(playerInfo.getId());
            row.addElement(playerInfo.getFirstName());
            row.addElement(playerInfo.getLastName());
            row.addElement(playerInfo.getSport());
            row.addElement(playerInfo.getOfYears());
            row.addElement(playerInfo.getVegetarian());
            dataRows.add(row);
        }
        return dataRows;
    }

    class OurTableModel extends AbstractTableModel {

        private Vector<String> columnNames;
        private Vector<Vector<Object>> data;

        public OurTableModel(Vector<String> columnNames, Vector<Vector<Object>> data) {
            this.columnNames = columnNames;
            this.data = data;
        }
        
        public Vector<Object> getRowData(int rowNumber){
            return data.get(rowNumber);
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
        public String getColumnName(int column) {
            return columnNames.get(column);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            Class<?> clazz = getValueAt(0, columnIndex).getClass();
            System.out.println(clazz);
            return clazz;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Vector<Object> rowVector = data.get(rowIndex);
            Object object = rowVector.get(columnIndex);
            System.out.println(object);
            return object;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Vector<Object> rowVector = data.get(rowIndex);
            rowVector.remove(columnIndex);
            rowVector.add(columnIndex, aValue);
            fireTableCellUpdated(rowIndex, columnIndex);//table, playerDao
            //dio koji snima u bazu izmijenjenog Kemala
          /*  int id = (int) rowVector.get(0);
            String firstName = (String) rowVector.get(1);
            String lastName = (String) rowVector.get(2);
            String sport = (String) rowVector.get(3);
            int ofYears = (int) rowVector.get(4);
            boolean vegetarian = (boolean) rowVector.get(5);
            PlayerInfo playerInfo = new PlayerInfo(id, firstName, lastName, sport, ofYears, vegetarian);
            playerDao.update(playerInfo);*/
        }

    }
}
