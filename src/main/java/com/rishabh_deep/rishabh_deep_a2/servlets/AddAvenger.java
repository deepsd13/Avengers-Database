package com.rishabh_deep.rishabh_deep_a2.servlets;

import com.rishabh_deep.rishabh_deep_a2.model.Avenger;
import com.rishabh_deep.rishabh_deep_a2.model.AvengerDb;
import com.rishabh_deep.rishabh_deep_a2.model.PowerSourceDb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to get form data and call addAvenger method to add data to the
 * database
 *
 * @author Rishabh
 * @author Deep
 */
public class AddAvenger extends HttpServlet {

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
        PrintWriter out = null;
        int result = 0;
        try {
            //instantiating PrintWriter object
            out = response.getWriter();

            //get form parameters
            String name = request.getParameter("name");
            String description = request.getParameter("description");

            //check if the field are empty or not
            if (name.isEmpty()) {
                response.sendError(500);//call error page to display the error
            } else if (description.isEmpty()) {
                response.sendError(500); //call error page to display the error
            } else {
                //get powersource id from the selected powersource
                int powerSource = Integer.parseInt(request.getParameter("sourceSelected"));

                //call addAvenger method from AvengerDb and send parameters to insert record into database
                result = AvengerDb.addAvenger(new Avenger(name, description, PowerSourceDb.getPowerSource(powerSource)));

                String message = name + " added successfully!<br><br>";

                //display result of adding the avenger
                headerOut(out, request);
                out.println("<h1><img src=\"" + request.getContextPath() + "/assets/marvel.png\" alt=\"marvel studios\" height=\"120\" width=\"600\"></h1>\n");
                out.println("<h1>" + message + "</h1>");
                out.println("<form action='GetAvengers.do' method='GET'>");
                out.println("<div id='nav-container'>");
                out.println("<input type ='submit' value ='Display Avengers'>");
                out.println("</div>");
                out.println("</form>");
                out.println("\n<br><br><a style='margin-left:130px' href='index.html'>Main Page</a>");
                footerOut(out);
            }
        } catch (Exception ex) {
            headerOut(out, request);
            //display error for caused by foreign key reference 
            if (result != 1) {
                out.println("<h2>Error!!!<br><br>Avenger was not added</h2>");
            }
            out.println("<a style='margin-left:130px' href='index.html'>Main Page</a>");
            footerOut(out);
        }
    }

    /**
     * Footer of the HTMl document
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
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title> avenger</title>");
        out.println("<link rel=\"stylesheet\" href='" + request.getContextPath() + "/CSS/main.css'  type= 'text/css'> ");
        out.println("<link href='https://fonts.googleapis.com/css?family=Paprika' rel='stylesheet'>\n");
        out.println("</head>");
        out.println("<body>");
    }

}
