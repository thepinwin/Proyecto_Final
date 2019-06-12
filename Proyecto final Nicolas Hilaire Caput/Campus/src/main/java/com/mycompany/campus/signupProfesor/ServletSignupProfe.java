/*/
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.signupProfesor;

import com.mycompany.campus.datamodel.crud.CrudEmpresa;
import com.mycompany.campus.datamodel.crud.CrudProfesor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thepinguin
 */
@WebServlet(name = "ServletSignupProfe", urlPatterns = {"/ServletSignupProfe"})
public class ServletSignupProfe extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");

        String cif = request.getParameter("cif");

        if (cif != null) {
            String nom = request.getParameter("nombre");
            String mail = request.getParameter("mail");
            String contra = request.getParameter("password");
            String com = request.getParameter("comunidad");

            CrudEmpresa curs = new CrudEmpresa();

            curs.newEmpresa(nom, mail, contra, com, cif);

//            RequestDispatcher rs = request.getRequestDispatcher("ServletIndex");
//
//            rs.forward(request, response);
            response.sendRedirect("ServletIndex");

        } else {

            String nom = request.getParameter("nombre");
            String apell = request.getParameter("apellido");
            String mail = request.getParameter("mail");
            String contra = request.getParameter("password");
            String com = request.getParameter("comunidad");
            String dni = request.getParameter("dni");

            CrudProfesor crud = new CrudProfesor();

            crud.newProfesor(nom, apell, mail, contra, com, dni);

//            RequestDispatcher rs = request.getRequestDispatcher("ServletIndex");
//
//            rs.forward(request, response);
            response.sendRedirect("ServletIndex");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(ServletSignupProfe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(ServletSignupProfe.class.getName()).log(Level.SEVERE, null, ex);
        }
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
