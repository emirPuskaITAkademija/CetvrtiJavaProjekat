package gui.four.table;

import advanced.konsultacije.book.dao.BookDAO;
import advanced.konsultacije.book.entity.Book;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
//Zadaća 1: GUI
//1. Kreirati tabelu sa ovim kolonama u bazi SQL(MySql)
//2. U kodu učitati imena kolona tabele u bazi
//3. Učitati redove iz te tabele
//4. Kako povezati te podatke i prikazati ih na grafičkom interfejsu
//emir.puska@it-akademija.com

public class SimpleTablePanel extends JPanel {

    static final String[] COLUMN_NAMES = {"First name", "Last name", "Sport", "# of Years", "Vegetarian"};
    static final Object[][] ROW_DATA = {
        {"Kanita", "Muzaferija", "Snowboarding", new Integer(3), new Boolean(false)},
        {"Ferida", "Bobar", "Skiing", new Integer(5), new Boolean(true)},
        {"Rijad", "Rogo", "Walking", new Integer(25), new Boolean(false)},
        {"Mirzad", "Sadović", "Swimming", new Integer(7), new Boolean(true)},
        {"Fadil", "Turalić", "Tennis", new Integer(2), new Boolean(true)}
    };

    public SimpleTablePanel() {
        super(new GridLayout(1, 0));
        /* Vector<String> vectorNames = bookColumnNames
                .stream()
                .collect(Collectors.toCollection(Vector::new));
        Vector<Book> vectorBooks = bookList
                .stream()
                .collect(Collectors.toCollection(Vector::new));
        JTable table1 = new JTable(vectorBooks, vectorNames);*/
        JTable table = new JTable(ROW_DATA, COLUMN_NAMES);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        MouseAdapter mouseAdapter = new TableMouseAdapter(table);
        table.addMouseListener(mouseAdapter);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private class TableMouseAdapter extends MouseAdapter {

        private final JTable table;

        public TableMouseAdapter(JTable table) {
            this.table = table;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int numRows = table.getRowCount();
            int numCols = table.getColumnCount();
            TableModel tableModel = table.getModel();
            System.out.println("Vrijednosti podataka u tabeli:");
            for (int rowNumber = 0; rowNumber < numRows; rowNumber++) {
                System.out.print(" red " + rowNumber + ":");
                for (int columnNumber = 0; columnNumber < numCols; columnNumber++) {
                    System.out.print(" " + tableModel.getValueAt(rowNumber, columnNumber));
                }
                System.out.println();
            }
            System.out.println("------------------------");
        }

    }
}
