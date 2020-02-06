/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Grupa2
 */
public class TestExecutor {
    public static void main(String[] args) throws SQLException{
        Connection connection  = DriverManager.getConnection("jdbc:mysql://localhost:3309/sakila", "root", "");
        Statement statement = connection.createStatement();
        String sql = "select * from sakila.actor limit 100";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println(resultSet.getString(2));
        }
    }
}
