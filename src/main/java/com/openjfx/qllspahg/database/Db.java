package com.openjfx.qllspahg.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
public class Db {
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
//                DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
                Properties props = loadProperties(); //Mo db.properties
                String url = props.getProperty("dburl"); //Lay url tu db.properties
                String user = props.getProperty("user"); //Lay user tu db.properties
                String password = props.getProperty("password"); //Lay password tu db.properties
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Database connect");
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Database close connect");
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }


}
