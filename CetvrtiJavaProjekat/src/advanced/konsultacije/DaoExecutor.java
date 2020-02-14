package advanced.konsultacije;

import advanced.konsultacije.car.dao.CarDAO;
import advanced.konsultacije.car.entity.Car;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class DaoExecutor {

    public static final String URL = "jdbc:mysql://localhost:3306/socialnetwork";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);) {
            CarDAO carDAO = new CarDAO(connection);
            List<Car> cars = carDAO.getAll();
            cars.forEach(System.out::println);
            Car car = new Car(3, "Citroen Piccaso", "Porodicno auto", "Za levate kao sto sam ja", Date.valueOf(LocalDate.now()));
            carDAO.save(car);
        } catch (SQLException sQLException) {
            System.err.println(sQLException.getMessage());
        }
    }

}
