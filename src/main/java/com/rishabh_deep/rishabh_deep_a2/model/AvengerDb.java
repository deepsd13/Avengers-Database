package com.rishabh_deep.rishabh_deep_a2.model;

import com.rishabh_deep.rishabh_deep_a2.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * AvengerDb class that gets the database connection and modify data in database
 * using SQL statements
 *
 * @author Rishabh
 * @author Deep
 */
public class AvengerDb {

    /**
     * Method to add avenger to database
     *
     * @param avenger avenger to add to database
     * @return number of rows affected
     * @throws Exception
     */
    public static int addAvenger(Avenger avenger) throws Exception {
        //declaring variable
        Connection conn = null;
        PreparedStatement statement = null;//preparedStatement for performance and prevent sql injection
        int rs;//get number of rows affected
        try {
            //get connection from DBConnector class
            conn = DBConnector.getConnection();

            //sql statement insert avenger to database
            String sql = "INSERT INTO Avengers (avengerName,description,powersource)" + " VALUES (?,?,?)";
            statement = conn.prepareStatement(sql);//prepare statement
            //set data into prepared statement
            statement.setString(1, avenger.getName());
            statement.setString(2, avenger.getDescription());
            statement.setInt(3, avenger.getPowerSource().getId());
            //execute statement
            rs = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            //throw exception 
            throw new Exception(ex.toString());
        } finally {
            //call closeJDBCObjects() from DBConnector to close jdbc objects
            DBConnector.closeJDBCObjects(conn, statement);
        }
        return rs;
    }

    /**
     * Method to remove avenger from database
     *
     * @param avenger avenger to remove from database
     * @return number of rows affected
     * @throws Exception
     */
    public static int removeAvenger(Avenger avenger) throws Exception {
        //declaring variables
        Connection conn = null;
        PreparedStatement statement = null;
        int rs;
        try {
            //get connection from DBConnector class
            conn = DBConnector.getConnection();
            //sql query to delete the selected avenger
            String sql = "DELETE FROM Avengers WHERE avengerName = ? ";
            //prepare statement
            statement = conn.prepareStatement(sql);
            statement.setString(1, avenger.getName());
            //execute statement
            rs = statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            throw new Exception(ex.toString());
        } finally {
            //call closeJDBCObjects() from DBConnector to close jdbc objects
            DBConnector.closeJDBCObjects(conn, statement);
        }
        return rs;
    }

    /**
     * Display avengers retrieved from database
     *
     * @return arrayList of avengers
     * @throws Exception
     */
    public static ArrayList<Avenger> getAvengers() throws Exception {

        //variables
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;//resultset to get the result of select statements and access elements of database 
        ArrayList<Avenger> avengers = new ArrayList<>();

        try {
            //get connection from DBConnector class
            conn = DBConnector.getConnection();

            //get all rows from Avengers database
            String sql = "SELECT * FROM Avengers";
            //prepare statement using query
            statement = conn.prepareStatement(sql);
            //execute and get result of the query
            rs = statement.executeQuery();
//            PowerSourceDb powerSourceDb = new PowerSourceDb();
            //Access each column of table through result set
            while (rs.next()) {
                avengers.add(new Avenger(
                        Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), PowerSourceDb.getPowerSource(Integer.parseInt(rs.getString(4))))
                );
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            //call closeJDBCObjects() from DBConnector to close jdbc objects
            DBConnector.closeJDBCObjects(conn, statement, rs);
        }
        //return arrayList of avengers to GetAvengers.java taht is forwarded to jsp page to display content
        return avengers;
    }
}
