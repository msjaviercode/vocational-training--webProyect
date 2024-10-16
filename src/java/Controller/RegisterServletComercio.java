/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BBDD.tables.Comercio;
import BBDD.utilities.UserManagement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author javier
 */
public class RegisterServletComercio extends HttpServlet {
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String businessName, email, country, city,fulladdress ,stateOrProvince, cp, password;
        
        businessName = request.getParameter("businessName");
        email = request.getParameter("email");
        country = request.getParameter("country");
        fulladdress = request.getParameter("fulladdress");
        city = request.getParameter("city");
        stateOrProvince = request.getParameter("stateOrProvince");
        password = request.getParameter("password");
        cp = request.getParameter("cp");
        

        Comercio comercio = null;
        comercio = UserManagement.registroComercio(businessName, email, password, country, fulladdress, city, stateOrProvince, cp, false);


        if (comercio !=null){
                response.sendRedirect("index.jsp");
                
             } else {
                 response.sendRedirect("rbusiness.jsp");

            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
