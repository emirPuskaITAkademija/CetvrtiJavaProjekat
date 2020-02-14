package advanced.konsultacije;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;

public class ConsultationExecutor {
    
    static final String URL = "jdbc:mysql://localhost:3306/socialnetwork";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
    public static void main(String[] args) {
        //1.POVEZATI SE NA BAZU
        //Connection objekat kojeg dobijem iz DriverManager
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
            int id = 2;
            String carName = "Audi A7";
            String carType = "Luksuzno";
            String carDescription = "Rijadov omiljeni auto";
            LocalDate manufacturingDate = LocalDate.of(2019, Month.MARCH, 1);
            Date manufacturinDate = Date.valueOf(manufacturingDate);
            //2. Statemenet iz Connection
            String sqlInsertStatement = "INSERT INTO car "
                    + "(id, `carName`, `carType`, `description`, `manufacturinDate`) "
                    + "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sqlInsertStatement);
            statement.setInt(1, id);
            statement.setString(2, carName);
            statement.setString(3, carType);
            statement.setString(4, carDescription);
            statement.setDate(5, manufacturinDate);
            statement.executeUpdate();
            
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
