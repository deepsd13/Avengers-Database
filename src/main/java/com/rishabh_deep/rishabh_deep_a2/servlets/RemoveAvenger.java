package com.rishabh_deep.rishabh_deep_a2.servlets;

import com.rishabh_deep.rishabh_deep_a2.model.Avenger;
import com.rishabh_deep.rishabh_deep_a2.model.AvengerDb;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to get the avenger to remove from jsp page and calls the
 * removeAvenger() of AvengerDb to remove it from database.
 *
 * @author Deep
 * @author Rishabh
 */
public class RemoveAvenger extends HttpServlet {

    /**
     * Processes requests for HTTP <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null; // declare PrintWriter object out
        int result = 0;
        try {
            out = response.getWriter(); //instantiating PrintWriter object
            //get avenger name from form
            String name = request.getParameter("avenger");
            Avenger avenger = new Avenger();
            avenger.setName(name);
            //call removeAvenger() to remove avenger from database
            result = AvengerDb.removeAvenger(avenger);

            headerOut(out, request);
            out.println("<h1><img src=\"" + request.getContextPath() + "/assets/marvel.png\" alt=\"marvel studios\" height=\"120\" width=\"600\"></h1>\n");
            out.println("<h1>" + name + " removed successfully!</h1>");
            out.println("<form action='GetAvengers.do' method='GET'>");
            out.println("<div id='nav-container'>");
            out.println("<input type ='submit' value ='Display Avengers'>");
            out.println("</div><br><br><br>");
            out.println("</form>");
            out.println("<a style='margin-left:130px'  href ='index.html'>Main Page</a>");
            footerOut(out);
        } catch (Exception ex) {
            headerOut(out, request);
            //display error for caused by foreign key reference 
            if (result != 1) {
                out.println("<h2>Error!!!<br><br>Avenger does not exist!</h2>");
                out.println("<h2>"+ex.toString()+"</h2>");
            }
            out.println("<a style='margin-left:130px' href='index.html'>Main Page</a>");
            footerOut(out);
        }
    }

    private void footerOut(PrintWriter out) {
        out.println("</body>");
        out.println("</html>");
    }

    private void headerOut(PrintWriter out, HttpServletRequest request) {
        //display result of the query executed after removing the avenger
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Remove Avenger</title>");
        out.println("<link rel=\"stylesheet\" href='" + request.getContextPath() + "/CSS/main.css'  type= 'text/css'> ");
        out.println("<link href='https://fonts.googleapis.com/css?family=Paprika' rel='stylesheet'>\n");
        out.println("</head>");
        out.println("<body>");
    }

}
