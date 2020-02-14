package advanced.konsultacije.car.dao;

import advanced.konsultacije.Dao;
import advanced.konsultacije.car.entity.Car;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDAO implements Dao<Car> {

    private Connection connection;

    public CarDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Car> getAll() throws SQLException {
        List<Car> cars = new ArrayList<>();
        String sqlStatement = "SELECT *FROM CAR";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlStatement);
        while (resultSet.next()) {
            cars.add(new Car(resultSet.getInt(1),// 
                    resultSet.getString(2),//
                    resultSet.getString(3),//
                    resultSet.getString(4), //
                    resultSet.getDate(5)));
        }
        return cars;
    }

    @Override
    public Car get(int primaryKey) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Car entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Car entity) throws SQLException {
        String sqlInsertStatement = "INSERT INTO car "
                + "(id, `carName`, `carType`, `description`, `manufacturinDate`) "
                + "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sqlInsertStatement);
        statement.setInt(1, entity.getId());
        statement.setString(2, entity.getCarName());
        statement.setString(3, entity.getCarType());
        statement.setString(4, entity.getDescription());
        statement.setDate(5, entity.getManufacturinDate());
        statement.executeUpdate();
    }

    @Override
    public void update(Car entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
