package com.alextheedom.mysql;

import java.sql.*;

/**
 * Created by atheedom on 21/11/15.
 */
public class ReadDatabase {

    public static void main(String... args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.99.100:3333/MyDatabase?user=root&password=root+1");

        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons");

        while (resultSet.next()) {
            System.out.print(resultSet.getInt("PersonId"));
        }
    }

}
