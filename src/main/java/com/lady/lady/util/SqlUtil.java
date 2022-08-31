package com.lady.lady.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlUtil {

    private static final String URL = "jdbc:mysql://10.0.8.15:3306/shuke?serverTimezone=GMT";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Abc@123456";

    public static Connection makeConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
