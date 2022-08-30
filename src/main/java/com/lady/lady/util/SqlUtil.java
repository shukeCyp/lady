package com.lady.lady.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlUtil {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/lady?serverTimezone=GMT";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "peng2001";

    public static Connection makeConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
