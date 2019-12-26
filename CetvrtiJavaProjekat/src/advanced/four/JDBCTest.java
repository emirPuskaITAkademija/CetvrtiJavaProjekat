package advanced.four;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "", "");
    }
}
