package gui.five;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
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

    /*
    1. List<Connection> connection = DriverManager.getConnection();
    connectionPool
    2. Statement, PreparedStatement ili Callable -> connection
    3. ResultSet resultSet -> ps
    */
    public static void main(String[] args) throws SQLException, SQLException {

        String URL = "jdbc:derby://localhost:1527/gui";
        String USERNAME = "puska";
        String PASSWORD = "puska";
        //connection pool -> 10 connection objekata
        DerbyConnectionPool connectionPool = new DerbyConnectionPool(URL, USERNAME, PASSWORD);
        //CRUD-statements na SQL bazu
        PlayerInfoDao playerInfoDao = new PlayerInfoDao(connectionPool);
        //VIEW
        JComponent component = new PlayerInfoPanel(playerInfoDao);
        PlayerInfoFrame playerInfoFrame = new PlayerInfoFrame("Player info", component);
        SwingUtilities.invokeLater(playerInfoFrame::showFrame);
    }
}
