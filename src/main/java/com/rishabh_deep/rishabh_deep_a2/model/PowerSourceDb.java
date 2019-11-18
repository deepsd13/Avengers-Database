package com.rishabh_deep.rishabh_deep_a2.model;

import com.rishabh_deep.rishabh_deep_a2.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * PowerSourceDb class that gets the database connection and modify data in
 * database using SQL statements
 *
 * @author Rishabh
 * @author Deep
 */
public class PowerSourceDb {

    private static ArrayList<PowerSource> powerSource; // arrayList of powersource

    /**
     * Get powersources from database as an arraylist
     *
     * @return arrauList of power source
     * @throws Exception
     */
    public static ArrayList<PowerSource> getPowerSource() throws Exception {
        powerSource = new ArrayList<>();
        Connection conn;
        ResultSet rs;
        PreparedStatement statement;
        try {
            //get connection from DBConnector class
            conn = DBConnector.getConnection();

            //prepare statement and execute result
            String sql = "SELECT * from PowerSource";
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                powerSource.add(new PowerSource(Integer.parseInt(rs.getString(1)), rs.getString(2)));
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {

        }
        return powerSource;
    }

    /**
     *
     * @param id id to retrieve a powerSource
     * @return powerSource with a particular id
     * @throws Exception
     */
    public static PowerSource getPowerSource(int id) throws Exception {
        powerSource = new ArrayList<>();
        Connection conn;
        PreparedStatement statement;
        ResultSet rs;
        try {
            //get connection from DBConnector class
            conn = DBConnector.getConnection();

            //prepare statement and execute result
            String sql = "SELECT * from PowerSource";
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            //get each column
            while (rs.next()) {
                //add new powerSource from database to arrayList
                powerSource.add(new PowerSource(Integer.parseInt(rs.getString(1)), rs.getString(2)));
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            throw new Exception(ex.toString());
        }
        return powerSource.get(id - 1);
    }

    /**
     *
     * @param pw powerSource to add to database
     * @return number of rows affected
     * @throws Exception
     */
    public static int addPowerSource(PowerSource pw) throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        int rs = 0;
        try {
            //get connection from DBConnector class
            conn = DBConnector.getConnection();

            //prepare statement and execute result
            String sql = "INSERT INTO PowerSource (id,description)" + " VALUES(?,?)";

            statement = conn.prepareStatement(sql);

            //set place holders in sql query
            statement.setInt(1, pw.getId());
            statement.setString(2, pw.getDescription());
            //execute and update
            rs = statement.executeUpdate();

        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            throw new Exception(ex.toString());
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        } finally {
            //close objects
            DBConnector.closeJDBCObjects(conn, statement);
        }

        return rs;
    }

    /**
     *
     * @param id powerSource id
     * @return rs - number of rows affected
     * @throws Exception
     */
    public static int removePowersource(int id) throws Exception {

        Connection conn = null;
        PreparedStatement statement = null;
        int rs;
        try {
            //get connection from DBConnector class
            conn = DBConnector.getConnection();

            //prepare statement and execute result
            String sql = "DELETE FROM PowerSource WHERE id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);//set place holder value id
            rs = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            throw new Exception(ex.toString());
        } finally {
            //close objects
            DBConnector.closeJDBCObjects(conn, statement);
        }
        return rs;
    }
}
