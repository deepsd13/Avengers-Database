package com.rishabh_deep.rishabh_deep_a2.servlets;

import com.rishabh_deep.rishabh_deep_a2.model.Avenger;
import com.rishabh_deep.rishabh_deep_a2.model.AvengerDb;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to get avenger as a arraylist and forward to the jsp page to display
 * @author Rishabh
 * @author Deep
 */
public class GetAvengers extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
//            AvengerDb avengerDb = new AvengerDb();
            //get avengers as an arrayList
            ArrayList<Avenger> avengers = AvengerDb.getAvengers();
            request.setAttribute("avengers", avengers);
            //forward request to jsp page
            RequestDispatcher rd = request.getRequestDispatcher("/displayAvengers.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            //set ex.toString() as error in request attribute
           request.setAttribute("error", ex.toString());
        }
    }
}
