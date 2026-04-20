package com.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";       
    private static final String PASSWORD = "root"; //change password according to my systems password 

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found. Make sure the JAR is in WEB-INF/lib/");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
