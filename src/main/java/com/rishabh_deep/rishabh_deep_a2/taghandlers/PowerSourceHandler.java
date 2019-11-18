package com.rishabh_deep.rishabh_deep_a2.taghandlers;

import com.rishabh_deep.rishabh_deep_a2.db.DBConnector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Custom Tag Handler to display power sources in database in select/option
 * statements
 *
 * @author Rishabh
 */
public class PowerSourceHandler extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        //writer for tag handler class
        JspWriter out = getJspContext().getOut();
        Connection conn;
        PreparedStatement statement;
        ResultSet rs;

        try {
            //get connection from DBConnector class
            conn = DBConnector.getConnection();

            //prepare sql query and create statement
            String sql = "SELECT * from PowerSource";
            statement = conn.prepareStatement(sql);
            //get all data from executed query into result set
            rs = statement.executeQuery();

            //select statement with power source data to be as its options
            String output = "<select name='sourceSelected'>";

            //access each column data row by row
            while (rs.next()) {
                output += "<option value='" + rs.getString(1) + "'>" + rs.getString(2);
            }
            output += "</select>";
            out.println(output);//print output where tag handler is called using custom tags
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            //display exception reason
            out.print(ex.toString());
        } catch (Exception ex) {
            out.println(ex.toString());
        }
    }
}
