package gui.five;

import advanced.konsultacije.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

public class PlayerInfoDao implements Dao<PlayerInfo> {

    private final DerbyConnectionPool connectionPool;

    public PlayerInfoDao(DerbyConnectionPool connectionPool) {
        this.connectionPool = Optional.ofNullable(connectionPool).orElseThrow(() -> new RuntimeException("Ja, player info dao ne primam null connection pool object!!"));
    }

    @Override
    public void save(PlayerInfo entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PlayerInfo> getAll() {
        String sqlQuery = "SELECT * FROM PUSKA.PLAYERINFO FETCH FIRST 100 ROWS ONLY";
        List<PlayerInfo> listOfPlayers = new ArrayList<>();
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sqlQuery);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PlayerInfo playerInfo = new PlayerInfo(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString(4), rs.getInt(5), rs.getBoolean(6));
                listOfPlayers.add(playerInfo);
            }
            connectionPool.releaseConnection(connection);
            return listOfPlayers;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Vector getColumnNames() {
        String sqlQuery = "SELECT * from playerinfo";
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ResultSet rs = ps.executeQuery();) {
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            Vector<Object> columnNames = new Vector<>(columns);
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(resultSetMetaData.getColumnName(i));
            }
            connectionPool.releaseConnection(connection);
            return columnNames;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public PlayerInfo get(int primaryKey) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(PlayerInfo entity)  {
        System.out.println(entity);
        String sql = "UPDATE PLAYERINFO SET SPORT=? WHERE id=?";
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, entity.getSport());
            ps.setInt(2, entity.getId());
            ps.execute();
            connectionPool.releaseConnection(connection);
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(PlayerInfo entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
