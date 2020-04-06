/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.seven;

import gui.five.PlayerInfo;
import gui.five.PlayerInfoDao;
import java.util.Vector;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Grupa2
 */
public class PlayerTableModelListener implements TableModelListener {

    private PlayerInfoDao playerInfoDao;

    public PlayerTableModelListener(PlayerInfoDao playerInfoDao) {
        this.playerInfoDao = playerInfoDao;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        PlayerPanel.OurTableModel tableModel = (PlayerPanel.OurTableModel) e.getSource();
        String columnName = tableModel.getColumnName(column);
        Object data = tableModel.getValueAt(row, column);
        Vector<Object> rowVector = tableModel.getRowData(row);
        int id = (int) rowVector.get(0);
        String firstName = (String) rowVector.get(1);
        String lastName = (String) rowVector.get(2);
        String sport = (String) rowVector.get(3);
        int ofYears = (int) rowVector.get(4);
        boolean vegetarian = (boolean) rowVector.get(5);
        PlayerInfo playerInfo = new PlayerInfo(id, firstName, lastName, sport, ofYears, vegetarian);
        playerInfoDao.update(playerInfo);
    }

}
