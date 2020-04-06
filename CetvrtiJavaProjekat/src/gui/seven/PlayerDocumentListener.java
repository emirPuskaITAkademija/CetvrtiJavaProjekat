/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.seven;

import java.util.regex.PatternSyntaxException;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Grupa2
 */
public class PlayerDocumentListener implements DocumentListener {

    static final int COLUMN_TO_FILTER = 3;
    
    private JTextField textField;
    private TableRowSorter<PlayerPanel.OurTableModel> tableRowSorter;

    public PlayerDocumentListener(JTextField textField, TableRowSorter<PlayerPanel.OurTableModel> rowSorter) {
        this.textField = textField;
        this.tableRowSorter = rowSorter;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        filter();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        filter();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        filter();
    }

    private void filter() {
        RowFilter<PlayerPanel.OurTableModel, Object> rowFilter = null;
        //ako ne prođe regularni izraz ne azuriraj JTable
        try {
            //broj 4 
            rowFilter = RowFilter.regexFilter(textField.getText(), COLUMN_TO_FILTER);
        } catch (PatternSyntaxException exception) {
            return;
        }
        tableRowSorter.setRowFilter(rowFilter);
    }
}
