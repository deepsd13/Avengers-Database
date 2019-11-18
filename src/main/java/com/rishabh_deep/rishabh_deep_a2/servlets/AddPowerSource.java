package com.rishabh_deep.rishabh_deep_a2.servlets;

import com.rishabh_deep.rishabh_deep_a2.model.PowerSource;
import com.rishabh_deep.rishabh_deep_a2.model.PowerSourceDb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Deep Shah
 */
public class AddPowerSource extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = null;
        int result = 0;

        try {
            out = response.getWriter();

            String pw = request.getParameter("powersource");
            if (pw.isEmpty()) {
                response.sendError(500);
            } else {

                PowerSource powersource = new PowerSource();
                powersource.setDescription(pw);
                int totalPWInDb = PowerSourceDb.getPowerSource().size();
                powersource.setId(PowerSourceDb.getPowerSource().get(totalPWInDb - 1).getId() + 1);
                result = PowerSourceDb.addPowerSource(powersource);

                String message = pw + " added successfully!<br><br>";

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
                out.println("<h2>Error!!!<br><br>PowerSource was not added</h2>");
            }
            out.println("<a style='margin-left:130px'  href='index.html'>Main Page</a>");
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
