package advanced.konsultacije.book.dao;

import advanced.konsultacije.Dao;
import advanced.konsultacije.book.entity.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookDAO implements Dao<Book> {

    private Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book get(int primaryKey) throws SQLException {
        String sqlQuery = "SELECT *FROM Book WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, primaryKey);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return new Book(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getDate(5));
        } else {
            return null;
        }
    }

    @Override
    public void delete(Book entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Book entity) throws SQLException {
        
        String sqlInsertStatement = "INSERT INTO book (`bookName`, `authorName`, `publisher`, `publishingDate`)\n"
                + "VALUES(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sqlInsertStatement);
        statement.setString(1, entity.getBookName());
        statement.setString(2, entity.getAuthorName());
        statement.setString(3, entity.getPublisher());
        statement.setDate(4, entity.getPublishingDate());
        statement.executeUpdate();
    }

    @Override
    public void update(Book entity) throws SQLException {
        String sqlStatement = "UPDATE book SET `bookName`=?, `authorName`=?, publisher=? WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sqlStatement);
        ps.setString(1, entity.getBookName());
        ps.setString(2, entity.getAuthorName());
        ps.setString(3, entity.getPublisher());
        ps.setInt(4, entity.getId());
        ps.executeUpdate();
    }

}
