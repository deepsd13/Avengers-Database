package com.rishabh_deep.rishabh_deep_a2.servlets;

import com.rishabh_deep.rishabh_deep_a2.model.PowerSourceDb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Removes a powersource entered by the user
 *
 * @author Deep
 * @author Rishabh
 */
public class RemovePowerSource extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int result = 0;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
        try {
            //instantiating PrintWriter object out by calling response.getWriter()
            out = response.getWriter();
            int pwId = Integer.parseInt(request.getParameter("sourceSelected"));//get PowerSource selected to delete
            String description = PowerSourceDb.getPowerSource(pwId).getDescription();
            //remove PowerSource by calling method from POwerSourceDb from the database
            result = PowerSourceDb.removePowersource(pwId);

            //check if result of adding avenger is successful or not
            String message = description + " removed successfully!<br><br>";

            //display result of adding the avenger
            headerOut(out, request);
            out.println("<h1><img src=\"" + request.getContextPath() + "/assets/marvel.png\" alt=\"marvel studios\" height=\"120\" width=\"600\"></h1>\n");
            out.println("<h1>" + message + "</h1>");
            out.println("<form action='GetAvengers.do' method='GET'>");
            out.println("<div id='nav-container'>");
            out.println("<input type ='submit' value ='Display Avengers'>");
            out.println("</div>");
            out.println("</form>");
            out.println("\n<br><br><a style='margin-left:130px'  href='index.html'>Main Page</a>");
            footerOut(out);
        } catch (Exception ex) {
            headerOut(out, request);
            //display error for caused by foreign key reference 
            if (result != 1) {
                out.println("<h1>OOPS!!!<br><br>PowerSource does not exist or looks like some Avenger is having this powersource."
                        + "You are not allowed to remove any powersource that is attached to an Avenger."
                        + " Remove that avenger first!</h1>");
            }
            out.println("<a style='margin-left:130px'  href='index.html'>Main Page</a>");
            footerOut(out);
        }

    }

    /**
     * Footer of the HTML document
     *
     * @param out printing content on webpage
     */
    private void footerOut(PrintWriter out) {
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Header of the HTML document
     *
     * @param out printing content on webpage
     */
    private void headerOut(PrintWriter out, HttpServletRequest request) {
        //display result after removing the power source
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Remove Power Source</title>");
        out.println("<link rel=\"stylesheet\" href='" + request.getContextPath() + "/CSS/main.css'  type= 'text/css'> ");
        out.println("<link href='https://fonts.googleapis.com/css?family=Paprika' rel='stylesheet'>\n");
        out.println("</head>");
        out.println("<body>");
    }

}
