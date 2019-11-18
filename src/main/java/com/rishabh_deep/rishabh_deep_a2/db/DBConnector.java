/*
     * A class used to establish JDBC Connections.
 */
package com.rishabh_deep.rishabh_deep_a2.db;

import java.sql.*;

/**
 * DBConnector class to instantiate driver, establish a connection with the sql
 * and return the connection for implementation
 *
 * @author deep
 * @author rishabh
 */
public class DBConnector {

    // private member variable to hold the connection
    private static Connection conn = null;

    /**
     * A method that will connect to the specified JDBC driver
     *
     * @throws java.lang.Exception throws an exception back to caller when
     * error...
     * @return connection
     */
    public static Connection getConnection() throws Exception {

        if (conn == null || conn.isClosed()) {
            //connecting to the sql database 
            try {
                String driver = "org.postgresql.Driver";
                String dbUrl = System.getenv("JDBC_DATABASE_URL");
                // load the class into the JVM. Doing runs the code that
                // registers the class as a JDBC driver
                Class.forName(driver).newInstance();
                if (dbUrl != null && dbUrl.length() > 0) {
                    conn = DriverManager.getConnection(dbUrl);
                } else {
                    // Class.forName(driver).newInstance();
                    String connUrl = "jdbc:postgresql://localhost/MyDb";

                    // username and password 
                    String user = "postgres";
                    String pass = "Deep@697";

                    // get the connection from the DriverManager
                    conn = DriverManager.getConnection(connUrl, user, pass);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
                // Build the error message
                StringBuilder message = new StringBuilder(e.getMessage()).append("\n");
                if (e instanceof SQLException) {
                    message.append(((SQLException) e).getSQLState()).append("\n");
                    message.append(((SQLException) e).getErrorCode()).append("\n");
                    message.append(((SQLException) e).getMessage()).append("\n");
                }
                // throw the exception to the caller!
                throw new Exception(message.toString());
            }
        }
        // return the connection
        return conn;
    }

    /**
     * Method to close all of the JDBC objects.
     *
     * @param conn connection to close
     * @param stmt statement to close (note that PreparedStatement is a
     * Statement)
     * @param rs ResultSet to close
     */
    public static void closeJDBCObjects(Connection conn, Statement stmt, ResultSet rs) {

        // This will ensure that all objects are always closed.
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception ignored) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception ignored) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception ignored) {
            }
        }
    }

    /**
     * Method to close Connection and Statement only. Used when ResultSet is not
     * needed
     *
     * @param conn connection to close
     * @param stmt statement to close
     */
    public static void closeJDBCObjects(Connection conn, Statement stmt) {
        // calling the overloaded implementation
        closeJDBCObjects(conn, stmt, null);
    }
}
