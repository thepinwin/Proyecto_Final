/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.resetpassProfesor;

import com.mycompany.campus.datamodel.crud.CrudCliente;
import com.mycompany.campus.resetpassCliente.*;
import com.mycompany.campus.datamodel.crud.CrudProfesor;
import com.mycompany.campus.datamodel.entities.Profesor;
import com.mycompany.campus.datamodel.entities.Newpass;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WEB 2
 */
@WebServlet(name = "ServletNewPassProf", urlPatterns = {"/ServletNewPassProf"})
public class ServletNewPassProf extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pass = request.getParameter("password1");

        String is = request.getParameter("is");
//===================
        CrudCliente crud = new CrudCliente();
        CrudProfesor crudProf = new CrudProfesor();
        
        Newpass newPass = crud.tokenFin(is);
        
        Profesor cli = crudProf.oneUser(newPass.getMail());


        if (newPass != null) {

            crudProf.newPass(cli.getId(), pass);

            RequestDispatcher rs = request.getRequestDispatcher("ServletNoLoginProfe");
            rs.forward(request, response);
        } else {

            RequestDispatcher rs = request.getRequestDispatcher("/WEB-INF/Layout.jsp");

            request.setAttribute("ok", "sep");

            request.setAttribute("pagina", "prof/ResetPassProf");

            rs.forward(request, response);
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
        processRequest(request, response);
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
