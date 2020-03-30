package gui.six.swing;

import gui.five.DerbyConnectionPool;
import gui.five.PlayerInfoDao;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PlayerInfoFrame extends JFrame {

    private final JComponent component;

    public PlayerInfoFrame(String title, JComponent component) {
        super(title);
        this.component = component;
    }

    public void showFrame() {
        add(component);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws SQLException, SQLException {

        //connection pool -> 10 connection objekata
        DerbyConnectionPool connectionPool = new DerbyConnectionPool();
        //CRUD-statements na SQL bazu
        PlayerInfoDao playerInfoDao = new PlayerInfoDao(connectionPool);
        //VIEW
        JComponent component = new PlayerInfoPanel(playerInfoDao);
        PlayerInfoFrame playerInfoFrame = new PlayerInfoFrame("Player info", component);
        SwingUtilities.invokeLater(playerInfoFrame::showFrame);
    }
}
